package z.practice.object.ex4;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		super();
	}
	
	
	
	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}



	public void information() {
		System.out.println("이름 : " + this.pName + " | 가격 : " + this.price +" | 브랜드 : " + this.brand);
		
	}
	
	
	
}
