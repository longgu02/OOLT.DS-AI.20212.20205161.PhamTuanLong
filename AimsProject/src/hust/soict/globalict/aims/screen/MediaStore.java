package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout((new BoxLayout(this, BoxLayout.Y_AXIS)));
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
