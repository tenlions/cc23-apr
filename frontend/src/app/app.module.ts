import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { GameComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';

import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faHandPaper, faHandScissors, faHandRock } from '@fortawesome/free-solid-svg-icons';

import { ApiModule } from '../../openapi-test/build/api.module';

@NgModule({
  declarations: [
    GameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FontAwesomeModule,
    ApiModule.forRoot({rootUrl: 'http://localhost:8080'})
  ],
  providers: [],
  bootstrap: [GameComponent]
})
export class AppModule { 
  constructor(library: FaIconLibrary) {
    library.addIcons(faHandRock, faHandPaper, faHandScissors)
  }
}
