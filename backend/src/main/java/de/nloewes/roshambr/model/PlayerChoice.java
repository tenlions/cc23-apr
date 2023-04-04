package de.nloewes.roshambr.model;

import java.util.Random;

/**
 * Enum to represent the possible turn choices available to either player of a game of rock, paper, scissors
 */
public enum PlayerChoice {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Random random = new Random();

    /**
     * Returns a random entry of this enum
     * @return a random entry of this enum
     */
    public static PlayerChoice getRandomChoice() {
        int index = random.nextInt(PlayerChoice.class.getEnumConstants().length);
        return PlayerChoice.class.getEnumConstants()[index];
    }

    /**
     * Converts a given String to the corresponding GameChoice in case a corresponding entry exists.
     * @param choice the String to convert
     * @return the converted GameChoice
     *
     * @throws IllegalArgumentException if an invalid value was passed
     */
    public static PlayerChoice fromString(String choice) throws IllegalArgumentException {
        return valueOf(choice.replaceAll(" ", "").toUpperCase());
    }
}
