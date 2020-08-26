import Errors.NoValidDice;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;

public abstract class Visuals {


    public static Scene start() {
        sizedButton diceSimulator = new programButton("Start the Dice Simulator", "diceSimulator");
        sizedButton properties = new programButton("roll properties for a new Champion", "properties");
        sizedButton initiativeList = new programButton("create an initiative List", "initiativeList");
        HBox pane = new HBox();
        pane.getChildren().addAll(properties, diceSimulator, initiativeList);
        Scene s = new Scene(pane);
        return s;


    }

    public static Scene diceSimulator() {

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
            dice.setText("");

        });

        d20.setOnAction(event -> {
            result.setText("" + DiceSimulator.d20());
        });

        adv.setOnAction(event -> {
            result.setText("" + DiceSimulator.advantage());
        });

        dadv.setOnAction(event -> {
            result.setText("" + DiceSimulator.disadvantage());
        });


        HBox hbox = new HBox(dice, roll);
        VBox buttons = new VBox(hbox, d20, adv, dadv, new CancelButton());
        HBox pane = new HBox(buttons, result);

        Scene s = new Scene(pane);

        s.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                roll.fire();
            }
        });

        return s;
    }


    public static Scene propertyRoll() {
        Button roll = new sizedButton("roll");
        VBox v = new VBox();


        roll.setOnAction(event -> Main.setMainStage(propertyRoll()));

        for (int i = 6; i > 0; i--) {
            v.getChildren().add(connectedPropertyFields());
        }
        v.getChildren().add(roll);


        v.getChildren().add(new CancelButton());
        Scene s = new Scene(v);

        s.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                roll.fire();
            }
        });

        return s;
    }

    private static HBox connectedPropertyFields() {
        HBox x = new HBox();
        int[] diceArray = PropertyRoll.property();
        InitiativeTableText dice = new InitiativeTableText();
        InitiativeTableText result = new InitiativeTableText();
        dice.setText(Arrays.toString(diceArray));
        result.setText(Integer.toString(PropertyRoll.value(diceArray)));
        x.getChildren().addAll(dice, result);
        return x;
    }


    public static HBox addToList(InitiativeList l) {
        VBox v = new VBox();
        HBox h = new HBox();
        InitiativeList i = l;
        Button add = new Button("add");
        TextField name = new TextField();
        TextField playerName = new TextField();
        TextField initiative = new TextField();
        Button createList = new sizedButton("create List");
        Text error = new Text("");

        name.setPromptText("Character name");
        playerName.setPromptText("player name");
        initiative.setPromptText("initiative");




        add.setOnAction(event -> {
            try {
                clearAndAdd(name, playerName, initiative, l);
                error.setText("");
                Main.setMainStage(createlist(i));
            } catch (noIntegerAsInitiative n) {
                error.setText("please insert a valid number");
            }
        });

        createList.setOnAction(event -> Main.setMainStage(createlist(i)));

        h.getChildren().addAll(name, playerName, initiative, add, error);

        h.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){add.fire();}
        });

        return h;
    }

    public static void clearAndAdd(TextField name, TextField playerName, TextField initiative, InitiativeList i) throws noIntegerAsInitiative {
        try {
            i.addParticipant(name.getText(), playerName.getText(), Integer.parseInt(initiative.getText()));
        } catch (NumberFormatException e) {
            throw new noIntegerAsInitiative();
        }

        name.clear();
        playerName.clear();
        initiative.clear();


    }

    public static Scene createlist(InitiativeList l) {
        VBox v = new VBox();
        Button b = new CancelButton();


        b.setText("return to main page");
        HBox h = new HBox();
        InitiativeTableText n = new InitiativeTableText("characters name");
        InitiativeTableText pn = new InitiativeTableText("players name");
        InitiativeTableText i = new InitiativeTableText("initiative");
        h.getChildren().addAll(n, pn, i);
        v.getChildren().add(h);


        for (InitiativeList.Participiant p : l.getFinishedList()) {
            h = new HBox();
            n = new InitiativeTableText(p.getName());
            pn = new InitiativeTableText(p.getPlayerName());
            i = new InitiativeTableText("" + p.getInitiative());
            Button remove = new Button("remove from list");
            remove.setOnAction(event -> {
                l.kill(p);
                Main.setMainStage(createlist(l));
            });


            h.getChildren().addAll(n, pn, i, remove);
            v.getChildren().add(h);
        }



        v.getChildren().addAll(addToList(l), b);

        Scene s = new Scene(v);
        return s;
    }


    public static class InitiativeTableText extends TextField {
        public InitiativeTableText(String s) {
            this.setText(s);
            this.setEditable(false);
            this.setPrefSize(150, 40);
        }

        public InitiativeTableText() {
            this.setPrefSize(150, 40);
            this.setEditable(false);
        }

    }


    public static class CancelButton extends sizedButton {
        public CancelButton() {
            setOnAction(event -> Main.setMainStage(start()));
            setText("cancel");
        }

    }

    static class noIntegerAsInitiative extends Error {
    }

    static class sizedButton extends Button {
        public sizedButton(String s) {
            setText(s);
            setPrefSize(400, 100);

        }

        public sizedButton() {
            setPrefSize(400, 100);
        }

        ;


    }

    static class programButton extends sizedButton {
        public programButton(String text, String task) {
            this.setOnAction(actionEvent -> Program.getByName(task).runProgram());
            this.setText(text);
        }
    }
}
