package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
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
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((Playable)media).play();
					JDialog playDialog = new JDialog();
					if(media instanceof DigitalVideoDisc) {
						JLabel playLabel = new JLabel("Playing DVD: " + media.getTitle() + " - " + "DVD length: " + ((DigitalVideoDisc)media).getLength());
						playDialog.add(playLabel, BorderLayout.CENTER);
						playDialog.setTitle("Playing DVD");
					}else if(media instanceof CompactDisc) {
						JLabel playLabel = new JLabel("Playing CD: " + media.getTitle());
						playDialog.add(playLabel, BorderLayout.CENTER);
						playDialog.setTitle("Playing CD: " + media.getTitle());
					}
					
					playDialog.setSize(500,500);
					playDialog.setVisible(true);
				}
			});
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
