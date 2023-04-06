package de.nloewes.roshambr.config;

import de.nloewes.roshambr.model.PlayerChoice;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration class for all beans related to metrics
 *
 * @author nloewes
 */
@Configuration
public class MetricsConfig {

    @Bean
    public TimedAspect timedAspect(MeterRegistry meterRegistry) {
        return new TimedAspect(meterRegistry);
    }

    /**
     * Provides a map of all existing {@link PlayerChoice} to corresponding {@link Counter}s for CPU player choices.
     * Retrieve each counter by key and increment accordingly
     * @param meterRegistry the applications MeterRegistry bean
     * @return a map of all existing {@link PlayerChoice} to corresponding {@link Counter}s for CPU player choices.
     */
    @Bean
    public Map<PlayerChoice, Counter> cpuChoiceCounters(MeterRegistry meterRegistry) {
        List<PlayerChoice> playerChoices = List.of(PlayerChoice.values());
        Map<PlayerChoice, Counter> choiceCounters = new HashMap<>();

        for (PlayerChoice playerChoice : playerChoices) {
            Counter choiceCounter = Counter.builder("cpuPlayer.choices")
                    .tag("PlayerChoice", playerChoice.name())
                    .description("The number of choices made by the CPU per value")
                    .register(meterRegistry);
            choiceCounters.put(playerChoice, choiceCounter);
        }

        return choiceCounters;
    }
}
