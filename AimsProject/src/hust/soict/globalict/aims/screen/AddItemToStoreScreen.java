package hust.soict.globalict.aims.screen;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.store.Store;

public class AddItemToStoreScreen {
	protected Store store;
	protected JPanel Panel;
	protected JTextField titleInput;
	protected JTextField categoryInput;
	protected JTextField costInput;
	
	public JPanel getPanel() {
		return Panel;
	}

	public AddItemToStoreScreen(Store store){
		this.store = store;
		Panel = new JPanel();
		Panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JLabel titleLabel = new JLabel("Title: ");
		JLabel categoryLabel = new JLabel("Category: ");
		JLabel costLabel = new JLabel("Cost: ");
		titleInput = new JTextField(10);
		Panel.add(Box.createHorizontalStrut(10));
		categoryInput = new JTextField(10);
		costInput = new JTextField(10);
		
		Panel.add(titleLabel);
		Panel.add(titleInput);
		Panel.add(categoryLabel);
		Panel.add(categoryInput);
		Panel.add(costLabel);
		Panel.add(costInput);

	}
}
