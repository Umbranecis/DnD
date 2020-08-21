public enum Program{

    PROPERTIES("properties")
            {
                public void runProgram(){
                    Main.setMainStage(Visuals.propertyRoll());

                }
            },
    DICESIMULATOR("diceSimulator")
            {
                public void runProgram(){
                    Main.setMainStage(Visuals.diceSimulator());
                }
            },

    INITIATIVELIST("initiativeList")
            {
                public void runProgram() {Main.setMainStage(Visuals.createlist(new InitiativeList()));}
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

