package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
//	@Override
//	public String toString() {
//		return this.getTitle() + " - " + this.getCategory() + " - " + contentTokens.size() + " - " + wordFrequency + ": " + this.getCost() + "$";
//	}
//	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)){
			authors.remove(authorName);
		}
	}
	
	@Override
	public String toString() {
		int length = (content.split("[\\p{Punct}\\s]+")).length;
		return  getTitle() + " - " + getCategory()  + " - "  +  "authors: " + authors + " - content.length: " + length + " - token list: " + contentTokens
				+ " - word frequency: " + wordFrequency + ": " + getCost() + "$";
	}
	public void updateContent(String contentUpdate) {
		content = contentUpdate;
		processContent();
	}

	public void processContent(){
		String tokens[] = content.split("[\\p{Punct}\\s]+");
		int counter = 0;
		for(String token: tokens) {
			if(token == null) break;
				contentTokens.add(token);				
		}
		Collections.sort(contentTokens);
		ListIterator<String> itr= contentTokens.listIterator();  
		while(itr.hasNext()){  
			String prevToken = null;
			if(itr.hasPrevious()) {
				prevToken = contentTokens.get(itr.previousIndex());	
				itr.nextIndex();
			}
			String curToken = contentTokens.get(itr.nextIndex());  
			if(curToken.equals(prevToken)) counter++;
			else counter = 1;
			wordFrequency.put(curToken, counter);
			if(itr.hasNext()) itr.next();
		}  
		
       List<String> tempList = new ArrayList<String>();
        for (String element : contentTokens) {
            if (!tempList.contains(element)) {
                tempList.add(element);
            }
        }
        contentTokens = tempList;
	}
	
}
