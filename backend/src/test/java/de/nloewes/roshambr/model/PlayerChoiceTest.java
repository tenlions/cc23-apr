package de.nloewes.roshambr.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class PlayerChoiceTest {

    @Test
    public void testFromString_valid_lowerCase() {
        // GIVEN
        String input = "rock";

        // WHEN
        PlayerChoice choice = PlayerChoice.fromString(input);

        // THEN
        assertEquals(PlayerChoice.ROCK, choice);
    }

    @Test
    public void testFromString_valid_upperCase() {
        // GIVEN
        String input = "ROCK";

        // WHEN
        PlayerChoice choice = PlayerChoice.fromString(input);

        // THEN
        assertEquals(PlayerChoice.ROCK, choice);
    }

    @Test
    public void testFromString_valid_mixedCase() {
        // GIVEN
        String input = "rOcK";

        // WHEN
        PlayerChoice choice = PlayerChoice.fromString(input);

        // THEN
        assertEquals(PlayerChoice.ROCK, choice);
    }

    @Test
    public void testFromString_valid_whitespace() {
        // GIVEN
        String input = "rOcK ";

        // WHEN
        PlayerChoice choice = PlayerChoice.fromString(input);

        // THEN
        assertEquals(PlayerChoice.ROCK, choice);
    }

    @Test
    public void testFromString_invalid() {
        // GIVEN
        String input = "foo";

        //WHEN
        assertThrowsExactly(IllegalArgumentException.class, () -> PlayerChoice.fromString(input));
    }
}
