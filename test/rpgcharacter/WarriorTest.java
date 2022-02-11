package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior testWarrior;
    Weapon orcAxe;

    @BeforeEach
    void setUp() {
      testWarrior = new Warrior("test");
      orcAxe = Items.orcAxe;
    }

    @Test
    @DisplayName("Test damage")
    void testWarriorDamage() {
        double modifier = testWarrior.attributes.strength * 0.01;
        double damageDone = testWarrior.damage + testWarrior.damage * modifier;
        assertEquals(damageDone, 1 + 1 * modifier, "Initial damage should be 1.");
        testWarrior.levelUp();
        modifier = testWarrior.attributes.strength * 0.01;
        damageDone = testWarrior.damage + testWarrior.damage * modifier;
        assertEquals(damageDone, 1 + 1 * modifier, "Damage goes up when leveling.");
        testWarrior.equipItem(orcAxe);
        damageDone = testWarrior.damage + testWarrior.damage * modifier;
        assertEquals(damageDone, orcAxe.damage + orcAxe.damage * modifier, "Damage goes up when equipping a weapon.");
    }

    @Test
    @DisplayName("Ensure that leveling works correctly")
    void levelUp() {
        assertEquals(1, testWarrior.level, "Initial level should be 1.");
    }

    @Test
    void equipWeapon() {
    }

    @Test
    void equipArmor() {
    }

    @Test
    void getAttributes() {
    }

    @Test
    void setAttributes() {
    }
}