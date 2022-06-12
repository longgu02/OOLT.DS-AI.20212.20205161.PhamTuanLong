package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;

public class BookTest {
	public static void main(String[] args) {
		Media media = new Book("Aladin", "Animation", 18.99f);
		((Book)media).addAuthor("Long");
		((Book)media).addAuthor("Minh");
		((Book)media).updateContent("Hello, World! I am Book, Nice to meet you. Purchase me if you want to read me.");
		System.out.println(media.toString());
	}
}
