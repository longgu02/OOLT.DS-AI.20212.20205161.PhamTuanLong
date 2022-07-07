package hust.soict.globalict.aims.media;
import java.util.ArrayList;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.playable.Playable;

public class CompactDisc extends Media implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category,String artist ,float cost) {
		super(title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);			
			return;
		}
		System.out.println("Track has already in the CD");
	}
	public void removeTrack(Track track) {
		tracks.remove(track);
	}
	public int getLength() {
		int totalLength = 0;
		for(Track track:tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	@Override
	public String toString() {
		return this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
	
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track)iter.next();
				try {
					nextTrack.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
}
