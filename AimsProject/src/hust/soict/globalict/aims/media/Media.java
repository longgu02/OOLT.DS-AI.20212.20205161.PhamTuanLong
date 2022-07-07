package hust.soict.globalict.aims.media;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.comparator.MediaSortByCostTitle;
import hust.soict.globalict.aims.comparator.MediaSortByTitleCost;
import hust.soict.globalict.aims.exception.MediaValidationException;

public class Media implements Comparable<Media>{
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDateTime dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	// Constructors
	public Media(String title, String category, float cost) throws MediaValidationException{
		super();
		if(title != null) {
			this.title = title;
		}else {
			throw new MediaValidationException("ERROR: Entered Title string is invalid!");
		}
		if(category != null) {
			this.category = category;
		}else {
			throw new MediaValidationException("ERROR: Entered Category string is invalid!");
		}
		if(cost > 0) {
			this.cost = cost;
		}else {
			throw new MediaValidationException("ERROR: Entered cost must be non-positive");
		}
			nbDigitalVideoDiscs++;
			this.id = nbDigitalVideoDiscs;
			this.dateAdded = LocalDateTime.now();
	}
	
	public String toString() {
		String str = this.getTitle() + " - " + this.getCategory() + " - "  + ": " + this.getCost() + "$";
		return str;
	}
	
	public Media(String title) {
		super();		
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	// End of constructors
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isMatch(String title) {
		String[] searchTokens = title.toLowerCase().split(" ");
		String[] dvdTokens = this.getTitle().toLowerCase().split(" ");
		for(String token : searchTokens) {
			if(Arrays.asList(dvdTokens).contains(token)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean equals(Object o) {
		try {
			if(!(o instanceof Media)) return false;
			Media obj = (Media)o;
			if(obj.getId() == id) {
				return true;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(ClassCastException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int compareTo(Media obj) {
		try {
			if(!(obj instanceof Media)) return -1;
			Media castMedia = (Media)obj;
			int compareTitle = title.compareTo(castMedia.getTitle());
			int compareCategory = category.compareTo(castMedia.getCategory());
			if(compareTitle == 0) return compareCategory;
			return compareTitle;			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(ClassCastException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaSortByCostTitle();
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaSortByTitleCost();
	
}
