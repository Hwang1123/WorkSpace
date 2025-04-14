package b.operator;

public class Operator3 {
	/*
	  	산술 연산자
	  	+ - * / %
	  	
	  	* / % > + -
	  	
	  	복합대입 연산자
	  	산술 연산자와 대입 연산자를 결합해서 사용할 수 있다.
	 	
	 	+= /= -= *= %=
	 	
	 	a = a + 3; => a += 3;
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		int c = (++a) + b; //16
		int d = 16 / 6; //2
		int e = c % a; //4
		int f = e++; //4 e = 5
		int g = (--b) + (d--); // b = 9, g = 9 + 2(1), g = 11, d = 1
		int h = 2; 
		
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		//         6  + 9 / (15 / 4)  * ( 11 - 1) % ( 6  + 2)
		
		 // a = 7, b = 9, c = 15, d = 1, e = 6, f = 4, g = 10, h = 2 
		System.out.print(i);
			
		
	}
}
