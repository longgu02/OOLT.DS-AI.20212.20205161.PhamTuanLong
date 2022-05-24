package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;
import java.util.Arrays;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc [] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered != MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;			
		}
	}
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc[] newItemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		boolean isSuccessful = false;
		for(int i = 0, k = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				isSuccessful = true;
				continue;
			}
			newItemsOrdered[k++] = itemsOrdered[i];	
		}
		itemsOrdered = newItemsOrdered;
		if(isSuccessful) qtyOrdered--;
		return isSuccessful;
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
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for(int i = 0; i < dvdList.length; i++) {
			if(dvdList[i] == null) break;
			itemsOrdered[qtyOrdered++] = dvdList[i];
			System.out.println("Added " + dvdList[i].getTitle() + " to cart");
			if(qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("Cart is full");
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered <= MAX_NUMBERS_ORDERED - 2) {
			itemsOrdered[qtyOrdered++] = dvd1;			
			itemsOrdered[qtyOrdered++] = dvd2;
		}
	}
	
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	// Increasing (Currently decreasing)
	public DigitalVideoDisc[] sortByCost () {
		// immutability
		DigitalVideoDisc[] itemsSorted = DVDUtils.sortByCost(itemsOrdered);
		DigitalVideoDisc[] temp = new DigitalVideoDisc[20];
		temp[0] = itemsSorted[0];
		int counter = 1;
		for(int i = 1 ; i < itemsSorted.length; i++) {
			if(itemsSorted[i] == null) break;
			if(DVDUtils.compareByCost(itemsSorted[i], itemsSorted[i-1])) {
				temp[counter] = itemsSorted[i];
				counter++;
			}else {
				temp = DVDUtils.sortByTitle(temp);
				int end = i + counter - 3;
				while(counter > 1) {
					itemsSorted[end] = temp[counter - 1];
					end--;
					counter--;
				}
				temp[0] = itemsSorted[i];
			}
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0 ; i < qtyOrdered; i++) {
			if(itemsSorted[i] == null) break;
			System.out.println(i + 1 + ". DVD - " + itemsSorted[i].toString());
		};
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
		return itemsSorted;
	}
	
	public DigitalVideoDisc[] sortByTitle () {
		// immutability
		DigitalVideoDisc[] itemsSorted = DVDUtils.sortByTitle(itemsOrdered);
		DigitalVideoDisc[] temp = new DigitalVideoDisc[20];
		temp[0] = itemsSorted[0];
		int counter = 1;
		for(int i = 1 ; i < itemsSorted.length; i++) {
			if(itemsSorted[i] == null) break;
			if(DVDUtils.compareByTitle(itemsSorted[i], itemsSorted[i-1])) {
				temp[counter] = itemsSorted[i];
				counter++;
			}else {
				temp = DVDUtils.sortByCost(temp);
				int end = i + counter - 3;
				while(counter > 1) {
					itemsSorted[end] = temp[counter - 1];
					end--;
					counter--;
				}
				temp[0] = itemsSorted[i];
			}
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0 ; i < qtyOrdered; i++) {
			if(itemsSorted[i] == null) break;
			System.out.println(i + 1 + ". DVD - " + itemsSorted[i].toString());
		};
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
		return itemsSorted;
	}
	
	public void printCart() {
		DigitalVideoDisc[] itemSort = DVDUtils.sortByTitle(itemsOrdered);
		// Thieu truong hop trong bubble sort =================
		for(int i = 1 ; i < itemSort.length; i++) {
			if(itemSort[i] == null) break;
			if(DVDUtils.compareByTitle(itemSort[i], itemSort[i-1])) {
				DigitalVideoDisc[] temp = {itemSort[i], itemSort[i-1]};
				if(DVDUtils.compareByCost(itemSort[i], itemSort[i-1])) {
					temp = DVDUtils.sortByLength(temp);
					itemSort[i] = temp[1];
					itemSort[i-1] = temp[0];
				}else {
					temp = DVDUtils.sortByCost(temp);
					itemSort[i] = temp[1];
					itemSort[i-1] = temp[0];
				}
			}
		}
		
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0 ; i < qtyOrdered; i++) {
			if(itemSort[i] == null) break;
			System.out.println(i + 1 + ". DVD - " + itemSort[i].toString());
		};
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
		
	}
	
	public DigitalVideoDisc searchItemById(int id) {
		for(DigitalVideoDisc dvd: itemsOrdered) {
			if(dvd == null) break;
			if(id == dvd.getId()) {
				System.out.println("ID " + dvd.getId() + ": " + dvd.toString());
				return dvd;
			}
		}
		System.out.println("No item with ID: " + id + " found!");
		return null;
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		System.out.println("******************SEARCH RESULT******************");
		for(DigitalVideoDisc dvd : itemsOrdered) {
			if(dvd == null) break;
			if(dvd.isMatch(title)) {
				System.out.println(dvd.toString());
				found = true;
			}
		}
		if(found) {
			System.out.println("************************************************");
			return;
		}else {
			System.out.println("DVD with title \"" + title + "\" not found");			
			return;
		}
	}
}
