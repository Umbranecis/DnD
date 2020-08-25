import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileChooserClass extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        getFile();

    }

    public static File getFile(){
        return new FileChooser().showOpenDialog(Main.getMainStage());
    }
}

