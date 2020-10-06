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
    TextField array1;
    @FXML
    TextField array2;
    @FXML
    TextField array3;
    @FXML
    TextField array4;
    @FXML
    TextField array5;
    @FXML
    TextField array6;

    @FXML
    TextField result1;
    @FXML
    TextField result2;
    @FXML
    TextField result3;
    @FXML
    TextField result4;
    @FXML
    TextField result5;
    @FXML
    TextField result6;

    @FXML
    TextField result;


    @FXML
    void reroll() {
        Collection<int[]> values = PropertyRoll.properties();
    }

    @FXML
    void cancel() {
        try {
            Main.setMainStage(Visuals.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void resultToString(){
        
    }


}




