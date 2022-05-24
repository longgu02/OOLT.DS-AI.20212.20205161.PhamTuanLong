package hust.soict.globalict.aims.utils;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class DVDUtils {
	// Compare by cost
	public static boolean compareByCost (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(dvd1.getCost() == dvd2.getCost()) {
			return true;
		}
		return false;
	}
	// Compare by title
	public static boolean compareByTitle (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(dvd1.getTitle().equals(dvd2.getTitle())) {
			return true;
		}
		return false;
	}
	// Sorting a number of DVDs by cost
	public static DigitalVideoDisc[] sortByCost (DigitalVideoDisc[] dvdList) {
		for(int i = 0 ; i < dvdList.length; i++) {
			for(int j = i + 1; j < dvdList.length; j++) {
				if(dvdList[j] == null || dvdList[i] == null) break;
				if(dvdList[i].getCost() < dvdList[j].getCost()) {
					DigitalVideoDisc temp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = temp;
				}
			}
		}
		return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByLength (DigitalVideoDisc[] dvdList) {
		for(int i = 0; i < dvdList.length; i++) {
			for(int j = i + 1; j < dvdList.length; j++) {
				if(dvdList[j] == null || dvdList[i] == null) break;
				if(dvdList[i].getLength() < dvdList[j].getLength()) {
					DigitalVideoDisc temp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = temp;
				}
			}
		}
		return dvdList;
	}
	
	// Sorting a number of DVDs by TITLE
	public static DigitalVideoDisc[] sortByTitle (DigitalVideoDisc [] dvdList) {
		for(int i = 0 ; i < dvdList.length; i++) {
			for(int j = i + 1; j < dvdList.length; j++) {
				if(dvdList[j] == null || dvdList[i] == null) break;
				if(dvdList[i].getTitle().compareTo(dvdList[j].getTitle()) > 0) {
					DigitalVideoDisc temp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = temp;
				}
			}
		}
		return dvdList;
	}
}
