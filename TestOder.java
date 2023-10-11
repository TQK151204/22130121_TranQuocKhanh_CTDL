package Lab_3;

import java.util.Arrays;

public class TestOder {
	public static void main(String[] args) {
		Product p1 = new Product("1", "Pizza", 10.0, "L");
		Product p2 = new Product("2", "Hogdot", 5.0, "S");
		Product p3 = new Product("7", "HamburGer", 4.0, "S");
		Product p4 = new Product("4", "HamburGer", 7.0, "L");
		Product p5 = new Product("9", "Doner Kebab", 10.0, "L");
		
		
		OderItem o1 = new OderItem(p1, 10);
		OderItem o2 = new OderItem(p2, 9);
		OderItem o3 = new OderItem(p3, 8);
		OderItem o4 = new OderItem(p4, 7);
		OderItem o5 = new OderItem(p5, 7);
		
		OderItem[] listItems = new OderItem[] {o2,o4,o5,o1,o3}	;
		
		Oder order = new Oder(listItems);
		
		
		System.out.print("Test Cost: ");
		System.out.println(order.cost());
		
		
		System.out.print("Test Contain: ");
		System.out.println(order.contains(p3));
		
		
		System.out.println("Test Filter");
		System.out.println(Arrays.toString(order.filter("S")));
		
		
	}

}

