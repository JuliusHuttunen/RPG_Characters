package rpgcharacter;

abstract class Item {

    //Initialize common attributes
    public final String name;
    public final int reqLevel;
    public Slot slot;

    //Slot enumerator
    public enum Slot {
        HEAD,
        BODY,
        LEGS,
        WEAPON
    }

    //Constructor
    public Item(String name, int reqLevel, Slot slot){
        this.name = name;
        this.reqLevel = reqLevel;
        this.slot = slot;
    }

    //If level is too low, print this to console
    public static void InvalidLevelException(Character character) {
        System.out.println(character.name + " is not powerful enough to use this item!");
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", reqLevel=" + reqLevel +
                ", slot=" + slot +
                '}';
    }
}

class Weapon extends Item {

    //Initialize attributes
    public final int damage;
    private final double attSpeed;
    public final WeaponType type;
    public final double dps;

    //Constructor, note that slot is hard assigned
    public Weapon(String name, int reqLevel, WeaponType type, int damage, double attSpeed) {
        super(name, reqLevel, Slot.WEAPON);
        this.type = type;
        this.damage = damage;
        this.attSpeed = attSpeed;
        this.dps = attSpeed * damage;
    }

    //Type enumerator
    enum WeaponType {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    //This is printed if not valid weapon
    public static void InvalidWeaponException() {
        System.out.println("I cannot use this weapon!");
    }

    //These are used when calculating character dps and damage
    public int getDamage() {
        return damage;
    }
    public double getDps() {
        return dps;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", reqLevel=" + reqLevel +
                ", slot=" + slot +
                ", damage=" + damage +
                ", attSpeed=" + attSpeed +
                ", type=" + type +
                ", dps=" + dps +
                '}';
    }
}

class Armor extends Item {

    //Initialize attributes
    public final ArmorType type;
    PrimaryAttribute itemAttributes;

    //Constructor
    public Armor(String name, int reqLevel, Slot slot, ArmorType type, PrimaryAttribute itemAttributes) {
        super(name, reqLevel, slot);
        this.type = type;
        this.itemAttributes = itemAttributes;
    }

    //Armor type enumerator
    enum ArmorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    //If not valid armor, print this
    public static void InvalidArmorException() {
        System.out.println("I cannot wear this armor!");
    }

    @Override
    public String toString() {
        return name;
    }
}
