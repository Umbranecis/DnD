import Errors.NoValidDice;
import Errors.BreakLoop;

import java.util.Scanner;

public class DiceSimulator {

    public static int roll() throws BreakLoop, NoValidDice {
        int returnValue = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchtest du auswürfeln? (Beispielsweise: 2d6+1) - schreibe zum abbrechen 'stop' ");
        String inputString = scanner.nextLine();
        if (inputString.equalsIgnoreCase("stop"))
            throw new BreakLoop();
        String[] input = inputString.split("d");
        if(input.length != 2){
            throw new NoValidDice();
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


    public static void start() {
        while (true) {
            int tmp = 0;
            try {
                tmp = roll();
            }
            catch (BreakLoop breakLoop) { return; }
            catch ( NoValidDice noValidDice) {
                System.out.println("Bitte einen Gültigen würfel der folgenden Art angeben: 2d6+1");
                continue;
            }
            System.out.println(tmp);
        }
    }
}