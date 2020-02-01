import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        while(true){
        int input = Integer.parseInt(new Scanner(System.in).nextLine());
        Double sum = 0.0;
        for (int i = input; i>0; i--)
            sum = sum + PropertyRoll.value(PropertyRoll.propertyValues());
        System.out.println(sum/input);
    }}
}
