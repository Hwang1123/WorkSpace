package z.practice.collection.set;

import java.util.Objects;

public class Lottery {
	private String name;
	private String phone;
	
	
	public Lottery() {
		super();
	}
	
	

	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	
	@Override
	public String toString() {
		return name + "(" + phone + ")";
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name, phone);
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Lottery) {
			Lottery lty = (Lottery)obj;
			if(lty.getName().equals(this.name) &&
			   lty.getPhone().equals(this.phone)) {
				return true;
			}
		}
		return false;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
