package hust.soict.globalict.aims;
import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.DuplicateException;
import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DiskTest {
	public static void main(String[] args) throws MediaValidationException, LimitExceededException, DuplicateException {
		Cart cart = new Cart();
		try {
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
			cart.addMedia(dvd1);
			
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
			cart.addMedia(dvd2);
			
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
			cart.addMedia(dvd3);			
		}catch(MediaValidationException e) {
			System.err.println(e.getMessage());
		}catch(LimitExceededException e) {
			System.err.println(e.getMessage());
		}
		
		// Test full name
		cart.searchByTitle("The Lion King");
		// Test search via token & case insensitive
		cart.searchByTitle("wars");
	}
}
