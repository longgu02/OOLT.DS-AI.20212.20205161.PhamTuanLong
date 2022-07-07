package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.playable.Playable;
public class DigitalVideoDisc extends Media implements Playable{
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());			
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
	@Override
	public String toString() {
		return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}

}
