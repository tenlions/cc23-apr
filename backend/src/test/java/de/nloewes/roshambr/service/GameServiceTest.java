package de.nloewes.roshambr.service;

import de.nloewes.roshambr.model.GameChoice;
import de.nloewes.roshambr.model.MatchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    public void testCalculateResult_draw_rock() {
        // GIVEN
        GameChoice player1Choice = GameChoice.ROCK;
        GameChoice player2Choice = GameChoice.ROCK;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_draw_paper() {
        // GIVEN
        GameChoice player1Choice = GameChoice.PAPER;
        GameChoice player2Choice = GameChoice.PAPER;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_draw_scissors() {
        // GIVEN
        GameChoice player1Choice = GameChoice.SCISSORS;
        GameChoice player2Choice = GameChoice.SCISSORS;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_win_rock() {
        // GIVEN
        GameChoice player1Choice = GameChoice.ROCK;
        GameChoice player2Choice = GameChoice.SCISSORS;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testCalculateResult_win_paper() {
        // GIVEN
        GameChoice player1Choice = GameChoice.PAPER;
        GameChoice player2Choice = GameChoice.ROCK;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testCalculateResult_win_scissors() {
        // GIVEN
        GameChoice player1Choice = GameChoice.SCISSORS;
        GameChoice player2Choice = GameChoice.PAPER;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testPlayCpuMatch_rock() {
        // GIVEN
        GameChoice player1Choice = GameChoice.ROCK;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }

    @Test
    public void testPlayCpuMatch_paper() {
        // GIVEN
        GameChoice player1Choice = GameChoice.PAPER;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }

    @Test
    public void testPlayCpuMatch_scissors() {
        // GIVEN
        GameChoice player1Choice = GameChoice.SCISSORS;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }
}
