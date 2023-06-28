package practice;

public class DataTest5 {

	
	public static void main(String[] args) {
		
	
	int[] arr = new int[] {3,2,1,6,5,4};
	
	printArr(arr);// 메서드 실행
	sortArr(arr); // 메서드 실행 // 변경
	printArr(arr); // 메서드 실행
	System.out.println("sum = " + sumArr(arr));
	}
	
	static void printArr(int[] arr) { // 반환값이 없음
		System.out.print("[");
		
		for(int i : arr) // for( 타입 변수명 : 배열 또는 컬렉션)
			System.out.print(i + ",");
			System.out.println("]");
			
	}
	
	static int sumArr(int[] arr) { // 반환값이 있음
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) 
			
			sum += arr[i];
		
			return sum;
	}
	
	static void sortArr(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			
			for(int j = 0; j < arr.length-1-i; j++) {
				
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}

			}

		} 
}
}
