package de.nloewes.roshambr.service;

import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.model.MatchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    public void testCalculateResult_draw_rock() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.ROCK;
        PlayerChoice player2Choice = PlayerChoice.ROCK;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_draw_paper() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.PAPER;
        PlayerChoice player2Choice = PlayerChoice.PAPER;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_draw_scissors() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.SCISSORS;
        PlayerChoice player2Choice = PlayerChoice.SCISSORS;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.DRAW, result);
    }

    @Test
    public void testCalculateResult_win_rock() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.ROCK;
        PlayerChoice player2Choice = PlayerChoice.SCISSORS;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testCalculateResult_win_paper() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.PAPER;
        PlayerChoice player2Choice = PlayerChoice.ROCK;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testCalculateResult_win_scissors() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.SCISSORS;
        PlayerChoice player2Choice = PlayerChoice.PAPER;

        // WHEN
        MatchResult result = gameService.calculateResult(player1Choice, player2Choice);

        // THEN
        Assertions.assertEquals(MatchResult.PLAYER_1_WIN, result);
    }

    @Test
    public void testPlayCpuMatch_rock() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.ROCK;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }

    @Test
    public void testPlayCpuMatch_paper() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.PAPER;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }

    @Test
    public void testPlayCpuMatch_scissors() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.SCISSORS;

        // WHEN
        gameService.playCpuMatch(player1Choice);

        // THEN
    }
}
