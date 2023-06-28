package practice;

class Data_1 {
	
	//Data_1(){}
	int value;
	
}

class Data_2{
	int value;
	Data_2(){}
	Data_2(int x){
		value = x;
	}
	
}

class Data_3{
	
	Data_1 d1 = new Data_1();
	Data_2 d2 = new Data_2(); //기본 생성자를 참조할라 하니까 없어서 에러남
	// 매개변수 생성자만 있음
	 Data_2 d3 = new Data_2(4); //로 매개변수 생성자를 참조해서 오류 안내던가
	// class Data_2에 Data_2(){} 기본생성자를 생성해줌.
	// 1은 기본생성자가 없고 다른 아무 생성자가 없어서 기본생성자를 컴파일러가 자동으로 입력해줌
	// 2는 매개변수생성자가 있기때문에 기본생성자를 컴파일러가 입력해주지 않음.
}