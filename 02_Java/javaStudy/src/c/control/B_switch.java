package c.control;

import java.util.Scanner;

public class B_switch {
	/*
	 	switch문도 if문과 동일하게 조건문이다
	 	
	 	다만, if문과의 차이점이라면 
	 	> if문은 조건실을 자유롭게 기술할 수 있다.
	 	  switch문은 동등비교로 밖에 수행되지 않는다.
	 	> 실행할 구문만 실행하고 자동으로 빠져나올 수 없다. (직접 빠져나오는 설정이 필요하다.)
	 	
	 	[표현법]
	 	switch(비교대상(정수,문자,문자열)){
	 	case 값1 : 실행코드;
	 	case 값1 : 실행코드;
		...
		default : 위의 값이 전부 일치하지 않을 때 실행하는 코드;
	 	}
	 	break -> switch문 내에서 사용하면 해당코드가 실행됨과 동시에
	 			가장 가까운 switch문을 종료한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 	정수를 입력 받아서
		 	1일 경우 "빨간색입니다."
		 	2일 경우 "파란색입니다."
		 	3일 경울 "초록색입니다."
		 	다른 경우 모두 "잘못입력하셨습니다."
		 */
		/*
		int num;
		System.out.print("정수입력 : ");
		num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("빨간색입니다.");
			break;
		case 2:
			System.out.println("파란색입니다.");
		case 3:
			System.out.println("초록색입니다.");
		default:
			System.out.println("잘못입력하셨습니다.");
		}
		*/
		/*
		 	과일을 구매하는 프로그램을 작성하여봅시다.
		 	구매하고자 하는 과일을 입력하면
		 	그에 맞는 가격이 출력되는 프로그램을 작성해주세요.
		 	
		 	[출력문]
		 	구매하고자하는 과일(사과(2000), 바나나(3000), 딸기(20000)) 입력 : xx
		 	xx의 가격은 xxx입니다. / 잘못 입력하셨습니다.
		 */
		/*
		String fruit;
		System.out.print("구매 과일 : ");
		fruit = sc.nextLine();
		
		switch(fruit) {
		case "사과":
			System.out.println("사과의 가격은 2000원입니다.");
			break;
		case "바나나":
			System.out.println("바나나의 가격은 3000원입니다.");
			break;
		case "딸기":
			System.out.println("딸기의 가격은 20000원입니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		*/
		
		/*
		 	월을 입력받아 해당 월에 말일이 며칠까지 있는지를 출력하는 프로그램을 작성
		 	
		 	[출력문]
		 	월을 입력 하세요 : xx
		 	xx월은 xx일까지 있습니다.
		 	
		 	1,3,5,7,8,10,12 -> 31
		 	4,6,9,11 -> 30
		 	2 -> 28
		 */
		int month;
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4,6,9,11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		/*
		int month;
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		*/
	}
}
