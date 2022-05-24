package hust.soict.globalict.aims.disc;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDateTime dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDateTime.now();
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDateTime.now();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDateTime.now();
	}
	public float getCost() {
		return cost;
	}
	public String toString() {
		String str = this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
		return str;
	}
	public boolean isMatch(String title) {
		String[] searchTokens = title.toLowerCase().split(" ");
		String[] dvdTokens = this.getTitle().toLowerCase().split(" ");
		for(String token : searchTokens) {
			if(Arrays.asList(dvdTokens).contains(token)) {
				return true;
			}
		}
		return false;
	}
}
