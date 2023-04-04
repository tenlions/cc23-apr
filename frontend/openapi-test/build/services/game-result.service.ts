/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { GameChoice } from '../models/game-choice';
import { GameResult } from '../models/game-result';

@Injectable({
  providedIn: 'root',
})
export class GameResultService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation postMatch
   */
  static readonly PostMatchPath = '/play/cpu';

  /**
   * Play a match of rock, paper, scissors against the CPU.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `postMatch()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postMatch$Response(params: {

    /**
     * The choice made by the player
     */
    body: GameChoice
  },
  context?: HttpContext

): Observable<StrictHttpResponse<GameResult>> {

    const rb = new RequestBuilder(this.rootUrl, GameResultService.PostMatchPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<GameResult>;
      })
    );
  }

  /**
   * Play a match of rock, paper, scissors against the CPU.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `postMatch$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postMatch(params: {

    /**
     * The choice made by the player
     */
    body: GameChoice
  },
  context?: HttpContext

): Observable<GameResult> {

    return this.postMatch$Response(params,context).pipe(
      map((r: StrictHttpResponse<GameResult>) => r.body as GameResult)
    );
  }

}
