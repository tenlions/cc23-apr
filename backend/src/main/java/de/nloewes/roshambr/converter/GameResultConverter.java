package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.dao.Match;
import de.nloewes.roshambr.model.dto.PlayerChoice;

/**
 * Converter utility class to provide conversion methods from service-layer objects and DAOs related to {@link MatchResult} to DTOs and vice versa
 *
 * @author nloewes
 */
public class GameResultConverter {

    public static de.nloewes.roshambr.model.dto.GameResult toTarget(Match source) {
        de.nloewes.roshambr.model.dto.GameResult  target = new de.nloewes.roshambr.model.dto.GameResult();
        target.setPlayer1Choice(PlayerChoice.valueOf(source.getPlayer1Choice().name()));
        target.setPlayer2Choice(PlayerChoice.valueOf(source.getPlayer2Choice().name()));
        target.setResult(de.nloewes.roshambr.model.dto.MatchResult.valueOf(source.getMatchResult().name()));
        return target;
    }
}
