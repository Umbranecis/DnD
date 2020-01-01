import java.util.Random;

public class Dice {

    private int sites;
    private int value;
    Random diceRoller = new Random();

    public Dice(int sites){
        this.sites = sites;
        roll();
    }

    public void roll(){
        this.value = diceRoller.nextInt(sites);
    }

    public int value(){
        return this.value;
    }
}
