package hust.soict.globalict.aims;
import java.util.Scanner;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void placeOrder() {
        if (cart.getItemsOrdered().length > 0) {
            System.out.println("Order is created.");
            cart = new Cart();
        }
        else {
            System.out.println("Your cart is empty.");
        }
	}
	public static void sortDVDInCart() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Sort by Title or Cost? (t/c)");
		char sortChoice = keyboard.next().charAt(0);
		if(sortChoice == 't') {
			cart.sortByTitle();
		}else if(sortChoice == 'c') {
			cart.sortByCost();
		}else {
			System.out.print( "\"" + sortChoice + "\" not exist");
		}
	}
	
	public static void removeDVDFromCart() {
		Scanner keyboard = new Scanner(System.in);
		cart.printCart();
		System.out.println("Enter the id");
		int idDelete = Integer.parseInt(keyboard.nextLine()); 
		DigitalVideoDisc result = cart.searchItemById(idDelete);
		if(result != null) {
			cart.removeDigitalVideoDisc(result);					
			cart.printCart();
		}else {
			System.out.println("DVD with the id \"" + idDelete + "\" not found");
		}
	}
	
	public static void filterDVDInCart() {
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
	
	public static void addDVDToCart() {
		Scanner keyboard = new Scanner(System.in);
		store.printStore();
		System.out.println("Enter the dvd's title: ");
		String titleSearch = keyboard.nextLine().strip();
		DigitalVideoDisc[] result = store.searchByTitle(titleSearch);
		if(result == null) {
			System.out.println("No dvd found");
			return;
		}
		cart.addDigitalVideoDisc(store.searchByTitle(titleSearch));					
		cart.printCart();
		
	}
	
	public static void seeDVDDetail() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter DVD's title: ");
		String titleStr = keyboard.nextLine();
		store.dvdDetail(titleStr);
	}
	
	public static void updateStore() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("You want to add or remove dvd? (a/r)");
		char updateChoice = keyboard.next().charAt(0);
		keyboard.nextLine();
		if(updateChoice == 'a') {
			System.out.print("Title: ");
			String newTitle = keyboard.nextLine();
			System.out.print("Category: ");
			String newCategory = keyboard.nextLine();
			System.out.print("Director: ");
			String newDirector = keyboard.nextLine();
			System.out.print("Length: ");
			int newLength = Integer.parseInt(keyboard.nextLine());
			System.out.print("Cost: ");
			float newCost =	Float.parseFloat(keyboard.nextLine());
			store.addDVD(new DigitalVideoDisc(newTitle, newCategory, newDirector, newLength, newCost));					
		}else if(updateChoice == 'r') {
			System.out.print("Enter the title: ");
			String title = keyboard.nextLine().strip();
			DigitalVideoDisc[] dvds = store.searchByTitle(title);
			for(DigitalVideoDisc dvd: dvds) {
				if(dvd != null) {
					store.removeDVD(dvd);
					store.printStore();
				}else {
					break;
				}
			}
		}else {
			System.out.println("There's no such choice...");
		}
	}
	
	public static void showMenu() {
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
				storeMenu();
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
	
	public static void storeMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a DVD’s details");
			System.out.println("2. Add a DVD to cart");
			System.out.println("3. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			Scanner keyboard = new Scanner(System.in);
			int choice = Integer.parseInt(keyboard.nextLine());
			switch(choice) {
			case 1:
				seeDVDDetail();
				break;
			case 2:
				addDVDToCart();
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
	
	public static void cartMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter DVDs in cart");
			System.out.println("2. Sort DVDs in cart");
			System.out.println("3. Remove DVD from cart");
			System.out.println("4. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			Scanner keyboard = new Scanner(System.in);
			int choice = Integer.parseInt(keyboard.nextLine());
			switch(choice) {
			case 1:
				filterDVDInCart();
				break;
			case 2:
				sortDVDInCart();
				break;
			case 3:
				removeDVDFromCart();
				break;
			case 4:
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
	public static void main(String[] args) {
		showMenu();
	}
}
