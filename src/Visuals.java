import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import Buttons.*;

import java.io.IOException;
import java.util.*;


public abstract class Visuals {


    public static Scene start() throws IOException {
        return new Scene(FXMLLoader.load(Main.class.getResource("xmlDocuments/Start.fxml")));
    }

    public static Scene diceSimulator() throws IOException {
            return new Scene( FXMLLoader.load(Main.class.getResource("xmlDocuments/DiceSimulator.fxml")));
    }


    public static Scene propertyRoll() throws IOException {
        return new Scene(FXMLLoader.load(Main.class.getResource("xmlDocuments/PropertyRoll.fxml")));
    }

    public static HBox addToList(InitiativeList l) {
        HBox h = new HBox();
        Button add = new Button("add");
        TextField name = new SizedInputField("Character name");
        TextField playerName = new SizedInputField("player name");
        TextField initiative = new SizedInputField("initiative");
        Text error = new Text("");


        add.setOnAction(event -> {
            try {
                clearAndAdd(name, playerName, initiative, l);
                error.setText("");
                Main.setMainStage(visibleList(l));
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
            try {
                Main.setMainStage(addGroupToFile(l));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        createNewEncounter.setOnAction(event -> {
            try {
                Main.setMainStage(addEncounterToFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        addGroup.setOnAction(event -> {
            try{
            Main.setMainStage(addGroupToList(l, Grouptype.GROUP));}
            catch(NullPointerException ignored){}
        });

        addEncounter.setOnAction(event -> {
            try {
                Main.setMainStage(addGroupToList(l, Grouptype.ENCOUNTER));
            } catch (NullPointerException ignored) {
            }
        });


        HBox createButtons = new HBox(createNewGroup, createNewEncounter);
        HBox addButtons = new HBox(addGroup, addEncounter);

        v.getChildren().addAll(addToList(l), createButtons, addButtons, cancelButton);

        return new Scene(v);
    }

    public static Scene addGroupToFile(InitiativeList input) throws IOException {
        return new Scene(FXMLLoader.load(Main.class.getResource("xmlDocuments/addGroupToFile.fxml")));
    }

    public static Scene addEncounterToFile() throws IOException {
        return new Scene(FXMLLoader.load(Main.class.getResource("xmlDocuments/addEncounterToFile.fxml")));
    }

    public static Scene addGroupToList(InitiativeList l, Grouptype type){
        Collection<Fighter> input;
        if(type.equals(Grouptype.GROUP)){input = FileManager.getGroup();}
        else if(type.equals(Grouptype.ENCOUNTER)){ input = FileManager.getEncounter();}
        else{input = new HashSet<>() {
        };}

        VBox pane = new VBox();
        Button submit = new SizedButton();
        Collection<Button> addButtons = new HashSet<>();
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
            if(type.equals(Grouptype.ENCOUNTER)){
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

        public SizedInputField(String promttext) {
            setPrefSize(150, 40);
            setPromptText(promttext);
        }

    }


    public static class CancelButton extends SizedButton {
        public CancelButton() {
            setOnAction(event -> {
                try {
                    Main.setMainStage(start());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            setText("cancel");
        }

    }

    static class NoIntegerAsInitiative extends Error {
    }

}
