package hust.soict.globalict.test.disc;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParamater {
	static class dvdWrapper{
		DigitalVideoDisc dvd;
		dvdWrapper(DigitalVideoDisc dvd){
			this.dvd = dvd;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		dvdWrapper jungleDVDWrapper = new dvdWrapper(jungleDVD);
		dvdWrapper cinderellaDVDWrapper = new dvdWrapper(cinderellaDVD);
		
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		swap(jungleDVDWrapper, cinderellaDVDWrapper);
		System.out.println("jungle dvd title: " + jungleDVDWrapper.dvd.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVDWrapper.dvd.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	// Rewrite the swap method
	public static void swap(dvdWrapper dvdWrapper1, dvdWrapper dvdWrapper2) {
		DigitalVideoDisc temp = dvdWrapper1.dvd;
		dvdWrapper1.dvd = dvdWrapper2.dvd;
		dvdWrapper2.dvd = temp;
	}

//	public static void swap(Object o1, Object o2) {
//		Object temp = o1;
//		o1 = o2;
//		o2 = temp;
//	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
