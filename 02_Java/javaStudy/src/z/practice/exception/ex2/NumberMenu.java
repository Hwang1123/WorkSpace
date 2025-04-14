package z.practice.exception.ex2;

import java.util.Scanner;

import z.practice.exception.ex1.CharCheckException;

public class NumberMenu {
	NumberController nc = new NumberController();
	public void menu() {
		
		
		
		try(Scanner sc = new Scanner(System.in);) {
			
			System.out.printf("정수1 입력 : ");
			int num1 = sc.nextInt();
			
			System.out.printf("정수2 입력 : ");
			int num2 = sc.nextInt();
			
			String tf = num1 % num2 == 0 ? "true" : "false";
			
			nc.checkDouble(num1, num2);
			System.out.printf("%d은(는) %d의 배수인가? %s", num1, num2, tf);
			
		}
		catch(NumRangeException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
