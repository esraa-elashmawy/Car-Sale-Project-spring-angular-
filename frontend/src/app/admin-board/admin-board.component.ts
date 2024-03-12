import { Component, OnInit } from '@angular/core';
import { Car, carType } from '../shared/car.model';
import { ServerService } from '../service/server.service';
import { Observable, catchError, of } from 'rxjs';
import { ConfirmationService, MessageService } from 'primeng/api';
import { CarService } from '../service/car.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-admin-board',
  templateUrl: './admin-board.component.html',
  styleUrls: ['./admin-board.component.css'],
  providers:[MessageService,ConfirmationService]
})
export class AdminBoardComponent implements OnInit {
  cars:Car[];
  selectedCar=Car;
  selectedCars!: Car[] | null;
  productDialog: boolean = false;
  productsDialog:boolean=false;
 // car:Car;
  submitted: boolean;
  editedCar!:Car ;
  carType=["Automatic","Manual"];
  //selectedType:carType;
  newCar:boolean;  




  constructor(    private serverService: ServerService, private carService: CarService,  private router: Router,
     private translateService: TranslateService, private route: ActivatedRoute,
    private messageService: MessageService, private confirmationService: ConfirmationService) {}


  ngOnInit() {
    this.getAllCars()
    this.editedCar = new Car(0,"","",0,0,0,"",0,"");

  }

getAllCars(){
  this.carService.getCars( ).subscribe(
    (response: Car[]) => {
      console.log("ngOninit")
      console.log(response);
      
      this.cars = response   
    });
}
  
openNew() {
  this.newCar=true;
  this.editedCar = new Car(0,"","",0,0,0,"",0,);
  this.submitted = false;
  this.productDialog = true;
}


  editProduct(car:Car){
   // this.car=car;
    this.productDialog=true;
    this.editedCar={ ...car};
  }

  // deleteProduct(car:Car):void{
  //   console.log(car)

  //   this.serverService.deleteCar(car.car_id).subscribe({
  //     next:data=>{
  //       this.getAllCars();
  //     }
  //   })

  // }

  deleteCar(car:Car): void{
   console.log(car.car_id)
  this.carService.deleteCar(car.car_id, this.serverService.token+"").subscribe({
    next:data=>{
      this.getAllCars();
    }
  })
  //   this.confirmationService.confirm({
  //     message: 'Are you sure you want to delete ? ',
  //     header: 'Confirm',
  //     icon: 'pi pi-exclamation-triangle',
  //     accept: () => {
  //         //this.products = this.products.filter((val) => val.id !== product.id);
  //        // this.product = {};
  //        this.carService.deleteCar(car.car_id, this.serverService.token+"").subscribe({
  //         next:data=>{
  //           this.getAllCars();
  //         }
  //       })
  //         this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Car Deleted', life: 3000 });
  //     }
  // });
  }

  saveProduct(){
    console.log(this.editedCar);

    this.carService.addCar(this.editedCar, this.serverService.token+"")
    .subscribe(
      (response2) => { 
      console.log("RESPONSE2: "+response2);
      this.productDialog=false;
      this.getAllCars();
      if(this.newCar){
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Car Created', life: 3000 });
        this.newCar=false;
      }else{
       this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Car Updated', life: 3000 });
      }  
    }, error =>{
      this.messageService.add({ severity: 'error', summary: `Error: ${error.error.message}`, detail: 'fill in all values from sub', life: 3000 });
    }
   );

  }
  

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
    this.newCar=false;
}

logOut(){
  sessionStorage.clear();
  this.router.navigate(['/']);

}

changeLangage(lang: string) {
  console.log("change language")
// this.translateService.setDefaultLang(lang);
this.translateService.use(lang);
}

onAddCar( form:NgForm){
  const value= form.value
  console.log(form);

  console.log(this.editedCar);

  if(form.valid){
      this.carService.addCar(this.editedCar, this.serverService.token+"")
      .subscribe(
        (response2) => { 
        console.log("RESPONSE2: "+response2);
        this.productDialog=false;
        this.getAllCars();
        if(this.newCar){
          this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Car Created', life: 3000 });
          this.newCar=false;
        }else{
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Car Updated', life: 3000 });
        }  
      }, error =>{
        this.messageService.add({ severity: 'error', summary: `Error: ${error.error.message}`, detail: 'fill in all values ', life: 3000 });
      }
    );
  }else{
    this.messageService.add({ severity: 'error', summary: `Error: all fields are required`, detail: 'fill in all values', life: 3000 });
  }


}

goToVisits(){
  this.router.navigate(['visits'], { relativeTo: this.route });
}

}



