import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;


public class Character {
    int test4nils;
    private String name;
    String characterClass;
    String race;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int level;
    int maxHp;
    int tempHp;
    String allignment;
    int xp;
    int speed;
    int initiative;
    int armorClass;
    int proficencyBonus;
    int passiveWisdom;
    ArrayList<String> proficenctSavingThrows = new ArrayList<String>();
    ArrayList<String> proficenctSkills = new ArrayList<String>();
    ArrayList<String> cantrips = new ArrayList<String>();
    ArrayList<String> spellsLevel1 = new ArrayList<String>();
    ArrayList<String> spellsLevel2 = new ArrayList<String>();
    ArrayList<String> spellsLevel3 = new ArrayList<String>();
    ArrayList<String> spellsLevel4 = new ArrayList<String>();
    ArrayList<String> spellsLevel5 = new ArrayList<String>();
    ArrayList<String> spellsLevel6 = new ArrayList<String>();
    ArrayList<String> spellsLevel7 = new ArrayList<String>();
    ArrayList<String> spellsLevel8 = new ArrayList<String>();
    ArrayList<String> spellsLevel9 = new ArrayList<String>();
    int spellSlotsLvl1;
    int spellSlotsLvl2;
    int spellSlotsLvl3;
    int spellSlotsLvl4;
    int spellSlotsLvl5;
    int spellSlotsLvl6;
    int spellSlotsLvl7;
    int spellSlotsLvl8;
    int spellSlotsLvl9;
    Character temporaryCharacter;

    public Character(String name, String characterClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,String race, int maxHp, String allignment, int speed, int spellSlotsLvl1, String cantrips, String level1Spells){
        this.name = name;
        this.characterClass = characterClass;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.race = race;
        this.maxHp = maxHp;
        this.allignment = allignment;
        this.speed = speed;
        this.spellSlotsLvl1 = spellSlotsLvl1;
        this.cantrips = (ArrayList<String>)Arrays.asList(cantrips.split(","));
        this.spellsLevel1 = (ArrayList<String>)Arrays.asList(level1Spells.split(","));


    }








    // getter//
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getProficencyBonus() {
        return proficencyBonus;
    }

    public void setProficencyBonus(int proficencyBonus) {
        this.proficencyBonus = proficencyBonus;
    }

    public int getPassiveWisdom() {
        return passiveWisdom;
    }

    public void setPassiveWisdom(int passiveWisdom) {
        this.passiveWisdom = passiveWisdom;
    }

    public ArrayList<String> getProficenctSavingThrows() {
        return proficenctSavingThrows;
    }

    public void setProficenctSavingThrows(ArrayList<String> proficenctSavingThrows) {
        this.proficenctSavingThrows = proficenctSavingThrows;
    }

    public ArrayList<String> getProficenctSkills() {
        return proficenctSkills;
    }

    public void setProficenctSkills(ArrayList<String> proficenctSkills) {
        this.proficenctSkills = proficenctSkills;
    }

    public ArrayList<String> getCantrips() {
        return cantrips;
    }

    public void setCantrips(ArrayList<String> cantrips) {
        this.cantrips = cantrips;
    }

    public ArrayList<String> getSpellsLevel1() {
        return spellsLevel1;
    }

    public void setSpellsLevel1(ArrayList<String> spellsLevel1) {
        this.spellsLevel1 = spellsLevel1;
    }

    public ArrayList<String> getSpellsLevel2() {
        return spellsLevel2;
    }

    public void setSpellsLevel2(ArrayList<String> spellsLevel2) {
        this.spellsLevel2 = spellsLevel2;
    }

    public ArrayList<String> getSpellsLevel3() {
        return spellsLevel3;
    }

    public void setSpellsLevel3(ArrayList<String> spellsLevel3) {
        this.spellsLevel3 = spellsLevel3;
    }

    public ArrayList<String> getSpellsLevel4() {
        return spellsLevel4;
    }

    public void setSpellsLevel4(ArrayList<String> spellsLevel4) {
        this.spellsLevel4 = spellsLevel4;
    }

