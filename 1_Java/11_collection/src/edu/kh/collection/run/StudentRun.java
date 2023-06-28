package edu.kh.collection.run;

import edu.kh.collection.model.service.MapService;
import edu.kh.collection.model.service.SetService;
import edu.kh.collection.model.service.StudentService;

public class StudentRun {

	public static void main(String[] args) {
		
		StudentService service = new StudentService();
		//service.displayMenu();
		//service.ex1();
		
		SetService service2 = new SetService();
		//service2.ex5();
		//service2.lotto();
		
		MapService service3 = new MapService();
		service3.ex3();
		
	}
	
	
}
