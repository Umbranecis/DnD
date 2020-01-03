import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do? For rolling properties type 'properties', for starting the Dice Simulator type 'DiceSimulator' for exiting type'exit'");
            String aufruf = scanner.nextLine();
            if (aufruf.equalsIgnoreCase("exit"))
                return;
            Program.getByName(aufruf.toLowerCase()).runProgram();
        }
    }
}
