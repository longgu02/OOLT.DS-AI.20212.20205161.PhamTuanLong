package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	public StoreManagerScreen(Store store) {
		this.store = store;
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;		
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {

		}
	}
	
	JMenuItem createMenuItem(String itemName) {
		JMenuItem item = new JMenuItem(new AbstractAction(itemName){
			public void actionPerformed(ActionEvent e) {
				createMenuBar();
				JPanel center = new JPanel();
//				center.setLayout(new GridLayout(3, 3, 2, 2));
				JLabel title = new JLabel("AIMS");
				center.add(title);
			}
		});
		return item;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(createMenuItem("Add Book"));
		smUpdateStore.add(createMenuItem("Add CD"));
		smUpdateStore.add(createMenuItem("Add DVD"));
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("Logout"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	

	
	JPanel createHeader() {
		JPanel header= new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;	
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		Cart cart = new Cart();
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0 ; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		return center;
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Media media1 = new DigitalVideoDisc("DVD1", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media1);
		Media media2 = new DigitalVideoDisc("DVD2", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
		Media media3 = new CompactDisc("CD1", "Science Fiction", "George Lucas", 24.95f);
		store.addMedia(media3);
		Media media4 = new DigitalVideoDisc("DVD3", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media4);
		Media media5 = new Book("Book1", "Science Fiction", 24.95f);
		store.addMedia(media5);
		Media media6 = new DigitalVideoDisc("DVD4", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media6);
		Media media7 = new Book("Book2", "Science Fiction", 24.95f);
		store.addMedia(media7);
		Media media8 = new Book("Book3", "Science Fiction", 24.95f);
		store.addMedia(media8);
		Media media9 = new Book("Book4", "Science Fiction", 24.95f);
		store.addMedia(media9);
		
		new StoreManagerScreen(store);
	}
}

