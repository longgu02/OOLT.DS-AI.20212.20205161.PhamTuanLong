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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	private AddBookToStoreScreen AddBook;
	private AddCompactDiscToStoreScreen AddCD;
	private AddDigitalVideoDiscToStoreScreen AddDVD;
	private Container cp;
	private JPanel center;
	
	public StoreManagerScreen(Store store) throws PlayerException{
		this.store = store;
		AddDVD = new AddDigitalVideoDiscToStoreScreen(store);
		AddBook = new AddBookToStoreScreen(store);
		AddCD = new AddCompactDiscToStoreScreen(store);
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		try {
			cp.add(createCenter(), BorderLayout.CENTER);			
		}catch(PlayerException e) {
			throw e;
		}
		
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
				cp.removeAll();
				cp.add(createNorth(), BorderLayout.NORTH);
				
				if(itemName.equals("Add Book")) {
					cp.add(AddBook.getPanel(), BorderLayout.CENTER);
				}else if(itemName.equals("Add CD")) {
					cp.add(AddCD.getPanel(), BorderLayout.CENTER);
				}else if (itemName.equals("Add DVD")){
					cp.add(AddDVD.getPanel(), BorderLayout.CENTER);
				}else if(itemName.equals("View store")){
					try {
						cp.add(createCenter(), BorderLayout.CENTER);						
					}catch(PlayerException err) {
						JDialog playDialog = new JDialog();
						JLabel playLabel = new JLabel(err.getMessage());
						playDialog.add(playLabel, BorderLayout.CENTER);
						playDialog.setTitle("Illegal DVD length");
						playDialog.setSize(500,500);
						playDialog.setVisible(true);
					}
				}
				cp.repaint();
				cp.revalidate();
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
		menu.add(createMenuItem("View store"));
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
	
	JPanel createCenter() throws PlayerException{
		center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		Cart cart = new Cart();
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(Media media: mediaInStore) {
			try {
				MediaStore cell = new MediaStore(media, cart);
				center.add(cell);				
			}catch(PlayerException e) {
				throw e;
			}
		}
		return center;
	}
	
	public static void main(String[] args) throws MediaValidationException {
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
		try {
			new StoreManagerScreen(store);			
		}catch(PlayerException err) {
			JDialog playDialog = new JDialog();
			JLabel playLabel = new JLabel(err.getMessage());
			playDialog.add(playLabel, BorderLayout.CENTER);
			playDialog.setTitle("Illegal DVD length");
			playDialog.setSize(500,500);
			playDialog.setVisible(true);
		}
	}

}

