package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.exception.InvalidChoiceException;
import de.nloewes.roshambr.model.PlayerChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTurnConverterTest {

    @Test
    public void testToSource_valid_rock() {
        // GIVEN
        de.nloewes.roshambr.model.dto.PlayerTurn target = new de.nloewes.roshambr.model.dto.PlayerTurn();
        target.setPlayerChoice("ROCK");

        // WHEN
        PlayerChoice source = PlayerTurnConverter.toSource(target);

        // THEN
        assertEquals(PlayerChoice.ROCK, source);
    }

    @Test
    public void testToSource_valid_paper() {
        // GIVEN
        de.nloewes.roshambr.model.dto.PlayerTurn target = new de.nloewes.roshambr.model.dto.PlayerTurn();
        target.setPlayerChoice("PAPER");

        // WHEN
        PlayerChoice source = PlayerTurnConverter.toSource(target);

        // THEN
        assertEquals(PlayerChoice.PAPER, source);
    }

    @Test
    public void testToSource_valid_scissors() {
        // GIVEN
        de.nloewes.roshambr.model.dto.PlayerTurn target = new de.nloewes.roshambr.model.dto.PlayerTurn();
        target.setPlayerChoice("SCISSORS");

        // WHEN
        PlayerChoice source = PlayerTurnConverter.toSource(target);

        // THEN
        assertEquals(PlayerChoice.SCISSORS, source);
    }

    @Test
    public void testToSource_invalid() {
        // GIVEN
        de.nloewes.roshambr.model.dto.PlayerTurn target = new de.nloewes.roshambr.model.dto.PlayerTurn();
        target.setPlayerChoice("foo");

        // WHEN
        assertThrowsExactly(InvalidChoiceException.class, () -> PlayerTurnConverter.toSource(target));
    }
}