package edu.kh.variable.ex1;

public class CastingPractice1 {

	public static void main(String[] args) {
				
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1 + iNum2);
		System.out.println(iNum1 / iNum2); // 0.5 사라짐 정수형이라
		
		System.out.println(fNum); // 실수형
		System.out.println(iNum2 + fNum); // int형 4가 더 큰 저장범위인 float 형으로 바껴서 4.0+3.0
		System.out.println(fNum * iNum1); // 같음
		
		System.out.println(dNum);
		System.out.println(fNum + dNum); // 3.0 + 2.5
		System.out.println(fNum * dNum);
		System.out.println(fNum / dNum);
		System.out.println(dNum / fNum);
		
		System.out.println(ch);
		System.out.println((int)ch); // 강제형변환
		
		int imim = ch; // 자동형변환
		System.out.println(imim); // 자동형변환
		
		System.out.println(ch + iNum1); // 자동 형변환  
		System.out.println(ch / iNum2); // 65/4 
		System.out.println((char)(ch+iNum1)); // 강제 형변환
		
		System.out.println((char)(ch+10));
		
		////////////////////////////////////////////////////////////
		
		System.out.println(iNum1 / iNum2);
		System.out.println((int)dNum);
		
		System.out.println(iNum2 * dNum);
		
		System.out.println((double)iNum1);
		System.out.println((float)iNum1);
		
		
		System.out.println((double)iNum1 / iNum2);
		System.out.println((double)iNum1 / (double)iNum2);
		System.out.println(iNum1 / (double)iNum2);
		
		System.out.println((double)dNum);
		
		System.out.println((int)fNum);
		System.out.println((int)(iNum1 / fNum));
		
		System.out.println(iNum1 / fNum);
		System.out.println((double)iNum1 / fNum);
		// float 와 double의 차이점
		// float : 소수점 아래 8번째 자리까지 연산 한 후 반올림한다.
		// double : 소수점 아래 16번째 자리까지 연산 후 반올림한다.
		
		
		System.out.println(ch);
		System.out.println((int)(ch));
		
		System.out.println((int)(ch+iNum1));
		System.out.println(ch+iNum1);
		
		System.out.println((char)(ch+iNum1));
		
		int j = 340;
		short sh = (short)j; // short는 범위 넓어서 안사라짐
		byte bm = (byte)j; // 앞에 짤림
		System.out.println(j);
		System.out.println(sh);
		System.out.println(bm);
		
		int i = 44544;
		char c1 = (char)i;
		System.out.println(c1);
		
		
		float f1 = 3.3f;
		System.out.printf("%f%n", f1);
		System.out.printf("%.2f", f1); // 소수점 아래 2자리까지만 표시
		
		float f2 = 3.6f;
		System.out.println(f2);
		System.out.printf("%f%n", f2);
		System.out.println(3.6);
		System.out.println(3.6f);
		
		
		
		
		
		}

}
