package edu.kh.oop.cls.run;

import edu.kh.oop.cls.model.service.ClsService;

public class ClsRun {

	public static void main(String[] args) {
		
		
		ClsService service = new ClsService(); // 참조변수를 만들어야 class 객체를 run 할 수 있다.
		
		//service.ex2();
		service.ex4();
	}

}
