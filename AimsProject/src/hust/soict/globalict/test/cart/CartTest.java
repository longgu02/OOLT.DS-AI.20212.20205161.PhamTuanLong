package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Add dvds to cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 86, 11.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 10.95f);
		cart.addDigitalVideoDisc(dvd4);
		
		// Test the print method
		cart.printCart();
		// Test the search methods
		cart.searchItemById(2);
		cart.searchItemById(4);
//		System.out.println(dvd2.getId());
	}
}
