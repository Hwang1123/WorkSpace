package h.inherit2;

public class Run {
	
	public static void main(String[] args) {
		//Desktop d1 = new Desktop();
		Desktop d1 = new Desktop("LG", "d-100", "사무용Pc", 1000000, true);
		System.out.println(d1.infomation());
		
		TV tv1 = new TV("삼성", "t-102", "LED TV", 30000000, 75);
		System.out.println(tv1.infomation());
	}
}
