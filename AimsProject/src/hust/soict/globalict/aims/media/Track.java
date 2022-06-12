package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.playable.Playable;
public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		return this.title + " - " + this.length;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Track)) return false;
		Track obj = (Track)o;
		if(obj.getTitle() == title && obj.getLength() == length) {
			return true;
		}
		return false;
	}
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
}
