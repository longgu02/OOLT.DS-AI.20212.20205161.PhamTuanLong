package AimsProject;

public class Store {
	// Initialize the qty counter
	int MAX_ORDERED_PROD = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ORDERED_PROD];
	
	public void addDVD(DigitalVideoDisc dvd) {
		int i = 0;
		while(itemsInStore[i] != null) {
			i++;
		};
		itemsInStore[i] = dvd;
		System.out.println("Added " + itemsInStore[i]);
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
}
