package hust.soict.globalict.aims;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.collections.ObservableList;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void placeOrder() {
        if (cart.getItemsOrdered().size() > 0) {
            System.out.println("Order is created.");
            cart.getALuckyItem();
            cart.printCart();
            cart = new Cart();
        }
        else {
            System.out.println("Your cart is empty.");
        }
	}
	
	public static void playMediaInCart() throws PlayerException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the media title that you want to play");
		String searchTitle = keyboard.nextLine();
		ObservableList<Media> matchMedias = cart.searchItemByTitle(searchTitle);
		try {
			for(Media media: matchMedias) {
				cart.play(media);
			}			
		}catch(PlayerException e){
			throw e;
		}
	}
	
	public static void playMedia() throws PlayerException{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the media title that you want to play");
		String searchTitle = keyboard.nextLine();
		Media[] matchMedia = store.searchByTitle(searchTitle);
		for(Media media: matchMedia) {
			if(media == null) break;
			try {
				if(media instanceof Playable) {
					((Playable) media).play();
				}else {
					System.out.println("Cannot play this type of Media (" + media.toString() + ")");
				}				
			}catch(PlayerException e) {
				throw e;
			}
		}
	}
	
	//Fix
	public static void sortMediaInCart() {
		Scanner keyboard = new Scanner(System.in);
		ObservableList<Media> itemsOrdered = cart.getItemsOrdered();
		System.out.println("Sort by Title or Cost? (t/c)");
		char sortChoice = keyboard.next().charAt(0);
		
		if(sortChoice == 't') {
			System.out.println("***********************CART***********************");
			Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);  
			Iterator<Media> itr=itemsOrdered.iterator();  
			while(itr.hasNext()){  
				Media curMedia = (Media)itr.next();  
				if(curMedia == null) break;
				System.out.println(curMedia.toString());
			}  
			System.out.println("**************************************************");
		}else if(sortChoice == 'c') {
			System.out.println("***********************CART***********************");
			Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);  
			Iterator<Media> itr=itemsOrdered.iterator();  
			while(itr.hasNext()){  
				Media curMedia = (Media)itr.next();  
				if(curMedia == null) break;
				System.out.println(curMedia.toString());
			}  
			System.out.println("**************************************************");
		}else {
			System.out.print( "\"" + sortChoice + "\" not exist");
		}
	}
	//Fix
	public static void removeMediaFromCart() {
		Scanner keyboard = new Scanner(System.in);
		cart.printCart();
		System.out.println("Enter the id");
		int idDelete = Integer.parseInt(keyboard.nextLine()); 
		Media result = cart.searchItemById(idDelete);
		if(result != null) {
			try {
				cart.removeMedia(result);
				cart.printCart();							
			}catch(NullPointerException e) {
				System.err.println(e.getMessage());
			}
		}else {
			System.out.println("Media with the id \"" + idDelete + "\" not found");
		}
	}
	
	public static void filterMediaInCart() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Do you want to filer by ID or by Title? (i/t)");
		char sortChoice = keyboard.next().charAt(0);
		keyboard.nextLine(); 
		if(sortChoice == 'i') {
			System.out.println("Enter id (positive integer): ");
			int idFilter = Integer.parseInt(keyboard.nextLine());
			cart.searchItemById(idFilter);
		}else if(sortChoice == 't') {
			System.out.println("Enter title: ");
			String titleFilter = keyboard.nextLine();
			cart.searchByTitle(titleFilter);
		}else {
			System.out.println("No such choice");
		}			
	}
	
	public static void addMediaToCart() {
		Scanner keyboard = new Scanner(System.in);
		store.printStore();
		System.out.println("Enter the Media's title: ");
		String titleSearch = keyboard.nextLine().strip();
		// Maybe search by exact title?
		try {
			Media[] result = store.searchByTitle(titleSearch);
			if(result == null) {
				System.out.println("No Media found");
				return;
			}
			cart.addMedia(result);
			cart.printCart();
			
		}catch(LimitExceededException e) {
			e.printStackTrace();
		}
	}
	
	public static void seeMediaDetail() throws MediaValidationException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Media's title: ");
		String titleStr = keyboard.nextLine();
		store.MediaDetail(titleStr);
	}
	
	public static void updateStore() throws MediaValidationException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("You want to add or remove Media? (a/r)");
		char updateChoice = keyboard.next().charAt(0);
		keyboard.nextLine();
		if(updateChoice == 'a') {
			System.out.print("Type of Media (Book/DVD/CD - 1/2/3): ");
			int newType = Integer.parseInt(keyboard.nextLine());
			System.out.print("Title: ");
			String newTitle = keyboard.nextLine();
			System.out.print("Category: ");
			String newCategory = keyboard.nextLine();
			System.out.print("Cost: ");
			float newCost =	Float.parseFloat(keyboard.nextLine());
			switch(newType) {
				case 1:
					Book newBook = new Book(newTitle, newCategory, newCost);
					System.out.print("Number of Authors (positive): ");
					int numOfAuth = Integer.parseInt(keyboard.nextLine());
					if(numOfAuth <= 0) {
						System.out.println("So this book dont have author.");
					}
					for(int i = 0; i < numOfAuth; i++) {
						System.out.print("Enter name of author " + i+1 + ": ");
						String newAuthorName = keyboard.nextLine();
						newBook.addAuthor(newAuthorName);
					}
					store.addMedia(newBook);
					break;	
				case 2:
					System.out.print("Director: ");
					String newDirector = keyboard.nextLine();
					System.out.print("Length: ");
					int newLength = Integer.parseInt(keyboard.nextLine());
					store.addMedia(new DigitalVideoDisc(newTitle, newCategory, newDirector, newLength, newCost));
					break;
				case 3:
					System.out.print("Artist: ");
					String newArtist = keyboard.nextLine();
					store.addMedia(new CompactDisc(newTitle, newCategory, newArtist, newCost));
					break;
			}		
		}else if(updateChoice == 'r') {
			System.out.print("Enter the title: ");
			String title = keyboard.nextLine().strip();
			Media[] Medias = store.searchByTitle(title);
			for(Media Media: Medias) {
				if(Media != null) {
					store.removeMedia(Media);
					store.printStore();
				}else {
					break;
				}
			}
		}else {
			System.out.println("There's no such choice...");
		}
	}
	
	public static void showMenu() throws PlayerException, MediaValidationException{
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			Scanner keyboard = new Scanner(System.in);
			int choice = keyboard.nextInt();
			switch(choice) {
			case 1:
				try {
					storeMenu();					
				}catch(PlayerException e) {
					throw e;
				}
				break;
			case 2:
				updateStore();
				break;
			case 3:
				cartMenu();
				break;
			case 0:
				break;
			default:
				break;
			}
			if(choice == 0) {
				break;
			}
		}
	}
	
	public static void storeMenu() throws PlayerException, MediaValidationException{
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a Media’s details");
			System.out.println("2. Add a Media to cart");
			System.out.println("3. See current cart");
			System.out.println("4. Play a Media");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			Scanner keyboard = new Scanner(System.in);
			int choice = Integer.parseInt(keyboard.nextLine());
			switch(choice) {
			case 1:
				seeMediaDetail();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				cartMenu();
				break;
			case 4:
				try {
					playMedia();					
				}catch(PlayerException e) {
					throw e;
				}
				break;
			case 0:
				break;
			default:
				break;
			}
			if(choice == 0) {
				break;
			}
		}
	}
	
	public static void cartMenu() throws PlayerException{
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter Medias in cart");
			System.out.println("2. Sort Medias in cart");
			System.out.println("3. Remove Media from cart");
			System.out.println("4. Play Media in cart");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			Scanner keyboard = new Scanner(System.in);
			int choice = Integer.parseInt(keyboard.nextLine());
			switch(choice) {
			case 1:
				filterMediaInCart();
				break;
			case 2:
				sortMediaInCart();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				try {
					playMediaInCart();					
				}catch(PlayerException e) {
					throw e;
				}
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				break;
			default:
				System.out.print("Choice \"" + choice + "\" not exist");
				break;
			}
			if(choice == 0) {
				System.out.println("Bye");
				break;
			}
		}
	}
	public static void main(String[] args) throws PlayerException, MediaValidationException{
//		MemoryDaemon myMemoryDaemon = new MemoryDaemon();
//		MyThread myThread1 = new MyThread();
//		MyThread myThread2 = new MyThread();
//		myThread1.setDaemon(true);
//		myThread2.setDaemon(true);
//		myThread1.start();
//		myThread2.start();
//		
//
//		myMemoryDaemon.run();
		Media media1 = null;
		Media media2 = null;
		try {
			media1 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
			media2 = new DigitalVideoDisc("Star Warss", "Science Fiction", "George Lucas", 87, 24.95f);
		} catch (MediaValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object hehe = new Object();
//		if(media1.equals(hehe)) System.out.println("True");
//		else System.out.println("False");
		System.out.println(media1.compareTo(media2));
		try {
			showMenu();			
		}catch(PlayerException err) {
			throw err;
		}
	}
}
