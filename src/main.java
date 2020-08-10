import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.dom4j.DocumentException;

import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application {


    private static Stage mainStage = new Stage();

    public void start(Stage stage) throws Exception {
        mainStage.setScene(Visuals.start());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

   public static void setMainStage(Scene s) {
        mainStage.setScene(s);

    }
}





