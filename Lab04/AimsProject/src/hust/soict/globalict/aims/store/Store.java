package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	// Initialize the qty counter
	int MAX_ORDERED_PROD = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ORDERED_PROD];
	
	public void addDVD(DigitalVideoDisc dvd) {
		if(dvd.getTitle() == null || dvd.getTitle().equals("") || !dvd.getTitle().matches("[a-zA-Z]*")) {
			System.out.println("Entered Title is not valid");
			return;
		}
		int i = 0;
		while(itemsInStore[i] != null) {
			i++;
		};
		itemsInStore[i] = dvd;
		System.out.println("Added " + itemsInStore[i]);
	}
	
	public void dvdDetail(String title) {
		// Validation
		if(title == null || title.equals("") || !title.matches("[a-zA-Z]*")) {
			System.out.println("Entered Title is not valid");
			return;
		}
		for(DigitalVideoDisc dvd : itemsInStore) {
			if(dvd == null) break;
			if(dvd.isMatch(title)) {
				System.out.println(dvd.toString());
				
				return;
			}
		}
		System.out.println("DVD with title \"" + title + "\" not found");
		return;
	}
	
	public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}

	public void removeDVD(DigitalVideoDisc dvd) {
		int i = 0, k = 0;
		DigitalVideoDisc newItemsInStore[] = new DigitalVideoDisc[MAX_ORDERED_PROD];
		while(itemsInStore[i] != null) {
			if(itemsInStore[i] == dvd) {
				System.out.println("Removed " + itemsInStore[i].getTitle());
				i++;
				continue;
			}
			newItemsInStore[k++] = itemsInStore[i++];
		}
		itemsInStore = newItemsInStore;
	}
	
	public void printStore() {
			System.out.println("***********************STORE***********************");
			for(DigitalVideoDisc dvd : itemsInStore) {
				if(dvd == null) break;
				System.out.println(dvd.getId() + ". DVD - " + dvd.toString());
			};
			System.out.println("***************************************************");
	}
	
	public DigitalVideoDisc[] searchByTitle(String title) {
		DigitalVideoDisc[] result = new DigitalVideoDisc[20];
		int counter = 0;
		for(DigitalVideoDisc dvd : itemsInStore) {
			if(dvd == null) break;
			if(dvd.isMatch(title)) {
				result[counter++] = dvd;
			}
		}
		return result;
	}
}
