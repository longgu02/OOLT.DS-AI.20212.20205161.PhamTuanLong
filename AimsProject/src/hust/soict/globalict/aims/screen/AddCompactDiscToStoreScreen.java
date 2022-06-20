package hust.soict.globalict.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
//import hust.soict.globalict.aims.screen.AddBookToStoreScreen.ButtonListener;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	JTextField artistInput;
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		ButtonListener btnListener = new ButtonListener();
		artistInput = new JTextField(10);
		JLabel artistLabel = new JLabel("Artist: ");
		Panel.add(artistLabel);
		Panel.add(artistInput);
		JButton submit = new JButton("ADD CD");
		Panel.add(submit);
		submit.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Media newBook = new CompactDisc(titleInput.getText(), categoryInput.getText(), artistInput.getText(), Float.parseFloat(costInput.getText()));
			store.addMedia(newBook);
			titleInput.setText("");
			categoryInput.setText("");
			costInput.setText("");
			artistInput.setText("");
		}
	}	
}
