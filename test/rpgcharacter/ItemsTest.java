package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    void testWeaponLevelException() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testWeaponLvl2);
    }

    @Test
    @DisplayName("Test armor levelException")
    void testArmorLevelException() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testPlateBodyLvl2);
    }

    @Test
    @DisplayName("Test invalid weapon type")
    void testInvalidWeaponException() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testBow);
    }

    @Test
    @DisplayName("Test invalid armor type")
    void testInvalidArmorException() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testClothHead);
    }

    @Test
    @DisplayName("Test valid weapon type")
    void testValidWeapon() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testWeapon);
        assertEquals(true, !isNull(test.equipment.get(Item.Slot.WEAPON)));
    }

    @Test
    @DisplayName("Test valid armor type")
    void testValidArmor() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
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
    void testDPSWithWeapon() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testWeapon);
        double sampleDPS = 7 * 1.1 * (1 + 5 * 0.01);
        assertEquals(test.dps, sampleDPS, "DPS should be the same.");
    }

    @Test
    @DisplayName("Test DPS with equipment")
    void testDPSWithWeaponAndArmor() throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {
        test.equipItem(testWeapon);
        test.equipItem(testPlateBody);
        double sampleDPS = 7 * 1.1 * (1 + 6 * 0.01);
        assertEquals(test.dps, sampleDPS, "DPS should be the same.");
    }



}