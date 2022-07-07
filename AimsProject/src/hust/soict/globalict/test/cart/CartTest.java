package hust.soict.globalict.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.DuplicateException;
import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class CartTest {
	public static void main(String[] args) throws MediaValidationException, LimitExceededException, DuplicateException {
		// Create a new cart
		Cart cart = new Cart();
		
		// Add dvds to cart
		try {
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
			cart.addMedia(dvd1);
			
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 86, 11.95f);
			cart.addMedia(dvd2);
			
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
			cart.addMedia(dvd3);
			
			DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 10.95f);
			cart.addMedia(dvd4);			
		}catch(MediaValidationException e) {
			System.err.println(e.getMessage());
		}catch(LimitExceededException e) {
			System.err.println(e.getMessage());
		}
		
		// Test the print method
		cart.printCart();
		// Test the search methods
		cart.searchItemById(2);
		cart.searchItemById(4);
//		System.out.println(dvd2.getId());
	}
}
