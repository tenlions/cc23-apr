import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';

import {faHandScissors as faScissors, IconDefinition} from '@fortawesome/free-solid-svg-icons';

import { GameResultService } from '../../openapi-test/build/services/game-result.service';

enum GameChoice {
    ROCK = 'ROCK',
    PAPER = 'PAPER',
    SCISSORS = 'SCISSORS'
}

interface GameResult {
    result: string;
}

interface ApiGameResult {
    playerChoice: GameChoice;
    apiChoice: GameChoice;
    result: string;
}

@Component({
    selector: 'app-game',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class GameComponent implements OnInit {
    GameChoice = GameChoice;

    playerChoice: GameChoice | undefined;
    computerChoice: GameChoice | undefined;
    result: string | undefined;
    apiResult: ApiGameResult | undefined;
    isLoading = false;

    constructor(private http: HttpClient, private gameResultService: GameResultService) { }

    ngOnInit(): void {
    }

    playGame(playerChoice: GameChoice): void {
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

        this.computerChoice = this.getRandomChoice();
        this.result = playerChoice + " | " + this.computerChoice;
        console.log(this.result); 
        this.isLoading = false;
    }

    private getRandomChoice(): GameChoice {
        const choices = [GameChoice.ROCK, GameChoice.PAPER, GameChoice.SCISSORS];
        const index = Math.floor(Math.random() * 3);
        return choices[index];
    }

    private playPost(playerChoice: GameChoice) {
        return this.http.post<ApiGameResult>('/api/play', playerChoice);
    }

    private getIcon(choice: GameChoice): IconDefinition {
        return faScissors;
    }
}