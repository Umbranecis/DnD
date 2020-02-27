

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        while(true)
            test(Integer.parseInt(new Scanner(System.in).nextLine()));

        }



    static void test(int amt){
        int returnValue = 0;
        for (int i = amt; i > 0; i--){
            for(int n : PropertyRoll.propertyValues()) {
            returnValue = returnValue + n;
            }
        }
        System.out.println(returnValue / amt);
    }
}
