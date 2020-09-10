import Errors.NoValidDice;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.*;

public abstract class Visuals {


    public static Scene start() {
        SizedButton diceSimulator = new ProgramButton("Start the Dice Simulator", "diceSimulator");
        SizedButton properties = new ProgramButton("roll properties for a new Champion", "properties");
        SizedButton initiativeList = new ProgramButton("create an initiative List", "initiativeList");
        HBox pane = new HBox();
        pane.getChildren().addAll(properties, diceSimulator, initiativeList);
        Scene s = new Scene(pane);
        return s;


    }

    public static Scene diceSimulator() {

        Button roll = new SizedButton("roll");
        Button d20 = new SizedButton("normal d20");
        Button adv = new SizedButton("advantage d20");
        Button dadv = new SizedButton("disadvantaged d20");

        TextField dice = new TextField();
        SizedTextField result = new SizedTextField();

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
            if (event.getCode().equals(KeyCode.ENTER)) {
                roll.fire();
            }
        });

        return s;
    }


    public static Scene propertyRoll() {
        Button roll = new SizedButton("roll");
        VBox v = new VBox();


        roll.setOnAction(event -> Main.setMainStage(propertyRoll()));

        for (int i = 6; i > 0; i--) {
            v.getChildren().add(connectedPropertyFields());
        }
        v.getChildren().add(roll);


        v.getChildren().add(new CancelButton());
        Scene s = new Scene(v);

        s.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                roll.fire();
            }
        });

        return s;
    }

    private static HBox connectedPropertyFields() {
        HBox x = new HBox();
        int[] diceArray = PropertyRoll.property();
        SizedTextField dice = new SizedTextField();
        SizedTextField result = new SizedTextField();
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
        TextField name = new SizedInputField("Character name");
        TextField playerName = new SizedInputField("player name");
        TextField initiative = new SizedInputField("initiative");
        Text error = new Text("");


        add.setOnAction(event -> {
            try {
                clearAndAdd(name, playerName, initiative, l);
                error.setText("");
                Main.setMainStage(visibleList(i));
            } catch (NoIntegerAsInitiative n) {
                error.setText("please insert a valid number");
            }
        });


        h.getChildren().addAll(name, playerName, initiative, add, error);

        h.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                add.fire();
            }
        });

        return h;
    }

    public static void clearAndAdd(TextField name, TextField playerName, TextField initiative, InitiativeList i) throws NoIntegerAsInitiative {
        try {
            i.addParticipant(name.getText(), playerName.getText(), Integer.parseInt(initiative.getText()));
        } catch (NumberFormatException e) {
            throw new NoIntegerAsInitiative();
        }

        name.clear();
        playerName.clear();
        initiative.clear();


    }

    public static Scene visibleList(InitiativeList l) {
        VBox v = new VBox();
        Button cancelButton = new CancelButton();


        cancelButton.setText("return to main page");
        HBox h = new HBox();
        SizedTextField n = new SizedTextField("characters name");
        SizedTextField pn = new SizedTextField("players name");
        SizedTextField i = new SizedTextField("initiative");
        SizedButton createNewGroup = new SizedButton("create new Group");
        SizedButton createNewEncounter = new SizedButton("create new Encounter");
        SizedButton addGroup = new SizedButton("add Group to list");
        SizedButton addEncounter = new SizedButton("add Encounter to list");

        h.getChildren().addAll(n, pn, i);
        v.getChildren().add(h);


        for (InitiativeList.Participiant p : l.getFinishedList()) {
            h = new HBox();
            n = new SizedTextField(p.getName());
            pn = new SizedTextField(p.getPlayerName());
            i = new SizedTextField("" + p.getInitiative());
            Button remove = new Button("remove from list");
            remove.setOnAction(event -> {
                l.kill(p);
                Main.setMainStage(visibleList(l));
            });


            h.getChildren().addAll(n, pn, i, remove);
            v.getChildren().add(h);
        }

        createNewGroup.setOnAction(event -> {
            Main.setMainStage(addGroupToFile(l));
        });

        createNewEncounter.setOnAction(event -> {
            Main.setMainStage(addEncounterToFile(l));
        });

        addGroup.setOnAction(event -> {
            Main.setMainStage(addToList(l, FileManager.GROUP));
        });

        addEncounter.setOnAction(event -> {
            Main.setMainStage(addToList(l, FileManager.ENCOUNTER));
        });


        HBox createButtons = new HBox(createNewGroup, createNewEncounter);
        HBox addButtons = new HBox(addGroup, addEncounter);

        v.getChildren().addAll(addToList(l), createButtons, addButtons, cancelButton);

        Scene s = new Scene(v);
        return s;
    }

    public static Scene addGroupToFile(InitiativeList input) {
        ArrayList<Fighter> returnList = new ArrayList<Fighter>();
        SizedInputField fileName = new SizedInputField("filename");
        SizedInputField name = new SizedInputField("character name");
        SizedInputField playerName = new SizedInputField("player name");
        SizedButton add = new SizedButton("add");
        SizedButton submit = new SizedButton("submit");

        VBox vbox = new VBox();
        HBox names = new HBox();
        HBox createFile = new HBox();

        names.getChildren().addAll(name, playerName, add);
        createFile.getChildren().addAll(fileName, submit);
        vbox.getChildren().addAll(names, createFile);

        add.setOnAction(event -> {
            returnList.add(new Fighter(name.getText(), playerName.getText()));
            name.clear();
            playerName.clear();
        });
        submit.setOnAction(event -> {
            FileManager.addGroup(returnList, fileName.getText());
            Main.setMainStage(visibleList(input));
        });


        return new Scene(vbox);
    }

    public static Scene addEncounterToFile(InitiativeList input) {
        HashMap<String, Integer> returnList = new HashMap<String, Integer>();
        SizedInputField fileName = new SizedInputField("filename");
        SizedInputField name = new SizedInputField("monsters name");
        SizedInputField amt = new SizedInputField("amount");
        SizedButton add = new SizedButton("add");
        SizedButton submit = new SizedButton("submit");

        VBox vbox = new VBox();
        HBox names = new HBox();
        HBox createFile = new HBox();
        names.getChildren().addAll(name, amt, add);
        createFile.getChildren().addAll(fileName, submit);
        vbox.getChildren().addAll(names, createFile);

        add.setOnAction(event -> {
            try {
                returnList.put(name.getText(), Integer.parseInt(amt.getText()));
                name.clear();
                amt.clear();
            } catch (Exception ex) {
            }

        });

        submit.setOnAction(event -> {
            FileManager.addEncounter(returnList, fileName.getText());
            Main.setMainStage(visibleList(input));
        });

        return new Scene(vbox);
    }

    public static Scene addToList(InitiativeList l, String type){
        Collection<Fighter> input;
        if(type == FileManager.GROUP){input = FileManager.getGroup();}
        else if(type == FileManager.ENCOUNTER){ input = FileManager.getEncounter();}
        else{input = new HashSet<Fighter>() {
        };}

        VBox pane = new VBox();
        Button submit = new SizedButton();
        Collection<Button> addButtons = new HashSet<Button>();
        Collection<Button> failedButtons = new HashSet<>();


        for (Fighter f : input){
            HBox hBox = new HBox();
            SizedTextField name = new SizedTextField(f.name);
            SizedTextField playername = new SizedTextField(f.playerName);
            SizedInputField initiative = new SizedInputField("initiative");
            Button add = new Button();
            Text error = new Text("");
            addButtons.add(add);

            hBox.getChildren().addAll(name,playername,initiative, error);
            if(type == FileManager.ENCOUNTER){
                playername.setText("DM");
                hBox.getChildren().remove(playername);

            }
            pane.getChildren().add(hBox);
            add.setOnAction(event -> {
                try {
                    clearAndAdd(name, playername, initiative, l);
                    pane.getChildren().remove(hBox);
                }
                catch (NoIntegerAsInitiative noIntegerAsInitiative){
                        failedButtons.add(add);
                        error.setText("please insert a valid number");
                    }

                });
        }

        submit.setOnAction(event -> {
                for (Button button: addButtons){

                    button.fire();

            }
                    if(failedButtons.isEmpty()){
                    Main.setMainStage(visibleList(l));}
                    else{addButtons.clear();
                    addButtons.addAll(failedButtons);
                    failedButtons.clear();
                    }


        });

        pane.getChildren().add(submit);

        return new Scene(pane);
    }


    public static Scene addEncounterToList(Collection<Fighter> input, InitiativeList l){
        VBox pane = new VBox();
        Button submit = new SizedButton();
        Collection<Button> addButtons = new HashSet<Button>();
        Collection<Button> failedButtons = new HashSet<>();

        for(Fighter f : input){

        }

        return null;
        }


    public static class SizedTextField extends TextField {
        public SizedTextField(String s) {
            this.setText(s);
            this.setEditable(false);
            this.setPrefSize(150, 40);
        }

        public SizedTextField() {
            this.setPrefSize(150, 40);
            this.setEditable(false);
        }

    }

    public static class SizedInputField extends TextField {
        public SizedInputField() {
            setPrefSize(150, 40);
        }

        public SizedInputField(String promttext) {
            setPrefSize(150, 40);
            setPromptText(promttext);
        }

    }


    public static class CancelButton extends SizedButton {
        public CancelButton() {
            setOnAction(event -> Main.setMainStage(start()));
            setText("cancel");
        }

    }

    static class NoIntegerAsInitiative extends Error {
    }

    static class SizedButton extends Button {
        public SizedButton(String s) {
            setText(s);
            setPrefSize(400, 100);

        }

        public SizedButton() {
            setPrefSize(400, 100);
        }

        ;


    }

    static class ProgramButton extends SizedButton {
        public ProgramButton(String text, String task) {
            this.setOnAction(actionEvent -> Program.getByName(task).runProgram());
            this.setText(text);
        }
    }
}
