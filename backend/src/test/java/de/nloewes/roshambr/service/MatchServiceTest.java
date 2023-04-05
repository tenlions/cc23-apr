package de.nloewes.roshambr.service;

import de.nloewes.roshambr.model.MatchResult;
import de.nloewes.roshambr.model.PlayerChoice;
import de.nloewes.roshambr.repository.MatchRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MatchServiceTest {

    @InjectMocks
    private MatchService matchService = new MatchService();

    @Mock
    private MatchRepository matchRepository;

    @BeforeAll
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave_invokesRepository() {
        // GIVEN
        PlayerChoice player1Choice = PlayerChoice.ROCK;
        PlayerChoice player2Choice = PlayerChoice.ROCK;
        MatchResult matchResult = MatchResult.DRAW;

        // WHEN
        matchService.save(player1Choice, player2Choice, matchResult);

        // THEN
        Mockito.verify(matchRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
