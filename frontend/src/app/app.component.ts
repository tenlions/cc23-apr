import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import {faHandScissors as faScissors, IconDefinition} from '@fortawesome/free-solid-svg-icons';

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
    computerChoice: PlayerChoice | undefined;
    result: MatchResult | undefined;
    aiResult: GameResult | undefined;
    isLoading = false;

    constructor(private http: HttpClient, private gameResultService: GameResultService) { }

    ngOnInit(): void {
    }

    playGame(playerChoice: PlayerChoice): void {
        this.isLoading = true;
        this.playerChoice = playerChoice;

        /* this.playPost(playerChoice)
        .subscribe((response : ApiGameResult) => {
            this.computerChoice = this.getRandomChoice();
            this.result = response.result;
            this.isLoading = false;

            this.apiResult = response;
            this.playerChoice = this.apiResult.playerChoice;
            this.computerChoice = this.apiResult.apiChoice;
            this.result = this.apiResult.result;
            this.isLoading = false;
        }); */

        this.playApi(playerChoice).subscribe((response: GameResult) => {
            this.result = response.result;
            this.computerChoice = response.player2Choice;

            console.log(this.result);
            console.log(this.computerChoice);

            this.isLoading = false;
        });

        /* this.computerChoice = this.getRandomChoice();
        this.result = playerChoice + " | " + this.computerChoice;
        console.log(this.result); 
        this.isLoading = false; */
    }

    private playApi(choice: PlayerChoice) {
        var turn: PlayerTurn = {playerChoice: choice}
        return this.gameResultService.postMatch({body: turn});
    }

    private getIcon(choice: PlayerChoice): IconDefinition {
        return faScissors;
    }
}