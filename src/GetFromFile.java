import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GetFromFile {

    public Collection<Fighter> getGroup(File f){
        ArrayList<Fighter> returnList = new ArrayList<Fighter>();
        try {
            Scanner s = new Scanner(f);
        }   catch (FileNotFoundException e) { }


        return returnList;
    }
}
