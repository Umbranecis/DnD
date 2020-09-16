import javafx.fxml.FXML;

public class Controller_Start {

    @FXML
    public void runProgramProperties(){
        runProgram(Program.PROPERTIES);
    }

    @FXML
    public void runProgramDiceSimulator(){
        runProgram(Program.DICESIMULATOR);
    }

    @FXML
    public void runProgramInitiativeList(){
        runProgram(Program.INITIATIVELIST);
    }

    @FXML
    public void runProgram(Program p){
        p.runProgram();
    }


}
