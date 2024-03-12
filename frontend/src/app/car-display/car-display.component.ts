import { Component, OnInit } from '@angular/core';
import { Car } from '../shared/car.model';
import { ServerService } from '../service/server.service';
import { Subscription } from 'rxjs';
import { SelectButtonChangeEvent } from 'primeng/selectbutton';
import { CarService } from '../service/car.service';
import { Visit } from '../shared/visit.model';
import { VisitService } from '../service/visit.service';

@Component({
  selector: 'app-car-display',
  templateUrl: './car-display.component.html',
  styleUrls: ['./car-display.component.css']
})
export class CarDisplayComponent implements OnInit {
  private subscription: Subscription;

  cars: Car[];

  car!: Car;

  newCar:Car;

  carHeader!: string;

  selectedProducts!: Car[] | null;

  submitted: boolean = false;

  sortOrder: number;

  sortField: string;

  layout: string = 'list';

  productDialog: boolean = false;

  days:string[]=["7 oct", "8 oct","9 oct"];
  selectedCity:string;


  res!: number;
  
  currDate= new Date();
  dateDay=this.currDate.getDate();
  dateMonth=this.currDate.getMonth()+1;

  dayOptions: any[] = [
      { name: this.dateMonth+"-"+(this.dateDay), value: 1 },
      { name: this.dateMonth+"-"+(this.dateDay+1), value: 2 },
      { name: this.dateMonth+"-"+(this.dateDay+2), value: 3 }
  ];

  timeOptions: any[] = [
    { name: '11:00', value: 1, constant: false },
    { name: '12:00', value: 2, constant: false },
    { name: '13:00', value: 3 , constant: false}
  ];
  dayChosen=false;
  timeChosen=false;
  book=!(this.timeChosen && this.dayChosen);
  day:string;
  time:string;
  dayTime:string=this.currDate.getFullYear()+"-";


  showTime=false;
  
  constructor(
    private serverService: ServerService,
    private carService: CarService,
    private visitService: VisitService,

  ) { }


  ngOnInit(): void {
    console.log("HELLO WORLD");
    console.log(this.currDate);
    console.log(this.currDate.getDate() +"/"+this.currDate.getMonth());
    

    // this.subscription = this.serverService.getCars().subscribe(
    //   (response) => {
    //     console.log(response)
    //     this.cars = response._embedded.cars
    //     console.log(this.cars);
    //   }
    //   ,
    //   (err) => console.log(err)
    // );

    this.subscription = this.carService.getCars().subscribe(
      (response) => {
        console.log(response)
        this.cars = response        
        console.log(this.cars);
      } , (err) => console.log(err) );
  }



viewCarDetails( car: Car){
  this.car = { ...car };
  this.productDialog = true;
  this.carHeader= this.car.brand +"- "+this.car.model ;


}


choseDay(val:SelectButtonChangeEvent){
  this.dayChosen=val.value;
  this.book=!(this.timeChosen && this.dayChosen);

  console.log(val.value +"---"+ this.dayChosen)
  for (const option of this.dayOptions) {
    if (option.value === val.value) {
      this.day=option.name;
      console.log( option.name);
    }
  }
  this.showTime=true;
}

choseTime(val:SelectButtonChangeEvent){
  this.timeChosen=val.value;
  this.book=!(this.timeChosen && this.dayChosen);

  console.log(val.value +"---"+ this.timeChosen)
  for (const option of this.timeOptions) {
    if (option.value === val.value) {
      this.time=option.name;
      console.log( option.name);
    }
  }

}



bookVisit(){
  // post/visit but must have date-time , buyer_id, car_id (this.car)
  //day=option.name time= option.name
  
  this.dayTime+= this.day+" "+this.time;
  // this day-
  console.log(this.dayTime)
  this.visitService.dayTimeInfo.next(this.dayTime);
  this.visitService.carInfo.next(this.car.car_id);


  }

}
