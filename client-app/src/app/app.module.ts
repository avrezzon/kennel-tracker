import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { KennelDisplayComponent } from './kennel-display/kennel-display.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { CheckinComponent } from './checkin/checkin.component';
import { RegisterComponent } from './register/register.component';
import { MessagesComponent } from './messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    KennelDisplayComponent,
    CheckoutComponent,
    CheckinComponent,
    RegisterComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
