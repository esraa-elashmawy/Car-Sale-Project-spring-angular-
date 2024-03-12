import { BehaviorSubject, Observable } from 'rxjs';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Visit } from '../shared/visit.model';
import { ServerService } from './server.service';
import { Injectable } from '@angular/core';

@Injectable()
export class VisitService{
    dayTimeInfo = new BehaviorSubject<string>('');
    carInfo = new BehaviorSubject<number>(0);

    constructor(private http: HttpClient ){}

    postVisit(visit:Visit, auth_token: String) :Observable<any> {
        const headers = new HttpHeaders({
           'Authorization': `Bearer ${auth_token}`
        });
       return this.http.post<Visit>('http://localhost:8080/v/visit',visit, { headers: headers })
     }
  
     getVisits(auth_token: String): Observable<Visit[]>{

        const headers = new HttpHeaders({
           'Authorization': `Bearer ${auth_token}`
        });
         return this.http.get<Visit[]>('http://localhost:8080/v/visit',{ headers: headers });
     }

     getVisitsByBuyer(buyerId:number,auth_token: String): Observable<Visit[]>{
      const headers = new HttpHeaders({
         'Authorization': `Bearer ${auth_token}`
      });
       return this.http.get<Visit[]>(`http://localhost:8080/v/visit/${buyerId}`,{ headers: headers });
   }

}