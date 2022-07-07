package hust.soict.globalict.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CartController {
	private Cart cart;
	private Store store = new Store();
	
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;


    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    public CartController(Cart cart) {
    	this.cart = cart;
    }
    public CartController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }

    @FXML
    public void initialize() {
 
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getItemsOrdered() != null){
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	costLabel.setText(cart.totalCost() + " $");
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
			});    
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
			});    
    	}

    public void updateButtonBar(Media media) {
		if(media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			}else {
				btnPlay.setVisible(false);
			}
		}
		
	}

	@FXML
    void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Playing Media");
		alert.setHeaderText(null);
		alert.setContentText("Playing " + media.getTitle());

		alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Media luckyItem = cart.getALuckyItem();
		Alert luckyItemAlert = new Alert(AlertType.INFORMATION);
		luckyItemAlert.setTitle("Lucky Item");
		luckyItemAlert.setHeaderText(null);
		try {
			luckyItemAlert.setContentText("Congrats, you get " + luckyItem.getTitle() + " for free!");			
		}catch(NullPointerException e) {
			luckyItemAlert.setContentText("You need atleast 5 products in your cart to get 1 free lucky item");	
		}

		luckyItemAlert.showAndWait();
		Alert billAlert = new Alert(AlertType.INFORMATION);
		billAlert.setTitle("Bill Order");
		billAlert.setHeaderText(null);
		String bill = "";
		for(Media media: cart.getItemsOrdered()) {
			if(media == cart.getFreeItem()) {
				bill += media.toString() + " (FREE)\r\n";
			}
			bill += media.toString() + "\r\n";
		}
		bill += "\r\n" + "Total cost " + cart.totalCost() + "$";
		billAlert.setContentText(bill);

		billAlert.showAndWait();
        cart.printCart();
        cart = new Cart();
        tblMedia.setItems(null);
        costLabel.setText("0 $");
    }
    
    public void showFilteredMedia(String value) {
    	ObservableList<Media> FilteredList = FXCollections.observableArrayList();

    	if(((RadioButton)filterCategory.getSelectedToggle()).getText().equals("By ID")){
            try{
            	int id = Integer.parseInt(value);
            	FilteredList.add(cart.searchItemById(id)) ;
            }catch (NumberFormatException e){
            	FilteredList = cart.getItemsOrdered();
            }
    	}else if(((RadioButton)filterCategory.getSelectedToggle()).getText().equals("By Title")) {
    		FilteredList = cart.searchItemByTitle(value);
    		if(value == null || value == "") {
    			FilteredList = cart.getItemsOrdered();
    		}
    	}
    	tblMedia.setItems(FilteredList);
    }
    

}
