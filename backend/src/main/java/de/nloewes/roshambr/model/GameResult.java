package de.nloewes.roshambr.model;

/**
 * Model class to represent the full outcome of a match, including both player's choices and the result
 *
 * @author nloewes
 */
public class GameResult {

    private GameChoice player1Choice;

    private GameChoice player2Choice;

    private MatchResult result;

    public GameResult(GameChoice player1Choice, GameChoice player2Choice, MatchResult result) {
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
        this.result = result;
    }

    public GameResult() {
    }

    public GameChoice getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(GameChoice player1Choice) {
        this.player1Choice = player1Choice;
    }

    public GameChoice getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(GameChoice player2Choice) {
        this.player2Choice = player2Choice;
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }
}
