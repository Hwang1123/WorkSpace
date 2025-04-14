package j.interface1;

public class Dog implements Animal {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("껑충껑충 뛰어다닌다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("왁왁왁먹는다");
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍멍");
	}
	
}
