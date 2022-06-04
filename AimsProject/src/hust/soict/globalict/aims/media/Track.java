package hust.soict.globalict.aims.media;

public class Track extends Media{
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
	public Track() {
		// TODO Auto-generated constructor stub
	}

}
