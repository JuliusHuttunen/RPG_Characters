package rpgcharacter;

public class Main {

    public static void main(String[] args) {

        //Create character
        Warrior conan = new Warrior("Conan");
        characterStats(conan);

        //Deal damage (dps)
        conan.dealDamage();

        //Level up twice
        conan.levelUp();
        characterStats(conan);
        conan.levelUp();
        characterStats(conan);

        //Equip armor
        conan.equipItem(Items.steelArmor);
        characterStats(conan);

        //Equip weapon
        conan.equipItem(Items.orcAxe);
        characterStats(conan);

        //Equip lesser armor
        conan.equipItem(Items.chainMail);
        characterStats(conan);

        //Level up
        conan.levelUp();
        characterStats(conan);


    }

    public static void characterStats(Character character) {
        StringBuilder str = new StringBuilder();
        str.append("Name: " + character.name + ", ");
        str.append("Class: " + character.characterClass + ", ");
        str.append("Level: " + character.level + ", ");
        str.append("STR: " + character.attributes.strength + ", ");
        str.append("DEX: " + character.attributes.dexterity + ", ");
        str.append("INT: " + character.attributes.intelligence + ", ");
        str.append("DPS: " + character.dps);
        System.out.println(str);
    }
}
