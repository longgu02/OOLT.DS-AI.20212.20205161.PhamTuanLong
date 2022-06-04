package hust.soict.globalict.aims.media;

import java.time.LocalDateTime;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDateTime dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	public Media() {
		// TODO Auto-generated constructor stub
	}
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

}
