package hust.soict.globalict.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	JTextField directorInput;
	JTextField lengthInput;
	
	public AddDigitalVideoDiscToStoreScreen(Store store){
		super(store);
		ButtonListener btnListener = new ButtonListener();
		directorInput = new JTextField(10);
		lengthInput = new JTextField(10);
		JLabel directorLabel = new JLabel("Director: ");
		JLabel lengthLabel = new JLabel("Length: ");
		Panel.add(directorLabel);
		Panel.add(directorInput);
		Panel.add(lengthLabel);
		Panel.add(lengthInput);
		JButton submit = new JButton("ADD DVD");
		Panel.add(submit);
		submit.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Media newDVD = null;
			try {
				newDVD = new DigitalVideoDisc(titleInput.getText(), categoryInput.getText(), directorInput.getText(),Integer.parseInt(lengthInput.getText()), Float.parseFloat(costInput.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MediaValidationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				store.addMedia(newDVD);
			} catch (MediaValidationException e1) {
				// TODO Auto-generated catch block
				System.err.println(e1.getMessage());
			}
			titleInput.setText("");
			categoryInput.setText("");
			directorInput.setText("");
			lengthInput.setText("");
			costInput.setText("");
		}
	}

}
