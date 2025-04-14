package zz.chat.gpt2;

public class Rectangle {
	int width;
	int height;
	
	public Rectangle() {
		this.width = 1;
		this.height =1;		
	}
	public Rectangle(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public void RE() {
		System.out.println("넓이 : " + this.width * this.height);
	}
}
