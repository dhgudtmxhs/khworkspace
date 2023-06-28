package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {

	
	
	// 얕은 복사 (shallow : 얕은)
	
	//-> 주소를 복사하여 서로 다른 두 변수가
	//하나의 배열(또는 객체)을 참조하는 상태를 만드는 복사 방법
	
	public void shallowCopy() {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		// 얕은 복사 진행
		
		int[] copyArr = arr; //주소만 복사
	
		System.out.println("주소 확인");
		System.out.println("arr : " + arr);
		System.out.println("copyArr : " + copyArr);
	

		// 배열 값 변경
		System.out.println("변경 전 ");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		// 얕은 복사한 배열의 값을 변경해봄
		
		copyArr[2] = 999;
		// 같은 주소를 참조해서 arr도 바뀐다
		
		System.out.println("변경 후 ");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));

		
	}

	public void deepCopy() {
		
		// 깊은 복사
		// -> 같은 자료형의 새로운 배열을 만들어서
		//    기존 배열의 데이터를 모두 복사하는 방법
		
		int arr[] = {1, 2, 3, 4, 5}; //원본
		int deepCopy[] = new int[arr.length]; // 5칸짜리 배열 생성 값은 다 0
		
		System.out.println(arr);
		System.out.println(deepCopy);
		//1. for문 이용
		
		System.out.println("변경 전");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("deepCopy : " + Arrays.toString(deepCopy));
		
		for(int i = 0; i < arr.length; i++) {
			
			deepCopy[i] = arr[i];
		}
		
		System.out.println("변경 후");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("deepCopy : " + Arrays.toString(deepCopy));
		
		
		// 2. System.arraycopy(원본 배열, 원본 복사 시작 인덱스, 복사 배열, 복사배열의 삽입 시작 인덱스, 복사길이);
		
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		
		// 3. 복사할 배열 참조 변수 = Arrays.copyof(원본 배열, 복사할 길이)
		// int[] copyArr3 = new int[arr.length]; 를 하지 않아도 됨
		
		int[] copyArr3 = Arrays.copyOf(arr, arr.length);
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));
		
		// 값 변경 후 확인
		deepCopy[4] = 0;
		copyArr2[4] = 999;
		copyArr3[4] = 5000;
		
		System.out.println("값 변경 후");
		System.out.println("deepCopy : " + Arrays.toString(deepCopy));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));
		
	}

	public void crateLottoNumber() {
		
		// 배열을 이용한 중복 데이터 제거 + 정렬
		// 로또 번호 생성기
		
		// 1. 1~45 사이 중복되지 않은 난수 6개 생성
		// 2. 생성된 난수가 오름차순으로 정렬
		
		// 1) 정수 6개를 저장할 배열 선언 및 할당
		int lotto[] = new int[6];
		
		// 2) 생성된 배열을 처음부터 끝까지 순차 접근하는 for문을 작성
		for(int i = 0; i < lotto.length; i++) {
			
		
		// 3) 1 ~ 45 사이의 난수 생성
		int random = (int)(Math.random()* 45 + 1); // 0.0 <= x < 1.0
												   // 1 <= (int)(x * 45 + 1) < 46		
		
		// 4) 생성된 난수를 순서대로 배열 요소(index 안의 값 1칸 1칸)에 대입
		
		
			lotto[i] = random;
		
		// 5) 중복 검사를 위한 for문 작성
			
			for(int x = 0; x < i ; x++) {
				
		// 6) 현재 생성된 난수와 같은 수가
		// 	  앞쪽 요소에 있는지 검사
			
			if(random == lotto[x]) {
				i--; // i값이 0,1,2 까지 갔을때 2에서 1로 됨
					 // lotto[i] = random; 에서
					 // lotto[2]가 실행 안되고 
					 // lotto[1]로 갔다가 다시 lotto[2]로 오게 되는 것
					 // i 가 1 씩 증가할 때 마다 난수가 하나 생성된다
					 // -> 중복 값이 있으므로 난수를 새로 하나 더 생성해야 한다.		
					 // -> i는 기본적으로 0~5까지 6회 반복되지만
					 //    i값을 인위적으로 1 감소시켜 7회 반복되는 모양을 만든 것
			
			break;   // 안하면 39 39 이렇게 출력됨
					 // 앞쪽에서 중복 데이터를 발견하면
					 // 남은 값을 비교할 필요가 없다.
					 // 효율 향상을 위해서 검사하는 for문을 종료한다
			}
			}
			//System.out.print(lotto[i]);
			}
		
		// 7) 오름차순 정렬
		// -> 선택, 삽입, 버블, 퀵 정렬 등 
		// --> 자바가 정렬 방법을 미리 만들어서 제공하고 있음
		// Arrays.sort(배열명)
		
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	} 
}