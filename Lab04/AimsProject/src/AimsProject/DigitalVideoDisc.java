package AimsProject;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private java.time.LocalDate dateAdded;
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
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
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
	}
	public float getCost() {
		return cost;
	}
}
