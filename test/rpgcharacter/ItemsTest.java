package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {
    Weapon testWeapon;
    Armor testPlateBody;
    Armor testPlateBodyLvl2;
    Weapon testBow;
    Armor testClothHead;
    Weapon testWeaponLvl2;
    Warrior test;

    PrintStream console;
    ByteArrayOutputStream newConsole;

    @BeforeEach
    void setUp(){
        testBow = new Weapon("Common bow", 1, Weapon.WeaponType.BOW, 12, 0.8);
        testClothHead = new Armor("Common Cloth Head Armor", 1, Item.Slot.HEAD, Armor.ArmorType.CLOTH, new PrimaryAttribute(0,0,5));
        testPlateBody = new Armor("Common Plate Body Armor", 1, Item.Slot.BODY, Armor.ArmorType.PLATE, new PrimaryAttribute(1,0,0));
        testPlateBodyLvl2 = new Armor("Common Plate Body Armor", 2, Item.Slot.BODY, Armor.ArmorType.PLATE, new PrimaryAttribute(1,0,0));
        testWeapon = new Weapon("Common axe", 1, Weapon.WeaponType.AXE, 7, 1.1);
        testWeaponLvl2 = new Weapon("Uncommon axe", 2, Weapon.WeaponType.AXE, 7, 1.1);
        test = new Warrior("test");



    }

    @Test
    @DisplayName("Test weapon levelException")
    void testWeaponLevelException() {
        System.out.println("Initializing test...");
        console = System.out;
        newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        test.equipItem(testWeaponLvl2);
        System.setOut(console);
        assertEquals("test is not powerful enough to use this item!\r\n", newConsole.toString(), "Should throw a message into console.");
    }

    @Test
    @DisplayName("Test armor levelException")
    void testArmorLevelException() {
        System.out.println("Initializing test...");
        console = System.out;
        newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        test.equipItem(testPlateBodyLvl2);
        System.setOut(console);
        assertEquals("test is not powerful enough to use this item!\r\n", newConsole.toString(), "Should throw a message into console.");
    }

    @Test
    @DisplayName("Test invalid weapon type")
    void testInvalidWeaponException() {
        System.out.println("Initializing test...");
        console = System.out;
        newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        test.equipItem(testBow);
        System.setOut(console);
        assertEquals("I cannot use this weapon!\r\n", newConsole.toString(), "Should throw a message into console.");
    }

    @Test
    @DisplayName("Test invalid armor type")
    void testInvalidArmorException() {
        System.out.println("Initializing test...");
        console = System.out;
        newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        test.equipItem(testClothHead);
        System.setOut(console);
        assertEquals("I cannot wear this armor!\r\n", newConsole.toString(), "Should throw a message into console.");
    }

    @Test
    @DisplayName("Test valid weapon type")
    void testValidWeapon() {
        test.equipItem(testWeapon);
        assertEquals(true, !isNull(test.equipment.get(Item.Slot.WEAPON)));
    }

    @Test
    @DisplayName("Test valid armor type")
    void testValidArmor() {
        test.equipItem(testPlateBody);
        assertEquals(true, !isNull(test.equipment.get(testPlateBody.slot)));
    }

    @Test
    @DisplayName("Test DPS without weapon")
    void testDPSWithoutWeapon() {
        double sampleDPS = 1 * (1 + 5 * 0.01);
        assertEquals(test.dps, sampleDPS, "DPS should be the same.");
    }

    @Test
    @DisplayName("Test DPS with weapon")
    void testDPSWithWeapon() {
        test.equipItem(testWeapon);
        double sampleDPS = 7 * 1.1 * (1 + 5 * 0.01);
        assertEquals(test.dps, sampleDPS, "DPS should be the same.");
    }

    @Test
    @DisplayName("Test DPS with equipment")
    void testDPSWithWeaponAndArmor() {
        test.equipItem(testWeapon);
        test.equipItem(testPlateBody);
        double sampleDPS = 7 * 1.1 * (1 + 6 * 0.01);
        assertEquals(test.dps, sampleDPS, "DPS should be the same.");
    }



}