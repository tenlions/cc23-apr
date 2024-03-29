package de.nloewes.roshambr.service;

import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.dao.Match;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Main service class to provide and represent the logic of a game of rock, paper, scissors.
 *
 * @author nloewes
 */
@Component
public class GameService {

    private MatchService matchService;

    private Map<PlayerChoice, Counter> cpuChoiceCounters;

    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

    @Autowired
    public void setCpuChoiceCounters(Map<PlayerChoice, Counter> cpuChoiceCounters) {
        this.cpuChoiceCounters = cpuChoiceCounters;
    }

    private static final Logger LOG = LoggerFactory.getLogger(GameService.class);

    /**
     * Plays a game of rock, paper, scissors based on a given {@link PlayerChoice} and returns the match result.
     * The CPU opponent's turn is chosen randomly.
     * <p>
     * After choosing the opponent's turn, the result is calculated abiding the following rules:
     * Rock beats Scissors.
     * Scissors beat Paper.
     * Paper beats Rock.
     * <p>
     * Identical choices result in a draw.
     *
     * @param playerChoice the given {@link PlayerChoice} as input by the player
     * @return the {@link MatchResult} of the match
     */
    @Timed(value = "cpuMatch.time", description = "Time taken to play a match against the CPU")
    public Match playCpuMatch(PlayerChoice playerChoice) {
        LOG.info("Starting new match against CPU. Player choice: {}", playerChoice);

        PlayerChoice cpuChoice = getCpuChoice();
        LOG.info("CPU choice: {}", cpuChoice);

        MatchResult matchResult = calculateResult(playerChoice, cpuChoice);
        LOG.info("Game result: {} ({} x {})", matchResult, playerChoice, cpuChoice);

        return matchService.save(playerChoice, cpuChoice, matchResult);
    }

    /**
     * Calculates the result of a game of rock, paper, scissors based on the given choices of two players.
     * The result is calculated abiding the following rules:
     *      Rock beats Scissors.
     *      Scissors beat Paper.
     *      Paper beats Rock.
     *      Identical choices result in a draw.
     * Marked protected for testing purposes
     *
     * @param player1Choice the choice of the first player
     * @param player2Choice the choice of the second player
     * @return the {@link MatchResult} of the match
     */
    @Timed(value = "calcResult.time", description = "Time taken to calculate the outcome of a match based on 2 choices")
    protected MatchResult calculateResult(PlayerChoice player1Choice, PlayerChoice player2Choice) {
        switch (player1Choice) {
            case ROCK:
                if (PlayerChoice.ROCK.equals(player2Choice)) return MatchResult.DRAW;
                if (PlayerChoice.SCISSORS.equals(player2Choice)) return MatchResult.PLAYER_1_WIN;
                break;
            case PAPER:
                if (PlayerChoice.PAPER.equals(player2Choice)) return MatchResult.DRAW;
                if (PlayerChoice.ROCK.equals(player2Choice)) return MatchResult.PLAYER_1_WIN;
                break;
            case SCISSORS:
                if (PlayerChoice.SCISSORS.equals(player2Choice)) return MatchResult.DRAW;
                if (PlayerChoice.PAPER.equals(player2Choice)) return MatchResult.PLAYER_1_WIN;
                break;
        }

        return MatchResult.PLAYER_2_WIN;
    }

    /**
     * Returns a single, randomly chosen {@link PlayerChoice} for the CPU player
     *
     * @return a random {@link PlayerChoice}
     */
    private PlayerChoice getCpuChoice() {
        PlayerChoice playerChoice = PlayerChoice.getRandomChoice();

        //find metric counter and increment if possible
        Counter counter = cpuChoiceCounters.get(playerChoice);
        if (counter != null) {
            counter.increment();
        }

        return PlayerChoice.getRandomChoice();
    }
}
