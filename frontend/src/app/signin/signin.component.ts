import { Component } from '@angular/core';
import { ServerService } from '../service/server.service';
import { VisitService } from '../service/visit.service';
import { Visit } from '../shared/visit.model';
import { Car } from '../shared/car.model';
import { User } from '../shared/user.model';
import { Router } from '@angular/router';
import { AuthRequest } from '../shared/AuthRequest.model';
import { MessageService } from 'primeng/api';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
  providers:[MessageService]

})
export class SigninComponent {
  email:string;
  password:string;
  daytime:Date;
  car:Car;
  buyer: User;
  

  constructor(
    private serverService: ServerService,
    private visitService: VisitService,
    private router: Router,
    private messageService: MessageService
  ) { }


  // onSignup(){
  //   console.log(this.email);
  //   console.log(this.password);
  //   const req: AuthRequest = new AuthRequest(this.email, this.password)
  //   this.serverService.generateToken(req).subscribe(
  //     (response)=>{console.log('response'); console.log(response)}
  //   )
  
  //   // makes sure user is in database
  //    this.serverService.checkUser(this.email, this.password).subscribe(
  //     (response) => {
  //       console.log(response);
  //       if(response === null){
  //         console.log("PRINT ERROR MESSAGE");
  //       }else{
  //         // redirect and populate the visit table (date_time, buyer_id,car_id)
  //         // show pop up message that visit has been booked
  //         if(response.role === 'Buyer'){
  //           this.router.navigate(['/']);
  //           this.visitService.carInfo.subscribe(
  //             (val:number)=>{
  //             //console.log("CAR INFO"+val)
  //             this.car= new Car(val,"","",0,0,0,"",0,"");
  //             });

  //           this.visitService.dayTimeInfo.subscribe(
  //             (val:string)=>{
  //             //console.log("DAYTIME"+val)
  //             this.daytime=new Date(val);
  //             });
  //           this.buyer= new User(response.user_id,"",0,"",0);
  //           const visit= new Visit(0,this.daytime,this.car, this.buyer);
  //           this.serverService.postVisit(visit).subscribe(
  //           // (response2) => { console.log("RESPONSE2: "+response2);}
  //             );
  //         }else{
  //           this.router.navigate(['/admin']);

  //         }

  //       }
  //     } ,(err) => console.log(err)
  //   );

  // }


  onLogin(){
    const req: AuthRequest = new AuthRequest(this.email, this.password)
    this.serverService.generateToken(req).subscribe(
      (response)=>{
        // console.log(response)
        // console.log(response.at(0)) // token
        // console.log(response.at(1)) // role- i guess not needed
         console.log(response.at(2)) // user_id
        this.serverService.token=response.at(0)+"";
        this.serverService.role=response.at(1)+"";
        this.serverService.id=+(response.at(2)+"");

       
      if(response.at(1) ==="[USER]"){
     //   this.router.navigate(['/']);
      this.router.navigate(['/user']);
        this.visitService.carInfo.subscribe(
          (val:number)=>{
          //console.log("CAR INFO"+val)
          this.car= new Car(val,"","",0,0,0,"",0,"");
          });

        this.visitService.dayTimeInfo.subscribe(
          (val:string)=>{
          //console.log("DAYTIME"+val)
          this.daytime=new Date(val);
          });
        this.buyer= new User(Number(response.at(2)),"",0,"","","");
        const visit= new Visit(0,this.daytime,this.car, this.buyer);
        this.visitService.postVisit(visit, response.at(0)+"").subscribe(
        // (response2) => { console.log("RESPONSE2: "+response2);}
          );
      }else{
        this.router.navigate(['/admin']);
      }
      
      },(err) =>     this.messageService.add({ severity: 'error', summary: 'Try Again', detail: 'Password Or Username are inccorect', life: 3000 })
      )
  }

}
