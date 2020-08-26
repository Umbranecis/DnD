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

public class FileManager {

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

    public static File selectGroup(){
        FileChooser f = new FileChooser();
        f.setInitialDirectory(new File("/Users/nils/IdeaProjects/DnD/src/Groups"));
        return f.showOpenDialog(null);
    }

    public static Collection<Fighter> getGroup(){ return getGroup(selectGroup()); }



    public static Collection<Fighter> getEncounter(File f){
        ArrayList<Fighter> returnList = new ArrayList<Fighter>();
        Collection<String> input= new HashSet<String>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                input.add(s.nextLine());
            }
        }   catch (FileNotFoundException e) { }

        for (String s : input){
            returnList.add(new Fighter(s, "DM"));
        }

        return returnList;
    }


    public static Collection<Fighter> getEncounter(){return getEncounter(selectEncounter());}

    public static File selectEncounter(){
        FileChooser f = new FileChooser();
        f.setInitialDirectory(new File("/Users/nils/IdeaProjects/DnD/src/Encounters"));
        return f.showOpenDialog(null);
    }




}
