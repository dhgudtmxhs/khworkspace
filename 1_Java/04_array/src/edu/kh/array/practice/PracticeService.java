package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

	public void ex1() {
		
			//길이 9 배열 선언 할당, 1~9 반복문으로
			// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
			// 짝수번째 인덱스 값의 합을 출력하세요. (0번째 인덱스는 짝수)
		
		
		int arr[] = new int[9];
		int sum = 0;
		
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = i+1;
			
			System.out.print(arr[i] +" ");


			if(arr[i] % 2 != 0) { 
				sum += arr[i];		
			// arr[0], [2], [4], [6], [8]
			// =>  1,   3,   5,   7,   9
			
			}
			}
		
			System.out.println();
			System.out.println("짝수 번째 인덱스 합 : " + sum);
	
	}

	public void ex2() {
		
		// 길이 9 배열 선언 할당, 9~1 반복문으로
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		// 홀수 번째 인덱스 값의 합을 출력
		
		int arr[] = new int[9];
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = arr.length - i;
			
			System.out.print(arr[i] + " ");
			
			if(arr[i] % 2 ==0) {
				sum+= arr[i];
			}
			}
		
			System.out.println();
			System.out.println("홀수 번째 인덱스 값의 합 : " + sum);
		
	}

	public void ex3() {
		
		// 입력받은 양의 정수만큼 배열 크기 할당
		// 1부터 입력 받은 값 까지 배열에 초기화한 후 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int num[] = new int[input]; 
		
		for(int i = 0; i < num.length; i++){
			
			num[i] = i + 1;
			
			System.out.print(num[i] +" ");
			
		}
		
	}
	
	public void ex4() {
		
		// 정수 5개 입력받아 배열 초기화
		// 검색할 정수 입력받아 배열에서 같은 수가 있는 인덱스 찾아 출력
		// 배열에 같은 수가 없을 경우 "일치하는 값 없음" 출력
	
			Scanner sc = new Scanner(System.in);
	
			int arr[] = new int[5];
		
			boolean flag = false;
			
			for(int i = 0; i < arr.length; i++) {
				
				System.out.printf("입력 %d : ", i);
				int input = sc.nextInt();	
				arr[i] = input;
				}
		
			System.out.print("검색할 값 : ");
			int input2 = sc.nextInt();
			
			for(int i = 0; i < arr.length; i++) {
			
				if(input2 == arr[i]) {
					System.out.print("인덱스 : " + i);
					flag = true;
				}
				}if(!flag) {
				System.out.println("일치하는 값 없음");
				}
}

	public void ex5() {
		
		//문자열 입력받아 문자 하나하나를 배열에 넣고
		//검색할 문자가 문자열에 몇 개 들어가 있는지
		//개수와 몇번 째 인덱스에 위치하는지 인덱스를 출력해라
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		

		char arr[] = new char[input.length()];
		
		for(int i = 0; i <arr.length; i++)
		
			arr[i] = input.charAt(i);
		//input.charAt(index) : input에서 index 값에 위치한 문자 하나를 얻어온다.
		
		System.out.print("문자 : ");
		
		char ch = sc.nextLine().charAt(0);
		int count = 0;
		
		System.out.printf("%s 에 %c가 존재하는 위치(인덱스) : ", input, ch);
		
			for(int i = 0; i < arr.length; i++) {
		
			
			if(arr[i] == ch) {
				count++;
				System.out.print(i + " ");
			}
			}
			System.out.println();
			System.out.println(ch + "개수 : " + count);
	}
	
	public void ex6() {
		
		// 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		// 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		// 그리고 배열 전체값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : " ,i);
			int index = sc.nextInt();
			arr[i] = index;
			sum += index;
		}
		for(int i = 0; i < arr.length; i++){
			
			System.out.print(arr[i] + " ");
		}
			System.out.println();
			System.out.println("총 합 : " + sum);
}
	
	public void ex7() {
		
		// 주민번호 입력받아 성별 뒤 *로 가리고 출력해라.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : "  );
		String input = sc.nextLine();
		
		char chr[] = new char[input.length()];
		
		for(int i = 0; i < chr.length; i++) {
			
			chr[i] = input.charAt(i);
			if(i < 8) {
				System.out.print(chr[i]);
			}else {
				System.out.print("*");
			}

		}
	}

	public void ex8() {
		
	/* 3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
	단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
	다시 정수를 받도록 하세요.*/	
	
	Scanner sc = new Scanner(System.in);
	
	int num = 1;
	boolean flag = false;

	do {
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		
		if(input %2 == 0 || input < 3) {
		System.out.println("다시 입력하세요.");
		}
		
		else {
		
			flag = true;
		int[] arr = new int[input];
		int middle = (input / 2);
		
		for(int i = 0; i <= middle; i++) { // input 5면 인덱스 0 1 2
			arr[i] = i + num;	
		}
			
		for(int i = middle+1; i< input; i++) { // input 5면 인덱스 3 4
			arr[i] = input - i;
		}	

		for(int i =0; i< input; i ++) {
			System.out.print(arr[i] + " ");
		}
		}
	}while(!flag);
}
	
	public void ex9() {
		
		/*메소드 명 : public void practice9(){}
		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.*/
		
		int arr[] = new int[10];
		
		System.out.print("발생한 난수 : ");
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random()*10 +1); // 0.0 <= x < 1
			
			System.out.print(arr[i] + " ");
		}
	}
	
	public void ex10() {
		
	/*10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
	1~10 사이의 난수를 발생시켜 배열에 초기화 후
	배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.*/	
		
		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");	
		
		for(int i = 0; i < arr.length; i++) {
		
		arr[i] = (int)(Math.random()*10 +1); // 0.0 <= x < 1
			
		System.out.print(arr[i] + " ");
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
		if(arr[i] > max) {
			max = arr[i];
		
		}else if(arr[i] < min){
			min = arr[i];
		}
		
		}	
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	
	
}
	
	public void ex11() {
		
		/*10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.*/
		
		int[] arr = new int[10];
			
			for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random()*10 +1); // 0.0 <= x < 1
			
		
			for(int x = 0; x < i; x++) { // i 는 1부터, 인덱스 1부터
				
				if(arr[i] == arr[x]) {
				i--;
				break;
				}
			}
			}
		
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
				
			}
	}
	

	public void ex12() {
		
		int lotto[] = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			
			lotto[i] =(int)(Math.random() *45 + 1); // 0.0 <= x < 1
			
			for(int x = 0; x < i; x++) {
				
				if(lotto[i] == lotto[x]) {
				i--;
				break;
				}
			}
			}
		Arrays.sort(lotto);
		for(int i = 0; i <lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}

	public void ex13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.next();
		
		char arr[] = new char[input.length()];
		
		System.out.println("문자열에 있는 문자 : ");
		
		int count = 0;

		for(int i = 0; i < input.length(); i++) {
			
			arr[i] = input.charAt(i);

			for(int x = 0; x < i; x++) {
				
				if(input.charAt(x) == arr[i]) { // 0, 1 비교 => 0,1와 2 비교 => 0,1,2 와 3 비교 => 0,1,2,3과 4 비교
  					count++;
					break;
			
				}
			}
			
		}
		
		for(int i = 0; i < input.length(); i++) {
			
			if(i == input.length()-1) {
				System.out.println(arr[i]);
			}else {
				System.out.print(arr[i] + ", " );
			}
			}

		System.out.println("문자 개수 : " + (arr.length - count));	
				
		}

	public void ex14() {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 :");
		int input = sc.nextInt();
		
		
		String arr[] = new String[input];
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(i+1 + " 번 째 문자열 : ");
			String input2 = sc.next();
			arr[i] = input2;
		}
		
	do {	
		
		System.out.print("더 값을 입력하시겠습니까? (y/n) : ");
		String input3 = sc.next();
		
		if( !input3.equals("y") && !input3.equals("n")) {
			System.out.println("다시 입력해주세요."); 
			continue;
		}
		
		if(input3.equals("y")) {
				
			System.out.print("더 입력하고 싶은 개수 : ");
			int input4 = sc.nextInt();
			
			
			String copyArr[] = new String[(arr.length+input4)];
			
			for(int i = 0; i < arr.length; i++) {	
				copyArr[i] = arr[i];
			}
			
			for(int i = arr.length; i < copyArr.length; i++) {
				
				System.out.print( i+1 + " 번 째 문자열 : ");
				String input5 = sc.next();
				copyArr[i] = input5;
		}
			arr = copyArr;
		}
		else if(input3.equals("n")) {
			break;
		}
		
	}while(true); 
	System.out.println(Arrays.toString(arr));
	

	
}
	
	public void ex15() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		
		String[] arr = new String[size]; // 배열 선언 및 할당

		int start = 0; // while 문 내 for문의 초기식에 사용될 변수
		
		while(true) {
			
			for(int i = start; i < arr.length; i++) {
				System.out.println((i+1) + "번째 문자열");
				arr[i] = sc.nextLine();
			}
		
			System.out.println("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
			
			if(input == 'Y' || input == 'y') {
				
				start = arr.length; // 추가 입력 받기 위한 추가 배열 부분의 시작 위치
					
				System.out.println(" 더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				// 증가된 크기의 배열을 생성하여 arr 배열을 깊은 복사
				String[] copyArr = new String[arr.length + addSize];
				
				for(int i = 0; i < arr.length; i++) { // 인덱스 값을 복사한다.
				
					copyArr[i] = arr[i];
				}

				// 배열 얕은 복사 주소값을 넣어줘서 같은 배열 참조하게 한다
				arr = copyArr;
				
			} else { // y or n 만 입력했다는 상황을 가정		
				
				break; // while 반복 종료
				
			}

		}			
	
		
		
		
		
	}	
	
}
