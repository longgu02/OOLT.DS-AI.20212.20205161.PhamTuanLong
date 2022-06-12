package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	Media freeItem;
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("Cart is full");
			return;
		}
		// Consider the circumstances that cannot add
		if(!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);	
			System.out.println("Added " + media.getTitle() + " to cart");			
		}else {
			System.out.println(media.getTitle() + " have already been added to cart");
		}
	}
	
	public void addMedia(Media[] medias) {
		// Consider the circumstances that cannot add
		for(Media media: medias) {
			if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
				System.out.println("Cart is full");
				break;
			}
			if(media == null) break;
			if(!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);	
				System.out.println("Added " + media.getTitle() + " to cart");			
			}else {
				System.out.println(media.getTitle() + " have already been added to cart");
			}
		}
	}
	public boolean removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			return true;
		}else {
			System.out.println("\"" + media.getTitle() + "\" haven't been added to cart");
			return false;
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
	
	public final ArrayList<Media> sortByTitle() {
		ArrayList<Media> itemsDisplay = this.getItemsOrdered();; // immutability
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
	
	public ArrayList<Media> searchItemByTitle(String title) {
		boolean found = false;
		ArrayList<Media> matchMedias = new ArrayList<Media>();
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
	
	public void play(Media media) {
		if(media instanceof Playable) {
			((Playable) media).play();
		}else {
			System.out.println("Cannot play this type of Media (" + media.toString() + ")");
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
