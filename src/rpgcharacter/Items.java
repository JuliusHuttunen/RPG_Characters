package rpgcharacter;

import java.util.HashMap;

public class Items {

    private static Weapon sunBlade;
    private static Weapon staffOfChaos;
    private static Weapon starterStaff;
    private static Weapon orcAxe;
    private static Armor chainMail;
    private static Armor steelArmor;
    private static Armor wizardHat;
    private static Armor weakRobe;
    private static Armor mageRobe;
    private static Armor mageBoots;
    private static Weapon longBow;
    private static Weapon stick;

    static Item[] items = {
            //Create items here

            //Weapon: Bow
            longBow = new Weapon("Longbow", 2, Weapon.WeaponType.BOW, 40, 0.5),
            //Weapon: Sword
            stick = new Weapon("Stick", 1, Weapon.WeaponType.SWORD, 2, 1),
            sunBlade = new Weapon("Sunblade", 1, Weapon.WeaponType.SWORD, 10, 1.1),
            //Weapon: Staff
            staffOfChaos = new Weapon("Staff of Chaos", 3, Weapon.WeaponType.STAFF, 200, 10),
            starterStaff = new Weapon("Beginner staff", 1, Weapon.WeaponType.STAFF, 20, 1),
            //Weapon: Axe
            orcAxe = new Weapon("Orcish Axe", 1, Weapon.WeaponType.AXE, 60, 0.5),
            //Armor: Mail
            chainMail = new Armor("Chainmail", 1, Item.Slot.BODY, Armor.ArmorType.MAIL, new PrimaryAttribute(1, 2, 3)),
            steelArmor = new Armor("Steel armor", 2, Item.Slot.BODY, Armor.ArmorType.PLATE, new PrimaryAttribute(5, 0, 1)),
            //Armor: Cloth
            wizardHat = new Armor("Wizard hat", 2, Item.Slot.HEAD, Armor.ArmorType.CLOTH, new PrimaryAttribute(0, 0, 10)),
            mageBoots = new Armor("Mage's boots", 1, Item.Slot.LEGS, Armor.ArmorType.CLOTH, new PrimaryAttribute(1, 1, 3)),
            mageRobe = new Armor("Robe", 3, Item.Slot.BODY, Armor.ArmorType.CLOTH, new PrimaryAttribute(2, 3, 10)),
            weakRobe = new Armor("Weak robe", 2, Item.Slot.BODY, Armor.ArmorType.CLOTH, new PrimaryAttribute(2, 1, 7)),
    };

    static HashMap<String, Item> itemMap = new HashMap<>();

    public static Item getItem(String name) {
        for (Item item : items) {
            itemMap.put(item.name, item);
        }
        if(itemMap.get(name) == null){
            System.out.println("There is no such item!");
            return stick;
        }
        return itemMap.get(name);
    }
}
