package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.dao.Match;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameResultConverterTest {

    @Test
    public void testToTarget() {
        // P1 win
        Match source = new Match();
        source.setPlayer1Choice(PlayerChoice.PAPER);
        source.setPlayer2Choice(PlayerChoice.PAPER);
        source.setMatchResult(MatchResult.PLAYER_1_WIN);

        de.nloewes.roshambr.model.dto.GameResult  target = GameResultConverter.toTarget(source);
        assertEquals(source.getMatchResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());

        // P2 win
        source = new Match();
        source.setPlayer1Choice(PlayerChoice.ROCK);
        source.setPlayer2Choice(PlayerChoice.PAPER);
        source.setMatchResult(MatchResult.PLAYER_2_WIN);

        target = GameResultConverter.toTarget(source);
        assertEquals(source.getMatchResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());

        // draw
        source = new Match();
        source.setPlayer1Choice(PlayerChoice.PAPER);
        source.setPlayer2Choice(PlayerChoice.PAPER);
        source.setMatchResult(MatchResult.DRAW);

        target = GameResultConverter.toTarget(source);
        assertEquals(source.getMatchResult().name(), target.getResult().name());
        assertEquals(source.getPlayer1Choice().name(), target.getPlayer1Choice().name());
        assertEquals(source.getPlayer2Choice().name(), target.getPlayer2Choice().name());
    }
}