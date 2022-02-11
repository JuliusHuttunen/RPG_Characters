package rpgcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    Ranger test;

    @BeforeEach
    void setUp() {
        test = new Ranger("test");
    }

    @Test
    @DisplayName("Test initial level")
    void testRangerInitLevel() {
        int level = test.level;
        assertEquals(1, level, "Initial level should be 1.");
    }

    @Test
    @DisplayName("Test level up")
    void testRangerGainLevel() {
        test.levelUp();
        int level = test.level;
        assertEquals(2, level, "When gaining a level, the level attribute should +1.");
    }

    @Test
    @DisplayName("Test primary attributes")
    void testRangerAttributes() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(1,7,1);
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }

    @Test
    @DisplayName("Test level up - attributes")
    void testRangerAttributeLevelUp() {
        PrimaryAttribute testAttributes = new PrimaryAttribute(2,12,2);
        test.levelUp();
        assertEquals(testAttributes.strength, test.attributes.strength, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.dexterity, test.attributes.dexterity, "The attributes should correspond to values given in the assignment.");
        assertEquals(testAttributes.intelligence, test.attributes.intelligence, "The attributes should correspond to values given in the assignment.");
    }
}