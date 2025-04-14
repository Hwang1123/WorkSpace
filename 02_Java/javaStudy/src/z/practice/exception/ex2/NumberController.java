package z.practice.exception.ex2;

public class NumberController {

	public NumberController() {
		super();
	}
	
	public boolean checkDouble(int num1, int num2)
			throws NumRangeException{
		boolean tf = true;
		
		if(num1 >= 1 && num1 <= 100 && num2 >= 1 && num2 <= 100) {
			if(num2 % num1 == 0) {
				tf = true;
			}
			else {
				tf = false;
			}
		}
		else {
			throw new NumRangeException("1부터 100 사이의 값이 아닙니다");
		}
		return tf;
	}
}
