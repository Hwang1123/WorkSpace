package b.operator;

import java.util.Scanner;

public class Operator6 {
	/*
	 	삼항연산자
	 	[표현식]
	 	조건식 ? 조건이 참일경우 결과값 : 조건이 거짓일 경우 결과갑
	 	
	 	이때 조건식은 반드시 true 또는 false가 나오는 논리값이어야 한다.
	 	주로 비교, 논리 연산자를 통해 작성
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = (3 > 10) ? 10 : 20;
		
		//입력받은 정수 값이 양수인지 아닌지 판별 후 출력해라
		//정수값 입력 :
		//양수 / 음수
		
	
		System.out.print("정수 하나 입력 : ");
		int num1 = sc.nextInt();
		
		//String result = (num1 > 0) ? "양수" : "음수";
		String result = (num1 > 0) ? "양수" : "음수";
		System.out.println(result);
	}

}
