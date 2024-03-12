import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomePageComponent, HttpLoaderFactory } from './home-page/home-page.component';
import { AdminBoardComponent } from './admin-board/admin-board.component';
import { CarDisplayComponent } from './car-display/car-display.component';
import { ServerService } from './service/server.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';


import { DataViewModule } from 'primeng/dataview';
import { ButtonModule } from 'primeng/button';
import { ToolbarModule } from 'primeng/toolbar';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { DropdownModule } from 'primeng/dropdown';
import { DialogModule } from 'primeng/dialog';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { BrowserAnimationsModule } from'@angular/platform-browser/animations';
import { PanelModule } from 'primeng/panel';
import { SelectButtonModule } from 'primeng/selectbutton';
import { InputNumberModule } from 'primeng/inputnumber';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';


import { SigninComponent } from './signin/signin.component';
import { AppRoutingModule } from './app-routing.module';
import { CarService } from './service/car.service';
import { VisitService } from './service/visit.service';
import { VisitsComponent } from './admin-board/visits/visits.component';
import { SignupComponent } from './signin/signup/signup.component';
import { UserBoardComponent } from './user-board/user-board.component';
import { TranslateLoader, TranslateModule, TranslateService } from '@ngx-translate/core';
import { UserVisitsComponent } from './user-board/user-visits/user-visits.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthGuard } from './auth-guard.service';




@NgModule({
  declarations: [
    AppComponent,
    CarDisplayComponent,
    HomePageComponent,
    AdminBoardComponent,
    SigninComponent,
    VisitsComponent,
    SignupComponent,
    UserBoardComponent,
    UserVisitsComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    

    DataViewModule,
    ButtonModule,
    ToolbarModule,
    TableModule,
    ToastModule,
    DropdownModule,
    DialogModule,
    ConfirmDialogModule,
    BrowserAnimationsModule,
    PanelModule,
    SelectButtonModule,
    InputNumberModule,
    PasswordModule,
    InputTextModule,

    TranslateModule.forRoot({
      loader: {
      provide: TranslateLoader,
      useFactory: HttpLoaderFactory,
      deps: [HttpClient]
      }
      }) 
  ],
  providers: [ServerService, CarService,VisitService,DatePipe,TranslateService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
