import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PropertyRoll {
    public static int value(Collection<Integer> c){
        int tmp = 0;
        for(Integer value: c)
            tmp = tmp + value;
        return tmp;
    }

    public static int rollAndSortOut(){
        int totalValue = 0;
        int[] allValues =  {0,0,0,0} ;
        for (int i = 0; i<4; i++){
            allValues[i] = new Dice(6).value();
        }
        Arrays.sort(allValues);
        allValues[0] = 0;
        return Arrays.stream(allValues).reduce(0, Integer::sum);

        //return totalValue;
    }

    public static Collection<Integer> propertyValues(){
        ArrayList<Integer> propertyValues = new ArrayList<Integer>();
        for (int i = 6; i > 0; i--)
            propertyValues.add(rollAndSortOut());
        return propertyValues;
    }

    public static void printPropertyValues(){
        Collection<Integer> values = propertyValues();
        for (Integer value: values){
            System.out.println(value);
        }
        System.out.println("Gesamt: " + value(values));
    }
}
