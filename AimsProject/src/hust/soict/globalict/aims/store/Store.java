package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	// Initialize the qty counter
	int MAX_ORDERED_PROD = 100;
	private Media itemsInStore[] = new Media[MAX_ORDERED_PROD];
	
	public void addMedia(Media Media) {
		if(Media.getTitle() == null || Media.getTitle().equals("")) {
			System.out.println("Entered Title is not valid");
			return;
		}
		int i = 0;
		while(itemsInStore[i] != null) {
			i++;
		};
		itemsInStore[i] = Media;
		System.out.println("Added " + itemsInStore[i]);
	}
	
	public void MediaDetail(String title) {
		boolean found = false;
		// Validation
		if(title == null || title.equals("")) {
			System.out.println("Entered title is not valid");
			return;
		}
		for(Media media : itemsInStore) {
			if(media == null) break;
			if(media.isMatch(title)) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if(!found) System.out.println("Media with title \"" + title + "\" not found");
		return;
	}
	
	public Media[] getItemsInStore() {
		return itemsInStore;
	}

	public void removeMedia(Media Media) {
		int i = 0, k = 0;
		boolean removed = false;
		Media newItemsInStore[] = new Media[MAX_ORDERED_PROD];
		while(itemsInStore[i] != null) {
			if(itemsInStore[i] == Media) {
				System.out.println("Removed " + itemsInStore[i].getTitle());
				i++;
				removed = true;
				continue;
			}
			newItemsInStore[k++] = itemsInStore[i++];
		}
		itemsInStore = newItemsInStore;
		if(!removed) {
			System.out.println("Error");
		}
	}
	
	public void printStore() {
			System.out.println("***********************STORE***********************");
			for(Media media : itemsInStore) {
				if(media == null) break;
				if(media instanceof DigitalVideoDisc) {
					System.out.println(media.getId() + ". DVD - " + media.toString());
				}else if(media instanceof CompactDisc) {
					System.out.println(media.getId() + ". CD - " + media.toString());
				}else if(media instanceof Book) {
					System.out.println(media.getId() + ". Book - " + media.toString());
				}
				
			};
			System.out.println("***************************************************");
	}
	
	public Media[] searchByTitle(String title) {
		Media[] result = new Media[20];
		int counter = 0;
		for(Media media : itemsInStore) {
			if(media == null) break;
			if(media.isMatch(title)) {
				result[counter++] = media;
			}
		}
		if(counter == 0) {
			System.out.println("Item with the title " + title + " not exist");
		}
		return result;
	}
}
