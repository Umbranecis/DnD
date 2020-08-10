import Errors.NoValidDice;
import com.sun.javafx.scene.control.InputField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public abstract class Visuals {

    public static Scene start(){
        sizedButton diceSimulator = new programButton("Start the Dice Simulator", "diceSimulator");
        sizedButton properties = new programButton( "roll properties for a new Champion", "properties");
        HBox pane = new HBox();
        pane.getChildren().addAll(properties, diceSimulator);
        Scene s = new Scene(pane);
        return s;



    }

    public static Scene diceSimulator(){

        Button roll = new sizedButton("roll");
        Button d20 = new sizedButton("normal d20");
        Button adv = new sizedButton("advantage d20");
        Button dadv = new sizedButton("disadvantaged d20");
        Button cancel = new sizedButton("cancel");
        TextField dice = new TextField();
        Text result = new Text();



        dice.setPromptText("insert your dice. example: 2d4+1");
        roll.setOnAction(event -> {
            try {
            result.setText("" + DiceSimulator.roll(dice.getText()));
        } catch (NoValidDice noValidDice) {
            result.setText("please insert a valid dice");
        }
        });

        d20.setOnAction(event -> {
            result.setText("" + DiceSimulator.d20());
        });

        adv.setOnAction(event -> {
            result.setText("" + DiceSimulator.advantage());
        });

        dadv.setOnAction(event -> {result.setText("" + DiceSimulator.disadvantage());
        });

        cancel.setOnAction(event -> {Main.setMainStage(start());});

        HBox hbox = new HBox(dice, roll);
        VBox buttons = new VBox(hbox, d20, adv, dadv, cancel);
        HBox pane = new HBox(buttons, result);

        Scene s = new Scene(pane);

        return s;
    }

    public static Scene propertyRoll(){
        Button roll = new sizedButton("roll");
        VBox v = new VBox();

        roll.setOnAction(event -> Main.setMainStage(propertyRoll()));

        for (int i = 6; i>0; i--){
            v.getChildren().add(connectedPropertyFields());
        }
        v.getChildren().add(roll);
        Scene s = new Scene(v);
        return s;
    }

    private static HBox connectedPropertyFields(){
        HBox x = new HBox();
        int[] diceArray = PropertyRoll.property();
        Text dice = new Text();
        Text result = new Text();
        dice.setText(Arrays.toString(diceArray));
        result.setText(Integer.toString(PropertyRoll.value(diceArray)));
        x.getChildren().addAll(dice, result);
        return x;
    }




    static class sizedButton extends Button{
        public sizedButton(String s){
            setText(s);
            setPrefSize(400, 100);

        }
        public sizedButton(){
            setPrefSize(400, 100);
        };


    }

    static class programButton extends sizedButton{
        public programButton(String text, String task){
            this.setOnAction(actionEvent -> Program.getByName(task).runProgram());
            this.setText(text);
        }
    }
}
