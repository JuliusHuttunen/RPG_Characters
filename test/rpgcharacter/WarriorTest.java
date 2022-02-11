package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior test;
    Weapon orcAxe;

    @BeforeEach
    void setUp() {
      test = new Warrior("test");
    }

    @Test
    @DisplayName("Test initial level")
    void testWarriorInitLevel() {
        int level = test.level;
        assertEquals(1, level, "Initial level should be 1.");
    }

    @Test
    @DisplayName("Test level up")
    void testWarriorGainLevel() {
        test.levelUp();
        int level = test.level;
        assertEquals(2, level, "When gaining a level, the level attribute should +1.");
    }

    @Test
    @DisplayName("Test primary attributes")
    void testWarriorAttributes() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(5,2,1);
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }

    @Test
    @DisplayName("Test level up - attributes")
    void testWarriorAttributeLevelUp() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(8,4,2);
        test.levelUp();
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }

}