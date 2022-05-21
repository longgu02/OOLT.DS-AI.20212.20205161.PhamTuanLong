package AimsProject;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc [] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered != MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;			
		}
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
	public void sortByCost () {
		// immutability
		itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items");
		for(int i = 0 ; i < qtyOrdered; i++) {
			System.out.println(i + 1 + ".DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + '$');
		};
	}
	
//	 Sort the DVDs in the cart by cost and print the result
//	 - Sort the DVDs in the cart by title and print the result
//	 - Search for DVDs in the cart by ID and display the search results. Make sure to notify the user if no match
//	 is found.
//	 - Create a new method to print the list of ordered items of a cart, the price of each item, and the total price.
//	 The order of DVDs should be alphabetical, then by cost (decreasing), then by length (decreasing). Format
//	 the outline as below:
	
	public void printCart() {
		DigitalVideoDisc[] itemSort = itemsOrdered;
//		itemSort = DVDUtils.sortByTitle(itemSort);
//		itemSort = DVDUtils.sortByCost(itemSort);
//		itemSort = DVDUtils.sortByLength(itemSort);
		
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0 ; i < qtyOrdered; i++) {
			System.out.println(i + 1 + ".DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + '$');
		};
		System.out.println("**************************************************");
	}

	// 8. Search dvd in cart
//	public boolean isMatch(String title) {
//		for(int i = 0 ; i < qtyOrdered; i++) {
//			if(title.toLowerCase().equals(itemsOrdered[i].getTitle())) {
//				return true;
//			}
//				
//		}
//		return false;
//	}
	
	public void searchItemById(int id) {
//		int index = itemOrdered.indexOf()
		for(int i = 0; i < qtyOrdered; i++) {
			if(id == itemsOrdered[i].getId()) {
				System.out.println(itemsOrdered[i].getId() + ' ' + itemsOrdered[i].getTitle());
				return;
			}
		}
		System.out.println("No item with ID: " + id + " found!");
		return;
	}
	
}