    public ArrayList<String> getSpellsLevel5() {
        return spellsLevel5;
    }

    public void setSpellsLevel5(ArrayList<String> spellsLevel5) {
        this.spellsLevel5 = spellsLevel5;
    }

    public ArrayList<String> getSpellsLevel6() {
        return spellsLevel6;
    }

    public void setSpellsLevel6(ArrayList<String> spellsLevel6) {
        this.spellsLevel6 = spellsLevel6;
    }

    public ArrayList<String> getSpellsLevel7() {
        return spellsLevel7;
    }

    public void setSpellsLevel7(ArrayList<String> spellsLevel7) {
        this.spellsLevel7 = spellsLevel7;
    }

    public ArrayList<String> getSpellsLevel8() {
        return spellsLevel8;
    }

    public void setSpellsLevel8(ArrayList<String> spellsLevel8) {
        this.spellsLevel8 = spellsLevel8;
    }

    public ArrayList<String> getSpellsLevel9() {
        return spellsLevel9;
    }


    //setter//
    public void setSpellsLevel9(ArrayList<String> spellsLevel9) {
        this.spellsLevel9 = spellsLevel9;
    }

    public int getSpellSlotsLvl1() {
        return spellSlotsLvl1;
    }

    public void setSpellSlotsLvl1(int spellSlotsLvl1) {
        this.spellSlotsLvl1 = spellSlotsLvl1;
    }

    public int getSpellSlotsLvl2() {
        return spellSlotsLvl2;
    }

    public void setSpellSlotsLvl2(int spellSlotsLvl2) {
        this.spellSlotsLvl2 = spellSlotsLvl2;
    }

    public int getSpellSlotsLvl3() {
        return spellSlotsLvl3;
    }

    public void setSpellSlotsLvl3(int spellSlotsLvl3) {
        this.spellSlotsLvl3 = spellSlotsLvl3;
    }

    public int getSpellSlotsLvl4() {
        return spellSlotsLvl4;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitujtion() {
        return constitution;
    }

    public void setConstitujtion(int constitujtion) {
        this.constitution = constitujtion;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setSpellSlotsLvl4(int spellSlotsLvl4) {
        this.spellSlotsLvl4 = spellSlotsLvl4;
    }

    public int getSpellSlotsLvl5() {
        return spellSlotsLvl5;
    }

    public void setSpellSlotsLvl5(int spellSlotsLvl5) {
        this.spellSlotsLvl5 = spellSlotsLvl5;
    }

    public int getSpellSlotsLvl6() {
        return spellSlotsLvl6;
    }

    public void setSpellSlotsLvl6(int spellSlotsLvl6) {
        this.spellSlotsLvl6 = spellSlotsLvl6;
    }

    public int getSpellSlotsLvl7() {
        return spellSlotsLvl7;
    }

    public void setSpellSlotsLvl7(int spellSlotsLvl7) {
        this.spellSlotsLvl7 = spellSlotsLvl7;
    }

    public int getSpellSlotsLvl8() {
        return spellSlotsLvl8;
    }

    public void setSpellSlotsLvl8(int spellSlotsLvl8) {
        this.spellSlotsLvl8 = spellSlotsLvl8;
    }

    public int getSpellSlotsLvl9() {
        return spellSlotsLvl9;
    }

    public void setSpellSlotsLvl9(int spellSlotsLvl9) {
        this.spellSlotsLvl9 = spellSlotsLvl9;
    }

    public Character getTemporaryCharacter() {
        return temporaryCharacter;
    }

    public void setTemporaryCharacter(Character temporaryCharacter) {
        this.temporaryCharacter = temporaryCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.maxHp = hp;
    }

    public int getTempHp() {
        return tempHp;
    }

    public void setTempHp(int tempHp) {
        this.tempHp = tempHp;
    }

    public String getAllignment() {
        return allignment;
    }

    public void setAllignment(String allignment) {
        this.allignment = allignment;
    }



}
