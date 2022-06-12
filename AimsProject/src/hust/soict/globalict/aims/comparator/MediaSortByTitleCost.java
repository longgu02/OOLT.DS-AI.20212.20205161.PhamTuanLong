package hust.soict.globalict.aims.comparator;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaSortByTitleCost implements Comparator<Media>{
    @Override
    public int compare(Media media1, Media media2) {
    	if(media2 == null || media1 == null) {
    		return 0;
    	}
    	int costComp = (int)(media2.getCost() - media1.getCost());

	    int titleComp = media1.getTitle().compareTo(media2.getTitle());
	    if(titleComp == 0) {
	    	return costComp;
	    }else {
	    	return titleComp;
	    }
    }
}
