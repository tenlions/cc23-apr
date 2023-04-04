package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.model.GameResult;
import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.dto.PlayerChoice;

/**
 * Converter utility class to provide conversion methods from service-layer objects and DAOs related to {@link MatchResult} to DTOs and vice versa
 *
 * @author nloewes
 */
public class GameResultConverter {

    /**
     * Converts a given {@link MatchResult} to an equivalent {@link de.nloewes.roshambr.model.dto.GameResult}
     * @param source the GameResult to convert
     * @return the converted GameResultResource
     */
    public static de.nloewes.roshambr.model.dto.GameResult toTarget(GameResult source) {
        de.nloewes.roshambr.model.dto.GameResult  target = new de.nloewes.roshambr.model.dto.GameResult();
        target.setPlayer1Choice(PlayerChoice.valueOf(source.getPlayer1Choice().name()));
        target.setPlayer2Choice(PlayerChoice.valueOf(source.getPlayer2Choice().name()));
        target.setResult(de.nloewes.roshambr.model.dto.MatchResult.valueOf(source.getResult().name()));
        return target;
    }
}
