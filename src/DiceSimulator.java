import Errors.NoValidDice;
import Errors.BreakLoop;

import java.util.Scanner;

public class DiceSimulator {

    public static int roll() throws BreakLoop, NoValidDice {
        int returnValue = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchtest du auswürfeln? (Beispielsweise: 2d6+1) - für einen w20 Wurf gib 'w20' ein - schreibe zum abbrechen 'stop' ");
        String inputString = scanner.nextLine();
        if(inputString.equalsIgnoreCase("w20"))
            return d20();
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

    public static int d20() {
        Scanner scanner = new Scanner(System.in);
        int returnValue;
        System.out.println("gib für einen Wurf mit Vorteil 'adv' uind für einen mit Nachteil 'dis' ein. Ansonsten wird ein normaler w20 geworfen");
        String input = scanner.nextLine();
        switch (input) {
            case "adv":
                return advantage();
            case "dis":
                return disadvantage();
            default:
                return new Dice(20).value();
        }
    }
    private static int disadvantage(){
        int a = new Dice(20).value();
        int b = new Dice(20).value();
        if(a < b)
            return a;
        return b;
    }

    private static int advantage (){
        int a = new Dice(20).value();
        int b = new Dice(20).value();
        if (a > b)
            return a;
        return b;
    }

}