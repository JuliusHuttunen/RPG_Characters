package rpgcharacter;

import java.util.HashMap;

abstract class Character {

    public final String name;
    public int level;
    public double damage;
    public double dps;
    public abstract void dealDamage();
    public abstract void levelUp();

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

    public HashMap<Item.Slot, Item> equipment = new HashMap<>();

    public void sayName(String name) {
        System.out.println(name + ": I am " + this.name + ".");
    }

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

    abstract void equipWeapon(Weapon item);
    abstract void equipArmor(Armor item);

    public Character(String name){
        this.name = name;
        this.level = 1;
        this.damage = 1.0;
        this.dps = 1.0;
        sayName(name);
    }

}

class Mage extends Character {

   PrimaryAttribute attributes;
   public String characterClass = "Mage";

    public Mage(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(1,1,8);
    }

    public void dealDamage(){
        double modifier = attributes.intelligence * 0.01;
        double damageDone = damage * modifier;
        System.out.println(this.name + " dealt " + damageDone + " dmg.");
    }

    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 1;
        attributes.intelligence += 5;
        this.level++;
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case WAND, STAFF -> {
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                this.dps = weapon.getDps() * (1 + (attributes.intelligence / 100));
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, BOW, DAGGER, HAMMER, SWORD -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    void equipArmor(Armor armor) {
        switch (armor.type) {
            case CLOTH -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                itemAttributeForSwap = armor.itemAttributes;
            }
            case MAIL, LEATHER, PLATE -> Armor.InvalidArmorException();
        }
    }

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(PrimaryAttribute attributes) {
        this.attributes = attributes;
    }

}

class Ranger extends Character {
    public PrimaryAttribute attributes;
    public String characterClass = "Ranger";

    public Ranger(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(1,7,1);
    }

    public void dealDamage(){
        double modifier = attributes.dexterity * 0.01;
        double damageDone = damage * modifier;
        System.out.println(this.name + " dealt " + damageDone + " dmg.");
    }

    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 5;
        attributes.intelligence += 1;
        this.level++;
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case BOW -> {
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                this.dps = weapon.getDps() * (1 + (attributes.dexterity / 100));
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, WAND, STAFF, DAGGER, HAMMER, SWORD -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    void equipArmor(Armor armor) {
        switch (armor.type) {
            case LEATHER, MAIL -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                itemAttributeForSwap = armor.itemAttributes;
            }
            case CLOTH, PLATE -> Armor.InvalidArmorException();
        }
    }

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(PrimaryAttribute attributes) {
        this.attributes = attributes;
    }
}

class Rogue extends Character {
    public PrimaryAttribute attributes;
    public String characterClass = "Rogue";

    public Rogue(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(2,6,1);
    }

    public void dealDamage(){
        double modifier = attributes.dexterity * 0.01;
        double damageDone = damage * modifier;
        System.out.println(this.name + " dealt " + damageDone + " dmg.");
    }

    public void levelUp(){
        attributes.strength += 1;
        attributes.dexterity += 4;
        attributes.intelligence += 1;
        this.level++;
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case DAGGER, SWORD ->{
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                this.dps = weapon.getDps() * (1 + (attributes.dexterity / 100));
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case AXE, STAFF, HAMMER, BOW, WAND -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    void equipArmor(Armor armor) {
        switch (armor.type) {
            case LEATHER, MAIL -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                itemAttributeForSwap = armor.itemAttributes;
            }
            case CLOTH, PLATE -> Armor.InvalidArmorException();
        }
    }

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(PrimaryAttribute attributes) {
        this.attributes = attributes;
    }

}

class Warrior extends Character {
    public PrimaryAttribute attributes;
    public String characterClass = "Warrior";

    public Warrior(String name) {
        super(name);
        this.attributes = new PrimaryAttribute(5,2,1);
    }

    public void dealDamage(){
        double modifier = attributes.strength * 0.01;
        double damageDone = damage + damage * modifier;
        System.out.println(this.name + " dealt " + damageDone + " dmg.");
    }

    public void levelUp(){
        attributes.strength += 3;
        attributes.dexterity += 2;
        attributes.intelligence += 1;
        this.level++;
        System.out.println(this.name + " has ascended to level " + this.level + ".");
    }

    void equipWeapon(Weapon weapon) {
        switch (weapon.type) {
            case AXE, HAMMER, SWORD -> {
                equipment.put(weapon.slot, weapon);
                this.damage = weapon.getDamage();
                this.dps = weapon.getDps() * (1 + (attributes.strength / 100));
                System.out.println(this.name + " has equipped " + weapon.name + ".");
            }
            case WAND, BOW, DAGGER, STAFF -> Weapon.InvalidWeaponException();
        }
    }

    PrimaryAttribute itemAttributeForSwap;

    void equipArmor(Armor armor) {
        switch (armor.type) {
            case MAIL, PLATE -> {
                putOnArmor(this.attributes, itemAttributeForSwap, armor);
                itemAttributeForSwap = armor.itemAttributes;
            }
            case LEATHER, CLOTH -> Armor.InvalidArmorException();
        }
    }

    public PrimaryAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(PrimaryAttribute attributes) {
        this.attributes = attributes;
    }
}
