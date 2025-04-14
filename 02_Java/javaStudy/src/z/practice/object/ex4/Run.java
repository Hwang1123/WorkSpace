package z.practice.object.ex4;

public class Run {
	public static void main(String[] args) {
		Product p1 = new Product("청소기", 50000, "삼성"); 
		Product p2 = new Product("냉장고", 800000, "엘지");
		
		p1.information();
		p2.information();
	}
}
