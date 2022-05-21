package AimsProject;

public class StoreTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 90, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Hihi", "Animation","Roger Allers", 93, 19.94f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Hehe", "Animation","Roger Allers", 91, 19.93f);
 
		Store store = new Store();
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);

		DigitalVideoDisc[] dvdStored = store.getItemsInStore();
		
		for(int i = 0; i < dvdStored.length; i++) {
			if(dvdStored[i] == null) break;
			System.out.println(dvdStored[i].getTitle());
		}
		store.removeDVD(dvd1);
		dvdStored = store.getItemsInStore();
		
		for(int i = 0; i < dvdStored.length; i++) {
			if(dvdStored[i] == null) break;
			System.out.println(dvdStored[i].getTitle());
		}
		
	}
}
