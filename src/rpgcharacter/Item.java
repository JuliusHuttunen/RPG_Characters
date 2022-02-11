package rpgcharacter;

abstract class Item {

    public final String name;
    public final int reqLevel;

    public enum Slot {
        HEAD,
        BODY,
        LEGS,
        WEAPON
    }

    public Slot slot;

    public Item(String name, int reqLevel, Slot slot){
        this.name = name;
        this.reqLevel = reqLevel;
        this.slot = slot;
    }

    public static void InvalidLevelException(Character character) {
        System.out.println(character.name + " is not powerful enough to use this item!");
    }

    public String getName() {
        return name;
    }

    public int getReqLevel() {
        return reqLevel;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
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

    public final int damage;
    private final double attSpeed;
    public final WeaponType type;
    public final double dps;

    public Weapon(String name, int reqLevel, WeaponType type, int damage, double attSpeed) {
        super(name, reqLevel, Slot.WEAPON);
        this.type = type;
        this.damage = damage;
        this.attSpeed = attSpeed;
        this.dps = attSpeed * damage;
    }

    enum WeaponType {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    public static void InvalidWeaponException() {
        System.out.println("I cannot use this weapon!");
    }

    public int getDamage() {
        return damage;
    }

    public double getAttSpeed() {
        return attSpeed;
    }

    public WeaponType getType() {
        return type;
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

   public final ArmorType type;

    public Armor(String name, int reqLevel, Slot slot, ArmorType type, PrimaryAttribute itemAttributes) {
        super(name, reqLevel, slot);
        this.type = type;
        this.itemAttributes = itemAttributes;
    }

    enum ArmorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    PrimaryAttribute itemAttributes;

    public static void InvalidArmorException() {
        System.out.println("I cannot wear this armor!");
    }

    public ArmorType getType() {
        return type;
    }

    public PrimaryAttribute getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(PrimaryAttribute itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    @Override
    public String toString() {
        return name;
    }
}
