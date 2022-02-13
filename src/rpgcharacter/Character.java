package rpgcharacter;

import java.util.HashMap;

abstract class Character {

    //Common attributes
    public final String name;
    public int level;
    public double damage;
    public double dps;
    public String characterClass;
    public HashMap<Item.Slot, Item> equipment = new HashMap<>();
    public PrimaryAttribute attributes;

    //Abstract methods
    public abstract void levelUp();

    //EquipItem cases
    abstract void equipWeapon(Weapon item);
    abstract void equipArmor(Armor item);

    //Character says their name
    public void sayName(String name) {
        System.out.println(name + ": I am " + this.name + ".");
    }

    //Deal damage in one sec
    public void dealDamage(){
        System.out.println(this.name + " dealt " + this.dps + " dmg.");
    }

    //Equipping armor and handling attribute gain
    public void putOnArmor(PrimaryAttribute attributes, PrimaryAttribute itemAttributeForSwap, Armor armor){
        if(equipment.get(armor.slot) == null) {
            equipment.put(armor.slot, armor);
        }
        else {
            System.out.println(this.name + " has unequipped " + equipment.get(armor.slot).toString() + ".");
            attributes.intelligence -= itemAttributeForSwap.intelligence;
            attributes.dexterity -= itemAttributeForSwap.dexterity;
            attributes.strength -= itemAttributeForSwap.strength;
            equipment.put(armor.slot, armor);
        }
        attributes.intelligence += armor.itemAttributes.intelligence;
        attributes.dexterity += armor.itemAttributes.dexterity;
        attributes.strength += armor.itemAttributes.strength;
        System.out.println(this.name + " has equipped " + armor.name + ".");
    }

    //Equipping items common method
    public void equipItem(Item item){
        if(item.reqLevel > level){
            Item.InvalidLevelException(this);
            return;
        }
        switch(item.slot) {
            case WEAPON -> equipWeapon((Weapon) item);
            case BODY, LEGS, HEAD -> equipArmor((Armor) item);
        }
    }

    //Constructor
    public Character(String name){
        this.name = name;
        this.level = 1;
        this.damage = 1;
        this.attributes = new PrimaryAttribute(0,0,0);
        sayName(name);
    }

}

class Mage extends Character {

    //Constructor
    public Mage(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(1,1,8);
        this.dps = damage * 1.08;
        this.characterClass = "Mage";
    }

    //Leveling up
    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 1;
        attributes.intelligence += 5;
        this.level++;
        double modifier = 1 + this.attributes.intelligence * 0.01;
        Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
        if(equippedWeapon == null){
            this.dps = damage * modifier;
        }
        else {
            this.dps = equippedWeapon.getDps() * modifier;
        }
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    //Can only equip staff or wand
    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case WAND, STAFF -> {
                equipment.put(weapon.slot, weapon);
                //Update damage and dps
                this.damage = weapon.getDamage();
                double modifier = 1 + this.attributes.intelligence * 0.01;
                this.dps = weapon.getDps() * modifier;
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, BOW, DAGGER, HAMMER, SWORD -> Weapon.InvalidWeaponException();
        }
    }

    //Initialize attributes for armor swap and dps
    PrimaryAttribute itemAttributeForSwap;

    //Can only equip cloth
    void equipArmor(Armor armor) {
        switch (armor.type) {
            case CLOTH -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                double modifier = 1 + this.attributes.intelligence * 0.01;
                Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
                if(equippedWeapon == null){
                    this.dps = damage * modifier;
                }
                else {
                    this.dps = equippedWeapon.getDps() * modifier;
                }
                itemAttributeForSwap = armor.itemAttributes;
            }
            case MAIL, LEATHER, PLATE -> Armor.InvalidArmorException();
        }
    }
}

class Ranger extends Character {

    //Constructor
    public Ranger(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(1,7,1);
        this.dps = damage * 1.07;
        this.characterClass = "Ranger";
    }

    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 5;
        attributes.intelligence += 1;
        this.level++;
        double modifier = 1 + this.attributes.dexterity * 0.01;
        Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
        if(equippedWeapon == null){
            this.dps = damage * modifier;
        }
        else {
            this.dps = equippedWeapon.getDps() * modifier;
        }
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    //Can only equip bow
    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case BOW -> {
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                double modifier = 1 + this.attributes.dexterity * 0.01;
                this.dps = weapon.getDps() * modifier;
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, WAND, STAFF, DAGGER, HAMMER, SWORD -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    //Can only equip leather and mail
    void equipArmor(Armor armor) {
        switch (armor.type) {
            case LEATHER, MAIL -> {
                Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
                double modifier = 1 + this.attributes.dexterity * 0.01;
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                if(equippedWeapon == null){
                    this.dps = damage * modifier;
                }
                else {
                    this.dps = equippedWeapon.getDps() * modifier;
                }
                itemAttributeForSwap = armor.itemAttributes;
            }
            case CLOTH, PLATE -> Armor.InvalidArmorException();
        }
    }
}

class Rogue extends Character {

    public Rogue(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(2,6,1);
        this.dps = damage * 1.06;
        this.characterClass = "Rogue";
    }

    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 4;
        attributes.intelligence += 1;
        this.level++;
        double modifier = 1 + this.attributes.dexterity * 0.01;
        Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
        if(equippedWeapon == null){
            this.dps = damage * modifier;
        }
        else {
            this.dps = equippedWeapon.getDps() * modifier;
        }
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    //Can only equip dagger or sword
    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case DAGGER, SWORD ->{
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                double modifier = 1 + this.attributes.dexterity * 0.01;
                this.dps = weapon.getDps() * modifier;
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, STAFF, HAMMER, BOW, WAND -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    //Can only equip leather or mail
    void equipArmor(Armor armor) {
        switch (armor.type) {
            case LEATHER, MAIL -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                double modifier = 1 + this.attributes.dexterity * 0.01;
                Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
                if(equippedWeapon == null){
                    this.dps = damage * modifier;
                }
                else {
                    this.dps = equippedWeapon.getDps() * modifier;
                }
                itemAttributeForSwap = armor.itemAttributes;
            }
            case CLOTH, PLATE -> Armor.InvalidArmorException();
        }
    }
}

class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(5,2,1);
        this.dps = damage * 1.05;
        this.characterClass = "Warrior";
    }

    public void levelUp(){
        attributes.strength += 3;
        attributes.dexterity += 2;
        attributes.intelligence += 1;
        this.level++;
        double modifier = 1 + this.attributes.strength * 0.01;
        Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
        if(equippedWeapon == null){
            this.dps = damage * modifier;
        }
        else {
            this.dps = equippedWeapon.getDps() * modifier;
        }
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    //Can only equip axe, hammer or sword
    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case AXE, HAMMER, SWORD -> {
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                double modifier = 1 + this.attributes.strength * 0.01;
                this.dps = weapon.getDps() * modifier;
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case WAND, BOW, DAGGER, STAFF -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    //Can only equip mail or plate
    void equipArmor(Armor armor) {
        switch (armor.type) {
            case MAIL, PLATE -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                double modifier = 1 + this.attributes.strength * 0.01;
                Weapon equippedWeapon = (Weapon) equipment.get(Item.Slot.WEAPON);
                if(equippedWeapon == null){
                    this.dps = damage * modifier;
                }
                else {
                    this.dps = equippedWeapon.getDps() * modifier;
                }
                itemAttributeForSwap = armor.itemAttributes;
            }
            case LEATHER, CLOTH -> Armor.InvalidArmorException();
        }
    }
}
