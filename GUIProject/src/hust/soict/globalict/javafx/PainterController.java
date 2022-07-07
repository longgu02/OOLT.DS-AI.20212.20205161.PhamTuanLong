package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class PainterController {
	
    @FXML
    private ToggleGroup identical;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {	
    	System.out.println();
    	Circle newCircle = new Circle(event.getX(), event.getY(), 
    			4, (((RadioButton)identical.getSelectedToggle()).getText().equals("Pen")) 
    			? Color.BLACK : Color.WHITE);
    	drawingAreaPane.getChildren().add(newCircle);
    	
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}
