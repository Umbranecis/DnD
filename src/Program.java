import java.io.IOException;

public enum Program{

    PROPERTIES("properties")
            {
                public void runProgram(){
                    try {
                        Main.setMainStage(Visuals.propertyRoll());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            },
    DICESIMULATOR("diceSimulator")
            {
                public void runProgram(){
                    try {
                        Main.setMainStage(Visuals.diceSimulator());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },

    INITIATIVELIST("initiativeList")
            {
                public void runProgram()
                {Main.setMainStage(Visuals.visibleList(new InitiativeList()));}


            };


    private final String typeOfProgam;

    Program(String typeOfProgam) {
        this.typeOfProgam = typeOfProgam;
    }

    public static Program getByName(String name){
        for(Program prog : Program.values()){
            if(name.equalsIgnoreCase(prog.typeOfProgam)){
                return prog;
            }
        }
        return null;
    }

    public void runProgram(){

       this.runProgram();
        ;

    }
}

