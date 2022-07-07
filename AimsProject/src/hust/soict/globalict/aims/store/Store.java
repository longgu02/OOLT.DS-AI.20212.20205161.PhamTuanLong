package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	// Initialize the qty counter
	int MAX_ORDERED_PROD = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media Media) throws MediaValidationException{
		if(Media.getTitle() != (null) && !Media.getTitle().equals("")) {
			int i = 0;
			
			if(itemsInStore.contains(Media)) {
				System.out.println("Media already exists");
				return;
			}
			itemsInStore.add(Media);
			System.out.println("Added " + Media);
			return;
		}else {
			throw new MediaValidationException("ERROR: Entered Title is not valid");
		}
	}
	
	public void MediaDetail(String title) throws MediaValidationException{
		boolean found = false;
		// Validation
		if(title != null && !title.equals("")) {
			System.out.println("Entered title is not valid");
			for(Media media : itemsInStore) {
				if(media == null) break;
				if(media.isMatch(title)) {
					System.out.println(media.toString());
					found = true;
				}
			}
			if(!found) System.out.println("Media with title \"" + title + "\" not found");
			return;
		}else {
			throw new MediaValidationException("ERROR: Entered Title is not valid");
		}
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void removeMedia(Media Media) throws NullPointerException{
		int i = 0, k = 0;
		boolean removed = false;
		if(itemsInStore.contains(Media)) {
			itemsInStore.remove(Media);
			removed = true;
		}else {
			throw new NullPointerException("ERROR: Media does not exists in the Store");
		}
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
