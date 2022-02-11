package rpgcharacter;

public class Items {

    //Weapon: Sword
    static final Weapon sunBlade = new Weapon("Sunblade", 1, Weapon.WeaponType.SWORD, 10, 1.1);
    //Weapon: Staff
    static final Weapon staffOfChaos = new Weapon("Staff of Chaos", 3, Weapon.WeaponType.STAFF, 200, 10);
    static final Weapon starterStaff = new Weapon("Beginner staff", 1, Weapon.WeaponType.STAFF, 20, 1);
    //Weapon: Axe
    static final Weapon orcAxe = new Weapon("Orcish Axe", 1, Weapon.WeaponType.AXE, 60, 0.5);

    //Armor: Mail
    static final Armor chainMail = new Armor("Chainmail", 1, Item.Slot.BODY, Armor.ArmorType.MAIL, new PrimaryAttribute(1,2,3));
    static final Armor steelArmor = new Armor("Steel armor", 2, Item.Slot.BODY, Armor.ArmorType.PLATE, new PrimaryAttribute(5, 0, 1));

    //Armor: Cloth
    static final Armor wizardHat = new Armor("Wizard hat", 2, Item.Slot.HEAD, Armor.ArmorType.CLOTH, new PrimaryAttribute(0,0,10));
    static final Armor mageBoots = new Armor("Mage's boots", 1, Item.Slot.LEGS, Armor.ArmorType.CLOTH, new PrimaryAttribute(1,1,3));
    static final Armor mageRobe = new Armor("Robe", 3, Item.Slot.BODY, Armor.ArmorType.CLOTH, new PrimaryAttribute(2,3,10));
    static final Armor weakRobe = new Armor("Weak robe", 2, Item.Slot.BODY, Armor.ArmorType.CLOTH, new PrimaryAttribute(2,1,7));

}
