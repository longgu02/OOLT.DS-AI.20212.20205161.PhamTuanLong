package hust.soict.globalict.aims.comparator;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaSortByCostTitle implements Comparator<Media>{
    @Override
    public int compare(Media media1, Media media2) {
    	if(media2 == null || media1 == null) {
    		return 0;
    	}
    	int costComp = (int)(media2.getCost() - media1.getCost());
        int titleComp = media1.getTitle().compareTo(media2.getTitle());
	    if(costComp == 0) {
	    	return titleComp;
	    }else {
	    	return costComp;
	    }
    }
}
