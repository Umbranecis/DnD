public enum Grouptype {
    ENCOUNTER("/Users/nils/IdeaProjects/DnD/src/Encounters", "Encounter"),
    GROUP("/Users/nils/IdeaProjects/DnD/src/Groups", "Group");

    String PATH;
    String TYPE;
    Grouptype(String s, String s2){
        this.PATH = s;
        this.TYPE = s2;
    }
}
