package c.control;

import java.util.Scanner;

public class Ptactice1 {
	public static void main(String[] args) {
		/*
		 	나이를 입력받아
		 	13세 이하면 : 어린이
		 	13세 초과 19세 이하 : 청소년
		 	19세 초과 : 성인
		 	
		 	[출력문]
		 	나이를 입력 : xx
		 	xx세는 xxx에 속합니다.
		 
		Scanner sc = new Scanner(System.in);
		int age;
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		
		if(age <= 13) {System.out.printf("%d세는 어린이에 속합니다.", age);}
		else if(age <= 19) {System.out.printf("%d세는 청소년에 속합니다.", age);}
		else {System.out.printf("%d세는 성인에 속합니다.", age);}
		*/
		/*
		 	성별을 (m / f)(대소문자 상관 x)로 입력받아 남학생인지 여학생인지
		 	출력하는 프로그램을 작성하세요
		 	
		 	[출력문]
		 	성별(m/f) :
		 	여학생입니다./ 남학생입니다. /잘못입력하셨습니다.
		 */
		/*
		Scanner sc = new Scanner(System.in);
		char sex;
		
		System.out.print("성별(m/f) : ");
		sex = sc.nextLine().charAt(0);
		
		if(sex == 'm' || sex == 'M') {System.out.print("여학생입니다.");}
		else if(sex == 'f' || sex == 'F') {System.out.printf("남학생입니다.");}
		else {System.out.printf("잘못입력하셨습니다.");}
		*/
		/*
		  	점수(양수)를 입력 받아서
		  	짝수인지 홀수 인지 출혁하는 프로그램을 작성하라
		  	
		  	 [출력분]
		  	 정수 입력 : xx
		  	 짝수다 / 홀수다 / 양수가 아니다
		  
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("정수 : ");
		num = sc.nextInt();
		
		if(num == 0 && num < 0) {System.out.print("양수가 아닙니다.");}
		else if(num % 2 == 0 && num != 0) {System.out.print("짝수");}
		else {System.out.print("홀수");}
	}
}
