package hust.soict.globalict.aims.cart;
import java.util.Collections;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.DuplicateException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	Media freeItem;
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) throws DuplicateException ,LimitExceededException{
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if(!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);	
				System.out.println("Added " + media.getTitle() + " to cart");			
			}else {
				throw new DuplicateException(media.getTitle() + " have already been added to cart");
			}
			return;
		}else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}
	
	public void addMedia(Media[] medias) throws LimitExceededException {
		for(Media media: medias) {
			if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				if(media == null) break;
				if(!itemsOrdered.contains(media)) {
					itemsOrdered.add(media);	
					System.out.println("Added " + media.getTitle() + " to cart");			
				}else {
					System.out.println(media.getTitle() + " have already been added to cart");
				}
			}else {
				throw new LimitExceededException("ERROR: The number of " + "media has reached its limit");
			}
		}
	}
	public void removeMedia(Media media) throws NullPointerException{
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
		}else {
			throw new NullPointerException("ERROR: Media have not been add to cart");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		for(int i = 0; i < dvdList.length; i++) {
//			itemsOrdered[qtyOrdered++] = dvdList[i];
//			System.out.println("Added " + dvdList[i].getTitle() + " to cart");
//			if(qtyOrdered == MAX_NUMBERS_ORDERED) {
//				System.out.println("Cart is full");
//				break;
//			}
//		}
//	}
//	
//	public void addMedia(DigitalVideoDisc... dvdList) {
//		for(DigitalVideoDisc dvd: dvdList) {
//			itemsOrdered.add(dvd);
//			System.out.println("Added " + dvd.getTitle() + " to cart");
//		}
//	}
	
//	public void addMedia(Media media1, Media media2) {
//		itemsOrdered.add(media1);
//		itemsOrdered.add(media2);
//	}
	
	public float totalCost() {
		float total = 0;
		for(Media media: itemsOrdered) {
			if(media == null) break;
			if(media == freeItem) continue;
			total += media.getCost();
		}
		return total;
	}
	
	public void printCart() {
		List<Media> itemsDisplay = this.sortByTitle(); // immutability
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(Media media: itemsDisplay) {
			if(media == null) break;
			if(media == freeItem) {
				System.out.println(media.toString() + " (FREE)");
				continue;
			}
			System.out.println(media.toString());
		}
		System.out.println("Total cost: " + String.format("%.2f", totalCost()));
		System.out.println("**************************************************");
	}
	
	public Media getFreeItem() {
		return freeItem;
	}

	public void setFreeItem(Media freeItem) {
		this.freeItem = freeItem;
	}

	public Media searchItemById(int id) {
		Media result;
		boolean found = false;
		for(Media media: itemsOrdered) {
			if(id == media.getId()) {
				result = media;
				System.out.println(media.toString());
				return result;
			}
		}
		System.out.println("No item with ID: " + id + " found!");
		return null;			
	}
	
	public final ObservableList<Media> sortByTitle() {
		ObservableList<Media> itemsDisplay = this.getItemsOrdered();; // immutability
		Collections.sort(itemsDisplay,Media.COMPARE_BY_TITLE_COST);  
		return itemsDisplay;
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		System.out.println("******************SEARCH RESULT******************");
		for(Media media : itemsOrdered) {
			if(media == null) break;
			if(media.isMatch(title)) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if(found) {
			System.out.println("************************************************");
			return;
		}else {
			System.out.println("Media with title \"" + title + "\" not found");			
			return;
		}
	}
	
	public ObservableList<Media> searchItemByTitle(String title) {
		boolean found = false;
		ObservableList<Media> matchMedias = FXCollections.observableArrayList();
		for(Media media : itemsOrdered) {
			if(media == null) break;
			if(media.isMatch(title)) {
				matchMedias.add(media);
				found = true;
			}
		}
		if(found) return matchMedias;
		return null;
	}
	
	public void play(Media media) throws PlayerException {
		try {
			if(media instanceof Playable) {
				((Playable) media).play();
			}else {
				System.out.println("Cannot play this type of Media (" + media.toString() + ")");
			}
		}catch(PlayerException e){
			throw e;
		}
	}
	
	public Media getALuckyItem() {
		int numOfItem  = itemsOrdered.size();
		if(numOfItem >= 5) {
			freeItem = itemsOrdered.get((int)(Math.random()*numOfItem));
			System.out.println("Congrats, you get \"" + freeItem.getTitle() + "\" for free!");
			return freeItem;
		}else {
			System.out.println("Atleast 5 item in the cart to get a lucky item");
			return null;
		}
	}
}
