package hust.soict.globalict.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	private JTextField contentInput;
	private JTextField authorInput;
	
	public AddBookToStoreScreen(Store store) {
		super(store);
		ButtonListener btnListener = new ButtonListener();
		contentInput = new JTextField(10);
		authorInput = new JTextField(10);
		JLabel contentLabel = new JLabel("Content: ");
		JLabel authorLabel = new JLabel("Authors(sep by ','): ");
		Panel.add(contentLabel);
		Panel.add(contentInput);
		Panel.add(authorLabel);
		Panel.add(authorInput);
		JButton submit = new JButton("ADD BOOK");
		Panel.add(submit);
		submit.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Media newBook = null;
			try {
				newBook = new Book(titleInput.getText(), categoryInput.getText(), Float.parseFloat(costInput.getText()));
			} catch (NumberFormatException | MediaValidationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			((Book)newBook).updateContent(contentInput.getText()); 
			String[] author = authorInput.getText().split(",");
			for(String a: author) {
				((Book)newBook).addAuthor(a);	        	
			}
			try {
				store.addMedia(newBook);
			} catch (MediaValidationException e1) {
				// TODO Auto-generated catch block
				System.err.println(e1.getMessage());
			}
			titleInput.setText("");
			categoryInput.setText("");
			costInput.setText("");
			contentInput.setText("");
			authorInput.setText("");
		}
	}	
}
