import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';

const TodoList = () => {

        const {setTodoList, setLoginMember, loginMember, todoList} = useContext(TodoListContext);

        const [inputTodo, setInputTodo] = useState('');

        // 할 일 추가
        const handleAddTodo = () => {

            // 입력 x
            if(inputTodo.trim().length == 0){
                alert('할 일을 입력해주세요.');
                return;
            }
            
            fetch("/todo", {
                method : "POST",
                headers : {
                    'Content-Type' : 'application/json',
                    'Accept' : 'application/json'
                },
                body : JSON.stringify({
                    title : inputTodo,
                    todoMemberNo : loginMember.todoMemberNo
                })
                
            })
            .then(resp => resp.text())
            .then(todoNo => {
                if(Number(todoNo) === 0){ // 실패시 멈추기
                    return;
                }

                // 기존 todoList + 새로 추가된 Todo를 이용해
                // 새 배열을 만들어 todoList에 대입

                // 새로 추가된 Todo 만들기
                const newTodo = {todoNo: todoNo, title: inputTodo, isDone: 'X', 
                todoMemberNo: loginMember.todoMemberNo};

                const newTodoList = [...todoList, newTodo];// [  -> [ {       todoList        }, {       todoList        } ] <- , { newTodo }  ]
                setTodoList(newTodoList); 
                setInputTodo('');
                
                // 기존 todoList + newTodo를 이용해 새 배열 만들기
                // todoList에 대입

            })
            .catch( e => console.log(e));


        }

        // O,X 업데이트
        const handleToggleTodo = (todo, index) => {
                       
            console.log(todo);
            console.log(index);

            fetch("/todo",{
                method:"PUT",
                headers:{
                    'Content-Type' : 'application/json',
                    'Accept' : 'application/json'
                },
                body : JSON.stringify({
                    todoNo : todo.todoNo,
                    isDone : todo.isDone === 'O' ? 'X' : 'O'
                })
            })
            .then(resp => resp.text())
            .then(result => {
                if(Number(result) === 0){ // 실패시 멈추기
                    return;
                }

                console.log("suc")
                // 수정 성공 시 todoList의 값을 변경해서 리렌더링되게끔
                
                const newTodoList = [...todoList];

                newTodoList[index].isDone = newTodoList[index].isDone === "O" ? "X" : "O";

                setTodoList(newTodoList)
                
                setInputTodo('');

                //const newTodoList = [...todoList, newTodo];
                //setTodoList(newTodoList);

                // todoList를 깊은 복사(똑같은 배열을 하나 더 만듬)
                //const TodoListCopy = {newTodolist};
                // O, X로 리렌더링
                
                // [] index번째 요소의 O,X를 반대로 변경하고 화면에 뿌려질 수 있게



            })
            .catch(e => console.log(e));

        }

        // 삭제
        const handleDeleteTodo = (todoNo, index) => { // todoNo은 객체가 아니라 json.stringify를 안하는거

            console.log(todoNo);
            console.log(index);

            fetch("/todo",{
                method:"DELETE",
                headers:{
                    'Content-Type' : 'application/json',
                    'Accept' : 'application/json'
                },
                body : todoNo // json 인데 객체아니고 그냥 int값
            })
            .then(resp => resp.text())
            .then(result => {
                if(Number(result) === 0){ // 실패시 멈추기
                    return;
                }
                
                // 배열.splice(인덱스, 몇칸)
                // -> 배열의 인덱스 번 째 요소부터
                //    몇 칸을 잘라내서 반환할지 지정
                // --> 배열에서 잘라낸 부분이 사라짐
                const newTodoList = [...todoList];

                newTodoList.splice(index, 1);

                setTodoList(newTodoList); // 리렌더링

            })
            .catch(e => console.log(e));

        }

        let keyIndex = 0;

        return(

            <>
                <h1>{loginMember.name} Todo List </h1>

                    <div className="todo-container">

                    <h3>할 일(Todo) 입력</h3>
                    <div>
                        <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                        <button onClick={handleAddTodo}>Todo 추가</button>
                    </div>

                    <ul>
                        {/* 배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                        {todoList.map((todo, index) => (
                            <li key={keyIndex++}>
                                <div>
                                    <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                                    <span>
                                        <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                        <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                                    </span>
                                </div>
                            </li>
                        ))}
                    </ul>

                </div>
          
            </>

        )

};

export default TodoList;