package hust.soict.globalict.aims.screen.customer.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application{
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController cartController = new CartController(cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		cart = new Cart();
		Media media1 = new DigitalVideoDisc("This is the first test DVD (2022)", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(media1);
		Media media2 = new DigitalVideoDisc("DVD2", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(media2);
		Media media3 = new CompactDisc("CD1", "Science Fiction", "George Lucas", 24.95f);
		cart.addMedia(media3);
		Media media4 = new DigitalVideoDisc("DVD3", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(media4);
		Media media5 = new Book("Book1", "Science Fiction", 24.95f);
		cart.addMedia(media5);
		Media media6 = new DigitalVideoDisc("DVD4", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(media6);
		Media media7 = new Book("Book2", "Science Fiction", 24.95f);
		cart.addMedia(media7);
		Media media8 = new Book("Book3", "Science Fiction", 24.95f);
		cart.addMedia(media8);
		Media media9 = new Book("Book4", "Science Fiction", 24.95f);
		cart.addMedia(media9);
		launch(args);
	}
}
