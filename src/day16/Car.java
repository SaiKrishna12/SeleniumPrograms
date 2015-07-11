package day16;

public class Car {

	int price;
	String model;
	public void function(int price,String model)
	{
		this.price=price;
		this.model=model;
	}
	public static void main(String[] args) {
		Car c=new Car();
		c.function(1111,"Audi");
		System.out.println(c.price+"--"+c.model);

	}

}
