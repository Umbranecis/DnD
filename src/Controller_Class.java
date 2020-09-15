import javafx.fxml.FXML;

public class Controller_Class {

    @FXML
    public void runProgramProperties(){
        runProgram(Program.PROPERTIES);
    }

    public void runProgram(Program p){
        p.runProgram();
    }


}
