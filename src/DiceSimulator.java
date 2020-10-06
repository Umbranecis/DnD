import Errors.NoValidDice;

import java.util.Scanner;

public abstract class DiceSimulator {

static public int roll(String s) throws NoValidDice
{
    if(!(s.contains("d"))){throw new NoValidDice();}
    int result = 0;
    int bonus = 0;
    if(s.contains("+")){
        String[] input = s.split("\\+");
        bonus = Integer.parseInt(input[1]);
        s = input[0];
    }
    String[] die = s.split("d");
    int amt = Integer.parseInt(die[0]);
    int diceSidesAmt = Integer.parseInt(die[1]);
    for (int i = amt; i>0; i--){
        result = result + new Dice(diceSidesAmt).value();
    }

    result = result + bonus;
    return result;
}
    public static int d20() {
        return new Dice(20).value();
        }

    public static int disadvantage(){
        int a = new Dice(20).value();
        int b = new Dice(20).value();
        if(a < b)
            return a;
        return b;
    }

    public static int advantage (){
        int a = new Dice(20).value();
        int b = new Dice(20).value();
        if (a > b)
            return a;
        return b;
    }
}