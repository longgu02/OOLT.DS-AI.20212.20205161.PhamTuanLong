package AimsProject;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.printCart();
		
//		// Calculate total
//		System.out.println("Total Cost is:");
//		System.out.println(anOrder.totalCost());
//		
//		// // Check removal
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd1));
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd2));
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
//		// re-calculate total
//		System.out.println("Total Cost is:");
//		System.out.println(anOrder.totalCost());
//
//		// Add dvds using method overloading
//		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
//		
//		// re-calculate total
//		System.out.println("Total Cost is:");
//		System.out.println(anOrder.totalCost());
//		// Check removal
//		
		
	}
}
