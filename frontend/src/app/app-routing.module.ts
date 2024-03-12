import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CarDisplayComponent } from "./car-display/car-display.component";
import { SigninComponent } from "./signin/signin.component";
import { AdminBoardComponent } from "./admin-board/admin-board.component";
import { VisitsComponent } from "./admin-board/visits/visits.component";
import { SignupComponent } from "./signin/signup/signup.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { UserBoardComponent } from "./user-board/user-board.component";
import { UserVisitsComponent } from "./user-board/user-visits/user-visits.component";
import { PageNotFoundComponent } from "./page-not-found/page-not-found.component";
import { AuthGuard } from "./auth-guard.service";

const appRoutes: Routes =[
     {path: '', redirectTo:'/home', pathMatch:'full'} ,
     {path: 'home', component:HomePageComponent} ,
        {path:'cars', component: CarDisplayComponent},
        {path: 'signin', component:SigninComponent} ,
        {path: 'signup', component:SignupComponent} ,
        {path: 'admin',canActivate:[AuthGuard],  component:AdminBoardComponent} ,
        {path: 'visits',canActivate:[AuthGuard], component:VisitsComponent} ,
        {path: 'user',canActivate:[AuthGuard],  component:UserBoardComponent} ,
        {path: 'myvisits',canActivate:[AuthGuard],  component:UserVisitsComponent} ,

    {path:'not-found', component:PageNotFoundComponent},
    {path:'**',redirectTo:'/not-found'} // must be at the end of path array
  ];

@NgModule({
    imports:[RouterModule.forRoot(appRoutes)],

    exports:[RouterModule ]
})
export class AppRoutingModule{
    
}