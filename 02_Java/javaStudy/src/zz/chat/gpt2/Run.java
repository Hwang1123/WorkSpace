package zz.chat.gpt2;

public class Run {
	public static void main(String[] args) {
		/*
		Rectangle s1 = new Rectangle();
		Rectangle s2 = new Rectangle(2, 4);
		
		s1.RE();
		s2.RE();
		*/
		
		String [] arr1 = new String[5];
		arr1[0] = "c언어";
		arr1[1] = "c++";
		arr1[2] = "sql";
		arr1[3] = "java";
		arr1[4] = "파이썬";
		
		//배열 안에 "java"를 오라클로 변경하여라
		
		for(int i=0;i<arr1.length;i++) {
			//System.out.println(arr1[i]);
			if(arr1[i] != "java") {
				arr1[i] = "오라클";
			}
			System.out.println(arr1[i]);
		}
		
	}
}
