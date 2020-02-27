public class item {
    String damage;
    String typeOfDamage;
    String attackProperty;
    String name;

    public item(String name, String damage, String attackProperty, String typeOfDamage){
        this.name = name;
        this.damage = damage;
        this.attackProperty = attackProperty;
        this.typeOfDamage = typeOfDamage;
    }
}
