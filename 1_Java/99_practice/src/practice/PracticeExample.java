package practice;
   
   import java.util.Scanner;
   
   public class PracticeExample {
   
      public void ex5() {
         
         Scanner sc = new Scanner(System.in);
         
         System.out.print("숫자 : ");
         int num = sc.nextInt();
         
      System.out.printf("=====%d단=====%n", num);
      
      for(int i = num; i<= 9; i++) {
      
         for(int j = 1; j<= 9; j++) {
            System.out.printf("%d x %d = %d%n", i, j, i * j);
      } 
         if (num < i);
         break;
      }
      
      
   }
   
   public void ex6() {
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("숫자 : ");
      int num = sc.nextInt();
      
      if(num < 2 || num > 9) {
         
         System.out.println("2~9 사이의 숫자만 입력해주세요.");
      }else {
         
         for(int i = num; i <= 9; i++) {
      
         System.out.printf("===== %d단 ===== %n", num);
            num++;
            
         for(int j = 1; j <= 9; j++) {
            
            System.out.printf("%d x %d = %d%n", i, j, i * j);
         }
         }
         }
}
      

   
   public void ex7() {
   
      Scanner sc = new Scanner(System.in);
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();
      
      for(int i = 1; i <= num; i++) {
         
         for(int j = i; j >= 1; j--) {
            
            System.out.print("*");
         }
         System.out.println();
      }

}
   
   
   public void ex8() {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();
      
      for(int i = 1; i <= num; i++) {
         
         for(int j = num; j>= i; j--) {
            System.out.print("*");
         }
      
            System.out.println();
         
      }
      
      
   }
   
   public void ex9() {
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();

      /*for(int i = 1; i <= num; i++) {
         
         //for(int p = 1; p <= num-i; p++){ // 공백인 경우를 for문으로 작성
           for(int p = num-i; p>=1; p--) { 
            System.out.print(" ");
         }
         for(int j = 1; j <= i; j++) {
            
            System.out.print("*");
         }
         System.out.println();
      }*/

      // for + if else
      
      	for(int x = 1; x<= num; x++){
     
    	 for(int i = 1; i <= num; i++){
    	  
    		 if(i <= num - x) {
    			 System.out.print(" ");
    		 }else {
    		 
    	  System.out.print("*");
    		 }
    		 }
   System.out.println();
      }
}
   


   public void ex10() {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();
      
    /*  for(int i = 1; i <=num ; i++){
         
         for(int j = 1; j <= i; j++) {
            System.out.print("*");
      
         }
         	System.out.println();
         }
      
      for(int i = num-1; i >= 1; i--) { 
            
          for(int j = 1; j <= i; j++) {
            System.out.print("*");
         }
            System.out.println();
      	} */
      
      
      for(int i = 1; i <= num-1; i++) {
    	  
    	  for(int j = 1; j <= i; j++) {
    		  System.out.print("*");
    	  }
    	  	System.out.println();
      }
      
      for(int i = num; i >= 1; i-- ) {
    	  
    	  for(int j = 1; j<= i; j++) {
    		  System.out.print("*");
    	  }
      
    	  System.out.println();
      }
      

}
   
   public void ex11() {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();
      
       /* for(int i = 1; i <= num; i++) {
         
         for(int j = 1; j <= (num - i + 1); j++) {
            
            System.out.print(" ");
         }
      
         for(int y = 1; y <= (2 * i - 1); y++) {
            System.out.print("*");
         }
      System.out.println();
      }*/
      
    /*  for(int i = 1; i <= num; i++) {
    	  
    	  for(int j = 1; j <= num -i + 1; j++) {
    		   System.out.print(" ");
    	  }
    	  for(int x = 1; x <= 2 * i - 1; x++) {
    		  System.out.print("*");
    	  }
    	  	  System.out.println();
      } */
      
      for(int i = 1; i <= num; i++) {
    	  
    	  for(int j = 1; j <= num - i + 1; j++) {
    		  System.out.print(" ");
    	  }
    	  for(int x = 1; x <= 2 * i - 1; x++) {
    		  System.out.print("*");
    	  }
      System.out.println();
      
      }
      for(int i = num-1; i>=1; i--) {
    
    	  for(int j = 1; j <= num - i + 1; j++) { /// 2, 3, 4, 5
    		  System.out.print(" ");
    	  }
    	  
    	  for(int x = 1; x <=2 * i - 1; x++) {
    		  System.out.print("*");
    	  }
    	     System.out.println();
    	  }
   }
   
   public void ex12() {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("정수 입력 : ");
      int num = sc.nextInt();
   
  /*    for(int x = 1; x <= num; x++) {
         System.out.print("*");
      }
      System.out.println();
      for(int i = 1; i <= num-2; i++) {
         
         for(int j = 1; j <= num; j++) {
            
            if(j == num || j == 1) {
            System.out.print("*");
            
            }else {
            System.out.print(" ");
         }
         }
            System.out.println();
         }
      
      for(int x = 1; x <= num; x++) {
         System.out.print("*");
      }
   }
  */
      
      //row : 행(줄)
      //col(column) : 열(칸)
      
      for(int row = 1; row <= num; row++) { 
    	  
    	  for(int col = 1; col <= num; col++) {
    		 //row 또는 col이 1 또는 input인 경우에만 * 출력 // 테두리만 출력하겠다.
    		  
    		  if(row == 1 || col == 1 || row == num || col == num) {
    		  // 첫쨰줄 가로	 첫재줄 세로    마지막 가로     마지막 세로
    			  System.out.print("*");
    		  
    		  }else {
    			  System.out.print(" ");
    		  }
    	  }
    	  	  	  System.out.println();
      }
      
     //변수 선언 : 메모리에 값을 저장할 수 있는 공간을 할당
     //배열 선언 : 메모리에 배열을 참조하는 변수 공간을 할당
     //		     (값 직접 저장 x, 배열의 '주소'를 저장)
     //배열 할당 : 실제 값을 저장할 수 있는 배열을 메모리에 생성 
      
      
   }
   public void ex13() {
	      
	      // 1부터 입력받은 수 까지 중에
	      // 2, 3의 배수를 모두 출력하고
	      // 2, 3의 공배수의 개수를 출력
	   
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.print("자연수 하나를 입력하세요. : ");
	      int num = sc.nextInt();
	      
	      int count = 0;
	      
	      for(int i = 1; i<= num; i++) {
	         
	         if(i % 6 == 0){
	         count++;
	      
	         }else if(i % 2 == 0) {
	      
	            System.out.print(i + " ");
	         
	         }else if(i %3 ==0){
	            System.out.print(i+ " ");
	         }
	         }
	         
	         System.out.println();
	         System.out.println("count = " + count);
	   
	   
	     
   
   }
   
   
   
}