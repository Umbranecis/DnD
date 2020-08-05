import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Visuals {

    public static Stage start(){
        Stage s = new Stage();
        sizedButton diceSimulator = new programButton("Start the Dice Simulator", "diceSimulator");
        sizedButton properties = new programButton( "roll properties for a new Champion", "properties");
        HBox pane = new HBox();
        pane.getChildren().addAll(properties, diceSimulator);
        Scene scene = new Scene(pane);
        s.setScene(scene);
        return s;



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
