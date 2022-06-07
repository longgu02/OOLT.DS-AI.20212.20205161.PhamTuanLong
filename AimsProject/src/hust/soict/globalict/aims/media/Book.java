package hust.soict.globalict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	@Override
	public String toString() {
		return this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + "$";
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)){
			authors.remove(authorName);
		}
	}
}
