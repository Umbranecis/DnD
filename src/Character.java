import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Character {
    HashMap<Integer, ArrayList<String>> spells = new HashMap<Integer, ArrayList<String>>();
    HashMap<String, Integer> properties = new HashMap<String, Integer>();
    HashMap<String, Integer> skills = new HashMap<String, Integer>();
    HashMap<String, String> persistentValues = new HashMap<String, String>();
    HashMap<String, Integer> nonPersistentValues = new HashMap<String, Integer>();
    HashMap<String, Integer> temporaryValues = new HashMap<String, Integer>();
    HashMap<Integer, ArrayList<String>> inventory = new  HashMap<Integer, ArrayList<String>>();

    public Character(
            int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
            int proficiencyBonus, String profiecencies,
            String characterClass, String race, String background, String allignment, String playerName

    ) {
        persistentValues.put("class", characterClass);
        persistentValues.put("race", race);
        persistentValues.put("background", background);
        persistentValues.put("allignment", allignment);
        persistentValues.put("playerName", playerName);
        properties.put("strength", strength);
        properties.put("dexterity", dexterity);
        properties.put("constitution", constitution);
        properties.put("intelligence", intelligence);
        properties.put("wisdom", wisdom);
        properties.put("charisma", charisma);
        skills.put("strength", strength/2 - 5);
        skills.put("dexterity", dexterity/2 - 5);
        skills.put("constitution", constitution/2 - 5);
        skills.put("intelligence", intelligence/2 - 5);
        skills.put("wisdom", wisdom/2 - 5);
        skills.put("charisma", charisma/2 - 5);
        skills.put("acrobatics", dexterity/2 - 5);
        skills.put("animal handling", wisdom/2 - 5);
        skills.put("arcana", intelligence/2 - 5);
        skills.put("athletics", strength/2 - 5);
        skills.put("deception", charisma/2 - 5);
        skills.put("history", intelligence/2 - 5);
        skills.put("insight", wisdom/2 - 5);
        skills.put("intimidation", charisma/2 - 5);
        skills.put("invastigation", intelligence/2 - 5);
        skills.put("medicine", wisdom/2 - 5);
        skills.put("nature", intelligence/2 - 5);
        skills.put("perception", wisdom/2 - 5);
        skills.put("performance", charisma/2 - 5);
        skills.put("persuation", charisma/2 - 5);
        skills.put("religion", intelligence/2 - 5);
        skills.put("sleight of hand", dexterity/2 - 5);
        skills.put("stealth", dexterity/2 - 5);
        skills.put("survival", wisdom/2 - 5);
        List<String> proficencies = Arrays.asList((profiecencies.split(",")));
        for(String str: proficencies) {
            try{
                skills.replace(str, skills.get(str) + proficiencyBonus);}
            catch(java.lang.NullPointerException ex){
                System.out.println("Der wert " + str + " existiert nicht");
            }
            }

        }







}











