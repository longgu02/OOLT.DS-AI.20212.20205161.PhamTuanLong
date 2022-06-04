package hust.soict.globalict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)){
			authors.remove(authorName);
		}
	}
}
