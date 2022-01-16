import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';


import {APP_BASE_HREF, PlatformLocation} from '@angular/common';
import {ConciliationmassiveService, MassiveconciliationService,  BASE_PATH as PATH_CONCILIATIONMASIVE } from '@tsir/conciliationmasive-api';
import {EstacionesService , BASE_PATH as PATH_TOLL } from '@tsir/tolls-api';
import {ConciliacinService, BASE_PATH as PATH_CONCILIATION} from '@tsir/conciliation-api';

import {environment} from '../environments/environment';
import { FiltersComponent } from './filters/filters.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

const routes: Routes = [
  // {path: 'whitelist-app/process', component: ProcessWhitelistComponent},
  // {path: 'whitelist-app/consult', component: ConsultWhitelistComponent},
  // {path: 'whitelist-app/monitoring', component: MonitoringWhitelistComponent},
  {path: 'masive-app', component: AppComponent , pathMatch: 'full'},
  {path: 'conciliation-app', component: AppComponent , pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    FiltersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    EstacionesService,
    ConciliationmassiveService,
    MassiveconciliationService,
    ConciliacinService,
    {provide: APP_BASE_HREF, useValue: '/' },
    {provide: PATH_CONCILIATIONMASIVE, useFactory: (pl: PlatformLocation) => GetUrlConciliationMasive(pl), deps: [PlatformLocation]},
    {provide: PATH_TOLL, useFactory: (pl: PlatformLocation) => GetUrlToll(pl), deps: [PlatformLocation]},
    {provide: PATH_CONCILIATION, useFactory: (pl: PlatformLocation) => GetUrlConciliation(pl), deps: [PlatformLocation]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }


const portGateway = 8760;

export function GetUrlConciliationMasive(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/conciliation-masive/api/v1`;
}

export function GetUrlToll(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/tolls-manager/api/v1`;
}

export function GetUrlConciliation(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/conciliation-manager/api/v1`;
}
