import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.HashMap;


public class addEncounterToFile_Controller {
    @FXML
    TextField name;
    @FXML
    TextField amt;
    @FXML
    Button add;
    @FXML
    TextField filename;
    @FXML
    Button submit;

    @FXML
    HashMap<String, Integer> returnList = new HashMap<>();


    public void add(){
        try {
            returnList.put(name.getText(), Integer.parseInt(amt.getText()));
            name.clear();
            amt.clear();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void submit() {
        FileManager.addEncounter(returnList, filename.getText());
        try {
            Main.setMainStage(Visuals.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
