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

    ArrayList<TextField> results = new ArrayList<>();
    ArrayList<TextField> arrays = new ArrayList<>();

    @FXML
     void reroll() {
        results.add(result1);
        results.add(result2);
        results.add(result3);
        results.add(result4);
        results.add(result5);
        results.add(result6);
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        arrays.add(array4);
        arrays.add(array5);
        arrays.add(array6);

        Collection<int[]> values = PropertyRoll.properties();
        int i = 0;
        int endResult = 0;
        for(int[] value : values){
            arrays.get(i).setText(resultToString(value));
            results.get(i).setText("" + PropertyRoll.value(value));
            endResult += PropertyRoll.value(value);
            i++;
        }

        result.setText("" + endResult);



    }

    @FXML
    void cancel() {
        try {
            Main.setMainStage(Visuals.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String resultToString(int[] rolls){
        String s = "";
        for (int i : rolls){
            s += "" + i + ",";
        }

        return s.substring(0, s.length() - 1);
    }


    


}




