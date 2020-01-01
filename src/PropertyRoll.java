import java.util.ArrayList;
import java.util.Collection;

public class PropertyRoll {
    public static int value(){
        return 1;
    }

    public static int rollAndSortOut(){
        int lowestValue = new Dice(6).value();
        int totalValue = 0;
        for (int i = 3; i>0; i--){
            int tmp = new Dice(6).value();
                if (tmp > lowestValue)
                    totalValue = totalValue + tmp;
                if (tmp <= lowestValue) {
                    totalValue = totalValue + lowestValue;
                    lowestValue = tmp;
                }
        }
        return totalValue;
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
    }
}
