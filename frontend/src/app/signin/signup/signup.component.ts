import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServerService } from 'src/app/service/server.service';
import { User } from 'src/app/shared/user.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  email:String;
  password:String;
  fullName:String;
  mobileNumber: number;


  constructor( private serverService:ServerService, 
    private router: Router,
){

}

onsignup(){
this.serverService.addUser( new User(0,this.fullName,this.mobileNumber,this.email,this.password,"USER")).subscribe();
this.router.navigate(['/signin']);

}


}
