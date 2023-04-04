import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {faHandScissors as faScissors, faHandRock as faRock, faHandPaper as faPaper, faQuestion as faQuestion, IconDefinition} from '@fortawesome/free-solid-svg-icons';

import { GameResultService } from '../../openapi-test/build/services/game-result.service';
import { GameResult } from '../../openapi-test/build/models/game-result';
import { PlayerChoice } from 'openapi-test/build/models';
import { MatchResult } from 'openapi-test/build/models';
import { PlayerTurn } from 'openapi-test/build/models';

@Component({
    selector: 'app-game',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class GameComponent implements OnInit {
    title = 'RoshambrFrontend';
    PlayerChoice = PlayerChoice;

    playerChoice: PlayerChoice | undefined;
    playerSelection: PlayerChoice | undefined;

    computerChoice: PlayerChoice | undefined;
    computerSelection: PlayerChoice | undefined;

    result: MatchResult | undefined;
    isLoading = false;

    playerScore = 0;
    apiScore = 0;
    turnResult: string | undefined;

    playerIcon = faQuestion;
    apiIcon = faQuestion;

    faRock = faRock;
    faPaper = faPaper;
    faScissors = faScissors;

    constructor(private http: HttpClient, private gameResultService: GameResultService) { }

    ngOnInit(): void {
    }

    /**
     * Main function to play a simple game of rock-paper-scissors against an API and update the properties of this component accordingly
     * @param playerChoice a PlayerChoice to use for the round of RPS
     */
    playGame(playerChoice: PlayerChoice): void {
        this.isLoading = true;
        this.playerChoice = playerChoice;

        this.playApi(playerChoice).subscribe((response: GameResult) => {
            this.result = response.result;
            this.computerChoice = response.player2Choice;
            this.processResult(response);

            this.playerSelection = this.playerChoice;
            this.computerSelection = this.computerChoice;

            this.playerChoice = undefined;
            this.computerChoice = undefined;
            this.isLoading = false;
        });
    }

    /**
     * Takes a given PlayerChoice and uses it to send a request via the GameResultService
     * @param choice the choice to use for the request
     * @returns an Observable of <GameResult>
     */
    private playApi(choice: PlayerChoice) {
        var turn: PlayerTurn = {playerChoice: choice}
        return this.gameResultService.postMatch({body: turn});
    }

    /**
     * Processes a given GameResult, updating the associated properties 
     * @param result the GameResult based on which we want to update
     */
    private processResult(result: GameResult): void {
        if (result.result == MatchResult.Player1Win) {
            this.playerScore++;
            this.turnResult = 'YOU WIN!';
        } else if (result.result == MatchResult.Player2Win) {
            this.apiScore++;
            this.turnResult = 'API WINS!';
        } else {
            this.turnResult = 'DRAW!';
        }

        this.playerIcon = this.getIcon(result.player1Choice);
        this.apiIcon = this.getIcon(result.player2Choice);
    }   

    /**
     * Takes a given PlayerChoice and returns the corresponding IconDefinition
     * @param choice the given PlayerChoice
     * @returns the IconDefinition associated with the PlayerChoice
     */
    private getIcon(choice: PlayerChoice): IconDefinition {
        if (choice == PlayerChoice.Rock) {
            return faRock;
        } else if (choice == PlayerChoice.Paper) {
            return faPaper;
        } else {
            return faScissors;
        }
    }
}