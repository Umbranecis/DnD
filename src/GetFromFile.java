import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class GetFromFile extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {}

    public static Collection<Fighter> getGroup(File f){
        ArrayList<Fighter> returnList = new ArrayList<Fighter>();
        Collection<String> input= new HashSet<String>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                input.add(s.nextLine());
            }
        }   catch (FileNotFoundException e) { }

        for (String s : input){
            returnList.add(new Fighter(s.split(":")[0], s.split(":")[1]));
        }

        return returnList;
    }

 /*   public static File selectGroup(){

    }*/


}
