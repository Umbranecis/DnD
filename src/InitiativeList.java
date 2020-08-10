import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class InitiativeList {
    ArrayList<Participiant> finishedList = new ArrayList<Participiant>();

    public ArrayList<Participiant> getFinishedList(){
        sortList();
        return finishedList;
    }

    public void sortList(){
        Collections.sort(finishedList, (a, b) -> {
            return a.getInitiative().compareTo(b.getInitiative());
        });
    }

    public void addParticipant(Participiant p){
        finishedList.add(p);
    }

    public void convertFighterAndAdd(Fighter f, int i){
        finishedList.add(new Participiant(f, i));
    }



    class Participiant extends Fighter{
        int initiative;
        public Participiant(Fighter f, int i)
        {
            initiative = i;
            name = f.name;
            playerName = f.playerName;
        }
        Integer getInitiative(){
            return initiative;
        }
    }


}
