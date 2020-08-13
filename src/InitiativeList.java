import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class InitiativeList {
    private ArrayList<Participiant> finishedList = new ArrayList<Participiant>();

    public ArrayList<Participiant> getFinishedList(){
        sortList();
        return finishedList;
    }

    public void sortList(){
        Collections.sort(finishedList, (a, b) -> {
            return b.getInitiative().compareTo(a.getInitiative());
        });
    }

    public void addParticipant(Participiant p){
        finishedList.add(p);
    }

    public void addParticipant(String n, String pn, int i){finishedList.add(new Participiant(n,pn,i));};

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

        public Participiant(String n, String pn, int i){
            initiative = i;
            name = n;
            playerName = pn;
        }
        Integer getInitiative(){
            return initiative;
        }
    }


}
