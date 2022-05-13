package AimsProject;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
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
}
