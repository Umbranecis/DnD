import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class addGroupToFile_Controller {
    @FXML
    TextField name;
    @FXML
    TextField playerName;
    @FXML
    Button add;
    @FXML
    TextField filename;
    @FXML
    Button submit;

    @FXML
    Collection<Fighter> returnList= new HashSet<>();


    public void add(){
        try {
            returnList.add(new Fighter(name.getText(), playerName.getText()));
            name.clear();
            playerName.clear();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void submit() {
        FileManager.addGroup(returnList, filename.getText());
        try {
            Main.setMainStage(Visuals.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
