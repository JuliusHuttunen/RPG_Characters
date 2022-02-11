package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    Mage test;

    @BeforeEach
    void setUp() {
        test = new Mage("test");
    }

    @Test
    @DisplayName("Test initial level")
    void testMageInitLevel() {
        int level = test.level;
        assertEquals(1, level, "Initial level should be 1.");
    }

    @Test
    @DisplayName("Test level up")
    void testMageGainLevel() {
        test.levelUp();
        int level = test.level;
        assertEquals(2, level, "When gaining a level, the level attribute should +1.");
    }

    @Test
    @DisplayName("Test primary attributes")
    void testMageAttributes() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(1,1,8);
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }

    @Test
    @DisplayName("Test level up - attributes")
    void testMageAttributeLevelUp() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(2,2,13);
        test.levelUp();
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }
}