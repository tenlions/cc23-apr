package de.nloewes.roshambr.api;

import de.nloewes.roshambr.converter.PlayerTurnConverter;
import de.nloewes.roshambr.converter.GameResultConverter;
import de.nloewes.roshambr.model.dto.GameResult;
import de.nloewes.roshambr.model.dto.PlayerTurn;
import de.nloewes.roshambr.service.GameService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayApiImpl implements PlayApiDelegate {

    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @Timed(value = "postMatch.time", description = "Time taken to fulfill a POST request for a match")
    @Override
    public ResponseEntity<GameResult> postMatch(PlayerTurn playerTurn) {
        de.nloewes.roshambr.model.PlayerChoice remoteChoice = PlayerTurnConverter.toSource(playerTurn);

        de.nloewes.roshambr.model.GameResult result = gameService.playCpuMatch(remoteChoice);

        GameResult resultDto = GameResultConverter.toTarget(result);

        return new ResponseEntity<>(resultDto, HttpStatusCode.valueOf(200));
    }
}
