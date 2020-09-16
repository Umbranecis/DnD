import Errors.NoValidDice;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DiceSimulator_Controller {
    @FXML
    TextField die;

    @FXML
    TextField result;

    private void roll(String s){
        try {
            result.setText("" + DiceSimulator.roll(s));
        } catch (NoValidDice noValidDice) {
            die.setPromptText("no valid die");
        }
    }

    public void rollCustom(){
        roll(die.getText());
    }

    public void rollNormal(){
        result.setText("" +  DiceSimulator.d20());
    }

    public void rollAdvantage(){
        result.setText("" +  DiceSimulator.advantage());
    }

    public void rollDisadvantage(){
        result.setText("" +  DiceSimulator.disadvantage());
    }

    public void cancel(){
        try {
            Main.setMainStage(Visuals.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
