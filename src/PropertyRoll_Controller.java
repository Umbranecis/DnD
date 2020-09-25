import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.*;

public class PropertyRoll_Controller {
        @FXML
        VBox box;
        @FXML
        Button reroll;
        @FXML
        Button cancel;

        @FXML
        void reroll(){
            for (int i = 6; i>0; i--){
                box.getChildren().add(connectedHBox(PropertyRoll.property()));
            }
        }

        @FXML
        void cancel(){
            try {
                Main.setMainStage(Visuals.start());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public HBox connectedHBox(int[] input){
            HBox box = new HBox();
            TextField array = new TextField();
            TextField value = new TextField();
            array.setText(Arrays.toString(input));
            value.setText("" + PropertyRoll.value(input));
            array.setEditable(false);
            value.setEditable(false);
            return box;
        }



}




