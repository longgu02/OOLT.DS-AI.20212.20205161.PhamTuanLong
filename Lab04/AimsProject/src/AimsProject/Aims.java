package AimsProject;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		// Calculate total
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		
		// // Check removal
		System.out.println(anOrder.removeDigitalVideoDisc(dvd1));
		System.out.println(anOrder.removeDigitalVideoDisc(dvd2));
		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
		// re-calculate total
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());

		// Add dvds using method overloading
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		
		// re-calculate total
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		// Check removal
	}
}
