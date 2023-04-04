package de.nloewes.roshambr.converter;

import de.nloewes.roshambr.exception.InvalidChoiceException;
import de.nloewes.roshambr.model.PlayerChoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converter utility class to provide conversion methods from service-layer objects and DAOs related to {@link PlayerChoice} to DTOs and vice versa
 *
 * @author nloewes
 */
public class PlayerTurnConverter {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerTurnConverter.class);

    /**
     * Converts a given {@link de.nloewes.roshambr.model.dto.PlayerTurn} to a corresponding {@link PlayerChoice}
     * @param target the GameChoiceResource to convert
     * @return the converted GameChoice
     */
    public static PlayerChoice toSource(de.nloewes.roshambr.model.dto.PlayerTurn target) {
        try {
            return PlayerChoice.fromString(target.getPlayerChoice());
        } catch (IllegalArgumentException ex) {
            LOG.error("Unsupported GameChoice '{}' encountered", target.getPlayerChoice(), ex);
            throw new InvalidChoiceException(target.getPlayerChoice());
        }
    }
}
