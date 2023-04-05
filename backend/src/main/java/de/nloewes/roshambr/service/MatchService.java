package de.nloewes.roshambr.service;

import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.model.dao.Match;
import de.nloewes.roshambr.repository.MatchRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class to handle CRUD operations for {@link de.nloewes.roshambr.model.dao.Match} objects
 *
 * @author nloewes
 */
@Component
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    /**
     * Creates and saves a new match based on given player choices and result
     * @param pl1Choice the first player's choice
     * @param pl2Choice the second player's choice
     * @param result the result of the match
     * @return the newly created match entity
     */
    @Timed(value = "matchSave.time", description = "Time taken to create and save a match to the database")
    public Match save(PlayerChoice pl1Choice, PlayerChoice pl2Choice, MatchResult result) {
        Match match = new Match();
        match.setPlayer1Choice(pl1Choice);
        match.setPlayer2Choice(pl2Choice);
        match.setMatchResult(result);

        return matchRepository.save(match);
    }
}
