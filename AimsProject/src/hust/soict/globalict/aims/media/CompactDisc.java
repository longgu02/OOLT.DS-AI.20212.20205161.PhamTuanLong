package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
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
}
