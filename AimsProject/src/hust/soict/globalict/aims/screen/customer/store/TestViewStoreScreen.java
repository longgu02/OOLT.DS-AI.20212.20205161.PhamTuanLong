package hust.soict.globalict.aims.screen.customer.store;

import hust.soict.globalict.aims.exception.MediaValidationException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) throws MediaValidationException {
		store = new Store();
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
		Media media10 = new Book("Book4", "Science Fiction", 24.95f);
		store.addMedia(media10);
		launch(args);
	}
}

