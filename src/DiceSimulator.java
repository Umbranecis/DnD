import java.util.Scanner;

public class DiceSimulator {

    public static int roll(){
        int returnValue = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchtest du auswürfeln? (Beispielsweise: 2d6+1) - schreibe zum abbrechen 'stop' ");
        String inputString = scanner.nextLine();
        if (inputString.equalsIgnoreCase("stop"))
            return -2;
        String[] input = inputString.split("d");
        if(input.length != 2){
            System.out.println("Bitte einen gültigen Würfel angeben");
            return -1;
        }
        int amt = Integer.parseInt(input[0]);
        input = input[1].split("\\+");
        int DiceEyeAmt = Integer.parseInt(input[0]);
        int bonus = 0;
        if (input.length == 2)
            bonus = Integer.parseInt(input[1]);
        for(int i = amt; i > 0; i--){
            returnValue = returnValue + new Dice(DiceEyeAmt).value();
        }
        return returnValue + bonus;
    }


    public static void start(){
        while(true){
            int tmp = roll();
            if(tmp == -2)
                return;
            if(tmp != -1)
                System.out.println(tmp);
        }
    }
}
