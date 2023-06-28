package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import edu.kh.collection.model.vo.Student;

public class StudentService {

	//필드
	private Scanner sc = new Scanner(System.in);
	
	//학생 정보 저장할 List(객체 배열의 Upgrade 버전)
	
	// 인터페이스는 모든메소드가 추상메소드, 미완성 메소드가 존재하는 클래스, 객체 생성해도 미완성 객체라 객체생성 불가
	// 인터페이스는 객체 생성이 안되지만, 부모 참조 변수로는 사용이 가능하다.
	
	// ArrayList 기본 생성자 : 기본 크기 10짜리 리스트 생성
	// 하지만 리스트는 크기가 늘었다 줄었다 하기때문에 큰 의미는 없다
	
	// ArrayList(용량) : 용량 만큼의 리스트 생성
	//                  너무 큰 값을 작성하면 메모리를 많이 소모한다.

	//List<Student> studentList = new ArrayList<Student>();  // 검색에 효율적이다.
	private List<Student> studentList = new LinkedList<Student>(); // 추가 수정, 삭제에 효육적
	// Student로 저장되는 타입이 제한된 리스트 생성 제네릭스.
	// Student 만 저장 가능. 모든게 Student => 굳이 Student임을 검사할 필요가 없게 되는 것.
	
	
	
	
	
	
	public StudentService() {
		
		studentList.add(new Student("박서준", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("정해인", 23, "경기도 안산시", 'M', 80));
		studentList.add(new Student("박보영", 22, "서울시 강남구", 'F', 100));
		studentList.add(new Student("오형석", 27, "서울시 동대문구", 'M', 95));
		studentList.add(new Student("강호동", 51, "제주시 애월읍", 'M', 20));
		
	}
	
	public void ex1() {
		
		// List 테스트
		// List.add(Object e) : 리스트에 객체를 추가해준다.
		// 매개변수 타입이 Object == 모든 객체를 매개변수로 전달할 수 있다. 오브젝트는 최상위 부모니까. 최상위 부모 참조변수 == 다형성 적용 가능
		
		studentList.add(new Student()); // 0번째 인덱스에 student 객체 들어감 // import하면 그냥 쓸 수 있음
	
		// 이제 추가하면 5번째 인덱스부터 들어가게 됨.
		
		//studentList.add(sc);			// 1번째 인덱스
		
		//studentList.add("문자열");		// 2번째 인덱스
		
		//studentList.add(new Object()); 	// 3번째 인덱스
		
		// 컬렉션 특징 : 여러 타입의 데이터를 저장 가능하다.
		
		// (반환형)
		// Object List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(Object)를 반환한다.
		// get 을 호출할 때 index 번호를 보낸다. 실행하면 Object가 반환된다.
		// 반환형이 Object == 모든 객체를 반환할 수 있다.
		
		System.out.println(studentList.get(0).toString());
		// 실행 전 : java.lang.Object.toString() == 정적 바인딩
		
		// 실행 후 : 0번째는 Student 객체이고, toString()이 오버라이딩 되어있다. 동적바인딩 됐다.
		// 		   그냥 애초에 참조하는게 스튜던트 새 객체니까 스튜던트 께 나온다고 생각
		
		// Student [name=null, age=0, region=null, gender= , score=0]
		
		// Student 의 이름만 얻어오기.
		// Student 객체가 맞는지 확인하고 다운캐스팅을 해야
		// Student 기능을 사용할 수 있다.
		
		if(studentList.get(0) instanceof Student) {
			System.out.println(((Student) studentList.get(0)).getName());
		} // 너무 길고 복잡하다.
		  // 컬렉션의 장점인 여러 객체 저장이 오히려 코딩에 방해가 된다.

		// ********** 그래서 제네릭스(Generics) 등장 ********** //
		// 보통 제네릭이라고 함 <> 꺽새로 표현
		// [제일 중요한 역할]
		// -> 컬렉션에 저장되는 객체 타입을 한 가지로 제한해준다.
		
		System.out.println(studentList.get(0).getName()); // 제네릭스를 사용하면 이렇게 간단해짐.
}
	
	/**
	 * 메뉴 출력용 메소드
	 * @author 오형석
	 */ 
	//alt + shift + j
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("\n=========== 학생 관리 프로그램 ===========");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
		
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: System.out.println(addStudent()); break;
				case 2: selectAll(); break;
				case 3: System.out.println(updateStudent());break;
				case 4: System.out.println(removeStudent());break;
				case 5: searchName1(); break;
				case 6: searchName2(); break;
				
				case 0: System.out.println("<프로그램 종료>"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요."); break;
				}
			
			}catch(InputMismatchException e){
				System.out.print("\nerror : 입력 형식이 유효하지 않습니다. 다시 출력해주세요.");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력된 문자열 제거
				
				menuNum = -1; // 첫 반복 시 잘못 입력하는 경우 menuNum이 0을 가지고 있어서 종료되는데(while문)
							  // 이를 방지하기 위해 임의의 값 (-1)을 대입했다.
			
			}
		}while(menuNum != 0);

	}
	
	/**
	 * 1. 학생 정보 추가 메소드
	 * 추가 성공시 "성공", 실패시 "실패" 문자열 반환
	 */
	public String addStudent() throws InputMismatchException{
	
		System.out.println(" ========== 학생 정보 추가 ==========");
		
	System.out.print("이름 : ");
	String name = sc.next();
	
	System.out.print("나이 : ");
	int age = sc.nextInt();
	sc.nextLine(); // 개행문자 제거
	
	System.out.print("사는 곳 : ");
	String region = sc.nextLine();
	
	System.out.print("성별(M/F) : ");
	char gender = sc.next().charAt(0); 
	
	System.out.print("점수 : ");
	int score = sc.nextInt(); // 발생할 수 있는 오류 : InputMismatchException
	
	// Student 객체 생성 후에 List에 추가해주기
	
	if(studentList.add(new Student(name, age, region, gender, score))){
		// boolean java.util.List.add(Student e)
		// (반환형)                      -> 제네릭 <Student> 때문에 List 타입이 Student로 제한됨.
		
		// add()는 무조건 true 반환하기 때문에 사실 실패하는 경우는 없음.
		// 대신 예외가 발생해서 add() 수행 전 메소드가 종료될 수는 있음.
		
		return "성공";
		
	}else {
		
		return "실패";
	}
	
	}
	
	/**
	 * 2. 학생 전체 조회 메소드
	 */
	public void selectAll() {
		 
		// - List는 인덱스가 있다. (0번부터 시작)
		// - List에 저장된 데이터의 개수를 얻어오는 방법( 배열과 다르다. ) : int List.size()
		// -> 배열명.length 대신 사용
		
		// - List가 비어있는지 확인하는 방법
		// boolean java.util.List.isEmpty() : 비어있으면 true를 반환한다.
		
		System.out.println("========== 학생 전체 조회 ==========");
		
		// studentList가 비어있는 경우 "학생 정보가 없습니다." 출력
		
		//if(studentList.size() == 0) {
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다.");
			return; // 현재 메소드를 종료하고 호출한 곳으로 돌아간다. // 단 반환값은 없음(void)
		}
		
		/* 일반 for문
		for(int i = 0; i < studentList.size(); i++) {
			
			System.out.println(studentList.get(i)); // i번째 인덱스 요소 출력.
			
		}*/
		
		// 향상된 for문 (for each문)
		// 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
		// 순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가
		
		// for(컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수 : 컬랙션명 또는 배열명) {  }
		
		int index = 0;
		for(Student a : studentList) {
		// a는 for문 반복시마다 0, 1, 2 ... 인덱스 요소 한번씩 저장된다.
			
			System.out.print((index++) + "번 : ");
			
			System.out.println(a);
		}
		
		
	}
	
	/**
	 * @return
	 */
	public String updateStudent() throws InputMismatchException {

		
		// - Student List.set(int index, Student e)
		//        -> List의 i번째 요소를 전달 받은 e로 변경한다.
		//        -> 반환값 Student == 변경 전 Student 객체가 담겨있다.
		
		System.out.println("=============== 학생 정보 수정 ================");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		// 1) 학생 정보가 StudentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		
		// 2) 입력된 숫자가 0보다 작은가? (음수 검사)
		}else if( index < 0) {
			return " 음수는 입력할 수 없습니다.";
		
		// 3) 문자열 입력한 경우 : try catch도 있지만 throws로 던짐	
		
		// 4) 입력 받은 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= studentList.size())	{ // >= ?
			
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		
		}else {
			
			System.out.println(index + "번 째 인덱스에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			System.out.print("이름 : ");
	         String name = sc.next();
	         
	         System.out.print("나이 : ");
	         int age = sc.nextInt();
	         sc.nextLine(); // 입력 버퍼 개행 문자 제거
	         
	         System.out.print("사는곳 : ");
	         String region = sc.nextLine();
	         
	         System.out.print("성별(M/F) : ");
	         char gender = sc.next().charAt(0);
	                  // String -> char
	         
	         System.out.print("점수 : ");
	         int score = sc.nextInt(); // InputMismatchException
	         
	         // 입력받은 index 번째에 새로운 학생 정보를 세팅(수정) 할거다.
	         // set 하면 기존 학생 정보가 반환된다.
	         // 그걸 Student temp로 받기
	         Student temp = studentList.set(index, new Student(name, age, region, gender, score));
	    
	         return temp.getName() + " 님의 정보가 변경되었습니다.";
		}
	}
	
	/**
	 * 학생 정보 제거 메소드
	 * @return 
	 */
	public String removeStudent() throws InputMismatchException {
		
		// - Student List.remove(int index)
		// 리스트에서 index번째 요소를 제거한다.
		// 이 때, 제거된 요소가 반환된다.
		
		// List는 중간에 비어있는 인덱스가 없게 하기 위해서 
		// remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다. index[1] 없애면 index[2] 가 index[1]로 오게된다.
		
		System.out.println("======= 학생 정보 제거 =======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		// 1) 학생 정보가 StudentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		
		// 2) 입력된 숫자가 0보다 작은가? (음수 검사)
		}else if( index < 0) {
			return " 음수는 입력할 수 없습니다.";
		
		// 3) 문자열 입력한 경우 : try catch도 있지만 throws로 던짐	
		
		// 4) 입력 받은 숫자가 studentList 범위 내 인덱스 번호인가?
		}else if(index >= studentList.size())	{ // >= ?
			
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		
		}else {
			
		// 학생 정보 제거
		// 정말 지우시겠습니까? 물어보기
			System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0); // String.toUpperCase() : 문자열을 대문자로 변경
			
			if(ch == 'Y') {
				Student temp = studentList.remove(index); // 입력한 인덱스 번호
				// 버린거 temp 에 받기
				return temp.getName() + "님의 정보가 제거되었습니다.";
				//이거 출력하기 위해서인듯.
 			
			}else { // N 이거나 Y가 아닌 걸 입력하면
 				return "취소";
 			}
		}

	}
	
	/**
	 * 이름이 일치하는 학생을 찾아서 조회하는 메소드
	 */
	public void searchName1() {
		
		System.out.println("======== 학생 검색(이름 일치) ========");
		
		boolean flag = true;
		
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		// 이름이 일치하는 경우
		// 일치한 학생의 정보 출력
		for(Student a : studentList) { 
			if(input.equals( a.getName() ) ) {
			// a에 담아놨으니까
			System.out.println(a);
			flag = false;
			}
		}
		
		if(flag) { // flag가 true인 경우 == for문 내에 있는 if가 수행된 적이 없다.
				   // 				   == 검색 결과가 없다.
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	/**
	 * 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메소드
	 */
	public void searchName2() {
		
		// contains : 포함
		// boolean String.contains(문자열) : String에 문자열이 포함되어 있으면 true 반환
		
		System.out.println("======= 학생 검색(이름 포함) =======");
		
		boolean flag = false;
		
		System.out.print("이름에 포함되는 문자열 입력 : ");
		String input = sc.next();
		
		for(Student a : studentList) {
			//if(input.contains(a.getName()))	{ // 박보영이 가 박보영을 포함한다면
			if(a.getName().contains(input)) { // 박보영이 박을 포함한다면
			System.out.println(a);
				flag = true;
			}
		}
		
		if(!flag){
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	
	
}
