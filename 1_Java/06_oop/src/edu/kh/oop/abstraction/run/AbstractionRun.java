package edu.kh.oop.abstraction.run;

import edu.kh.oop.abstraction.model.service.AbstractionService; // 다른 패키지

public class AbstractionRun {

	public static void main(String[] args) {

		
		AbstractionService as = new AbstractionService();
		//new AbstractionService(); // 객체로 만듬 Heap 에 생김
		// tv t = new tv(); 와 같음 import하고
		
		
		
		as.ex1();
		
	}

}
