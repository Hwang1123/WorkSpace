package z.practice.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str, " ");
		String newStr = "";
		while(stn.hasMoreElements()) {
			newStr += stn.nextToken();
		}
		return newStr;
	}
	
	public String firstCap(String input) {
		String str = input.substring(0, 1).toUpperCase() + input.substring(1);
		return str;
	}
	
	public int findChar(String input, char one) {
		
		 	//forloop문
		 	
			int count = 0;
			for(char c : input.toCharArray()) {
				if(c == one)
					count++;
			}
		/*
		char[] chArr = new char[input.length()];
		int count = 0;
		for(int i=0; i>input.length(); i++) {
			chArr[i] = input.charAt(i);
		}
		
		for(int i=0; i<chArr.length; i++) {
			if(chArr[i] == one) {
				count++;
			}
		}
		*/
		return count;
	}
}
