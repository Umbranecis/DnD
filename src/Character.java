import java.util.*;


public class Character {
    HashMap<Integer, ArrayList<String>> spells = new HashMap<Integer, ArrayList<String>>();
    HashMap<String, Integer> properties = new HashMap<String, Integer>();
    HashMap<String, Integer> skills = new HashMap<String, Integer>();
    HashMap<String, String> persistentValues = new HashMap<String, String>();
    HashMap<String, Integer> nonPersistentValues = new HashMap<String, Integer>();
    HashMap<String, Integer> temporaryValues = new HashMap<String, Integer>();
    Collection<String> inventory = new HashSet<String>();
    ArrayList<Item> attacks = new ArrayList<Item>();


    public Character(
            int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
            int proficiencyBonus, String profiecencies,
            String characterClass, String race, String background, String allignment, String playerName,int speed,
            int xp, int hp, int armorClass, int level, int gold,
            int spellSlots1, int spellSlots2, int spellSlots3, int spellSlots4, int spellSlots5, int spellSlots6, int spellSlots7, int spellSlots8, int spellSlots9
    ) {
        temporaryValues.put("hp", hp);
        temporaryValues.put("spellSlots1", spellSlots1);
        temporaryValues.put("spellSlots2", spellSlots2);
        temporaryValues.put("spellSlots3", spellSlots3);
        temporaryValues.put("spellSlots4", spellSlots4);
        temporaryValues.put("spellSlots5", spellSlots5);
        temporaryValues.put("spellSlots6", spellSlots6);
        temporaryValues.put("spellSlots7", spellSlots7);
        temporaryValues.put("spellSlots8", spellSlots8);
        temporaryValues.put("spellSlots9", spellSlots9);
        nonPersistentValues.put("xp", xp);
        nonPersistentValues.put("hp", hp);
        nonPersistentValues.put("armorClass", armorClass);
        nonPersistentValues.put("level", level);
        nonPersistentValues.put("gold", gold);
        nonPersistentValues.put("spellSlots1", spellSlots1);
        nonPersistentValues.put("spellSlots2", spellSlots2);
        nonPersistentValues.put("spellSlots3", spellSlots3);
        nonPersistentValues.put("spellSlots4", spellSlots4);
        nonPersistentValues.put("spellSlots5", spellSlots5);
        nonPersistentValues.put("spellSlots6", spellSlots6);
        nonPersistentValues.put("spellSlots7", spellSlots7);
        nonPersistentValues.put("spellSlots8", spellSlots8);
        nonPersistentValues.put("spellSlots9", spellSlots9);
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

        void longRest(){
            for (String str : temporaryValues.keySet()){
                temporaryValues.replace(str, nonPersistentValues.get("str"));
            }
        }









}











