import javafx.stage.FileChooser;

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.util.*;

public abstract class FileManager {
    public static final String ENCOUNTER = "/Users/nils/IdeaProjects/DnD/src/Encounters";
    public static final String GROUP = "/Users/nils/IdeaProjects/DnD/src/Groups";
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
        f.setInitialDirectory(new File(GROUP));
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
            String[] inputStrings = s.split(":");
            for(int i = Integer.parseInt(inputStrings[1]); i>0; i--){
            returnList.add(new Fighter(inputStrings[0], "DM"));
            }
        }

        return returnList;
    }


    public static Collection<Fighter> getEncounter(){return getEncounter(selectEncounter());}

    public static File selectEncounter(){
        FileChooser f = new FileChooser();
        f.setInitialDirectory(new File(ENCOUNTER));
        return f.showOpenDialog(null);
    }


    public static void addEncounter(HashMap<String, Integer> input, String name){
        File f = new File(ENCOUNTER + "/" + name + ".txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedWriter writer = null;
        try {
            writer =new BufferedWriter(new FileWriter(f));
            for(String s : input.keySet()) {
                writer.write(s + ":" + input.get(s));
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addGroup(ArrayList<Fighter> input, String name){
        File f = new File(GROUP + "/" + name + ".txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(f));
            for(Fighter fighter : input){
                writer.write(fighter.name + ":" + fighter.playerName);
                writer.newLine();
            }
            writer.close();
        }
        catch(Exception ex){}
    }







}
