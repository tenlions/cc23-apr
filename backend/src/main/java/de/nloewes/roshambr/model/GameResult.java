package de.nloewes.roshambr.model;

/**
 * Model class to represent the full outcome of a match, including both player's choices and the result
 *
 * @author nloewes
 */
public class GameResult {

    private PlayerChoice player1Choice;

    private PlayerChoice player2Choice;

    private MatchResult result;

    public GameResult(PlayerChoice player1Choice, PlayerChoice player2Choice, MatchResult result) {
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
        this.result = result;
    }

    public GameResult() {
    }

    public PlayerChoice getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(PlayerChoice player1Choice) {
        this.player1Choice = player1Choice;
    }

    public PlayerChoice getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(PlayerChoice player2Choice) {
        this.player2Choice = player2Choice;
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }
}
