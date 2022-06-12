package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		ArrayList<Media> myArrList = new ArrayList<Media>();
		// Init
		Media media1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
		Media media2 = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f);
		Media media3 = new Book("Aladin", "Animation", 18.99f);
		Media media4 = new DigitalVideoDisc("The Lion Queen", "Animation","Roger Allers", 87, 19.95f);
		
		myArrList.add(media1);
		myArrList.add(media2);
		myArrList.add(media3);
		myArrList.add(media4);
		
		Iterator<Media> iterator1 = myArrList.iterator();
		
		System.out.println("--------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator1.hasNext()) {
			System.out.println(((Media)iterator1.next()).getTitle());
		}
		
		System.out.println("--------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		Collections.sort(myArrList);
		Iterator<Media> iterator2 = myArrList.iterator();
		while(iterator2.hasNext()) {
			System.out.println(((Media)iterator2.next()).getTitle());
		}
		System.out.println("--------------------------------");
	}
}
