package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.model.GameResult;
import de.nloewes.roshambr.model.MatchResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameResultConverterTest {

    @Test
    public void testToTarget() {
        // P1 win
        GameResult source = new GameResult(PlayerChoice.PAPER, PlayerChoice.ROCK, MatchResult.PLAYER_1_WIN);
        de.nloewes.roshambr.model.dto.GameResult  target = GameResultConverter.toTarget(source);
        assertEquals(source.getResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());

        // P2 win
        source = new GameResult(PlayerChoice.ROCK, PlayerChoice.PAPER, MatchResult.PLAYER_2_WIN);
        target = GameResultConverter.toTarget(source);
        assertEquals(source.getResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());

        // draw
        source = new GameResult(PlayerChoice.PAPER, PlayerChoice.PAPER, MatchResult.DRAW);
        target = GameResultConverter.toTarget(source);
        assertEquals(source.getResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());
    }
}