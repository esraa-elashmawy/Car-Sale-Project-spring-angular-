import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServerService } from 'src/app/service/server.service';
import { VisitService } from 'src/app/service/visit.service';
import { Visit } from 'src/app/shared/visit.model';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})
export class VisitsComponent {

  products!: Visit[];
  dateTime: Date;

  constructor(private serverService: ServerService, private visitService: VisitService,private datePipe: DatePipe,   private router: Router,
    ) {}

  ngOnInit() {
    console.log(this.serverService.token+"");
    
    this.visitService.getVisits(this.serverService.token+"").subscribe((data) => {
        this.products = data;
    });
    


  }

  transformDate(date: Date) {
    this.datePipe.transform(date, 'yyyy-MM-dd'); //whatever format you need. 
  }
  
  logOut(){
    sessionStorage.clear();
    this.router.navigate(['/']);
  }

}
