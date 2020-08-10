import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public abstract class PropertyRoll {


    public static int value(int[] a){
        int tmp = 0;
        a[0] = 0;
        for(Integer value: a)
            tmp = tmp + value;
        return tmp;
    }


    public static int[] property(){
        int totalValue = 0;
        int[] allValues =  {0,0,0,0} ;
        for (int i = 0; i<4; i++){
            allValues[i] = new Dice(6).value();
        }
        Arrays.sort(allValues);
        return allValues;
    }

    public static Collection<int[]> properties(){
        ArrayList<int[]> a = new ArrayList<int[]>();
        for (int i = 6; i>0; i--){
            a.add(property());
        }
        return a;
    }
}
