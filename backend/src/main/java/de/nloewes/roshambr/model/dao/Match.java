package de.nloewes.roshambr.model.dao;

import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.PlayerChoice;
import jakarta.persistence.*;

/**
 * Basic entity to represent the properties and outcome of a match between 2 players
 *
 * @author nloewes
 */
@Entity
@Table(name = "game")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "player_1_choice", nullable = false)
    private PlayerChoice player1Choice;

    @Column(name = "player_2_choice", nullable = false)
    private PlayerChoice player2Choice;

    @Column(name = "match_result", nullable = false)
    private MatchResult matchResult;

    public String getId() {
        return id;
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

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }
}
