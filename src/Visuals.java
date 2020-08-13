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

import javax.swing.*;

public abstract class Visuals {




    public static Scene start(){
        sizedButton diceSimulator = new programButton("Start the Dice Simulator", "diceSimulator");
        sizedButton properties = new programButton( "roll properties for a new Champion", "properties");
        sizedButton initiativeList = new programButton("create an initiatrive List", "initiativeList");
        HBox pane = new HBox();
        pane.getChildren().addAll(properties, diceSimulator, initiativeList);
        Scene s = new Scene(pane);
        return s;



    }

    public static Scene diceSimulator(){

        Button roll = new sizedButton("roll");
        Button d20 = new sizedButton("normal d20");
        Button adv = new sizedButton("advantage d20");
        Button dadv = new sizedButton("disadvantaged d20");

        TextField dice = new TextField();
        InitiativeTableText result = new InitiativeTableText();



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



        HBox hbox = new HBox(dice, roll);
        VBox buttons = new VBox(hbox, d20, adv, dadv, new CancelButton());
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




        v.getChildren().add(new CancelButton());
        Scene s = new Scene(v);
        return s;
    }

    private static HBox connectedPropertyFields(){
        HBox x = new HBox();
        int[] diceArray = PropertyRoll.property();
        InitiativeTableText dice = new InitiativeTableText();
        InitiativeTableText result = new InitiativeTableText();
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

    public static Scene addToList (InitiativeList l){
        InitiativeList i = l;
        Button add = new Button("add");
        TextField name = new TextField();
        TextField playerName = new TextField();
        TextField initiative = new TextField();
        Button createList = new sizedButton("create List");

        name.setPromptText("Character name");
        playerName.setPromptText("player name");
        initiative.setPromptText("initiative");

        add.setOnAction(event -> clearAndAdd(name, playerName, initiative, i));
        createList.setOnAction(event -> Main.setMainStage(createList(i)));
        HBox h = new HBox();
        h.getChildren().addAll(name, playerName, initiative, add);
        VBox v = new VBox();
        v.getChildren().addAll(h, createList, new CancelButton());
        Scene s = new Scene(v);
        return s;
    }

    public static Scene addToList(){
       return  addToList(new InitiativeList());
    }

    public static void clearAndAdd(TextField name, TextField playerName, TextField initiative, InitiativeList i){
        i.addParticipant(name.getText(), playerName.getText(), Integer.parseInt(initiative.getText()));
        name.clear();
        playerName.clear();
        initiative.clear();


    }

    public static Scene createList(InitiativeList l){
        VBox v = new VBox();
        Button add = new sizedButton("add new Fighter");
        add.setOnAction(event -> {Main.setMainStage(addToList(l));});

        if(true) {
            HBox h = new HBox();
            InitiativeTableText n = new InitiativeTableText("characters name");
            InitiativeTableText pn = new InitiativeTableText("players name");
            InitiativeTableText i = new InitiativeTableText("initiative");
            h.getChildren().addAll(n, pn, i);
            v.getChildren().add(h);
        }

        for(InitiativeList.Participiant p : l.getFinishedList()){
            HBox h = new HBox();
            InitiativeTableText n = new InitiativeTableText(p.getName());
            InitiativeTableText pn = new InitiativeTableText(p.getPlayerName());
            InitiativeTableText i = new InitiativeTableText("" + p.getInitiative());
            h.getChildren().addAll(n, pn, i);
            v.getChildren().add(h);
        }
        Button b = new CancelButton();
        b.setText("return to main page");
        v.getChildren().addAll(add, b);

        Scene s = new Scene(v);
        return s;
    }

    public static class InitiativeTableText extends TextField{
        public InitiativeTableText(String s){
            this.setText(s);
            this.setEditable(false);
            this.setPrefSize(150, 40);
        }

        public InitiativeTableText(){
            this.setPrefSize(150,   40);
            this.setEditable(false);
        }

    }

    public static class CancelButton extends sizedButton{
        public CancelButton(){
            setOnAction(event -> Main.setMainStage(start()));
            setText("cancel");
        }

    }
}
