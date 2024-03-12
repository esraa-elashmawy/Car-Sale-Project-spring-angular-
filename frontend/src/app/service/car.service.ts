import { Observable, Subject } from "rxjs";
import { Car } from "../shared/car.model";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ServerService } from "./server.service";


@Injectable()
export class CarService {
    visitInfo = new Subject<{}>();
    carChanged = new Subject<Car[]>();

    constructor(private http: HttpClient, private serverService: ServerService,
        ) { }
 //   auth_token=this.serverService.token;


    getCars(): Observable<Car[]> {
        return this.http.get<Car[]>('http://localhost:8080/api/car');
    }

    // editCar(car:Car){
    //    return this.http.post<Car>('http://localhost:8080/api/car',car);
    // }

    addCar(car: Car, auth_token: String) {
        const headers = new HttpHeaders({
            'Authorization': `Bearer ${auth_token}`
         });
        return this.http.post<Car>('http://localhost:8080/api/car', car, { headers: headers }).pipe();
    }

    deleteCar(car: number, auth_token: String): Observable<Object> {
        // const httpOptions = {
        //     headers: new HttpHeaders({ 'Content-Type': 'application/json' })
        // };
        const headers = new HttpHeaders({
            'Authorization': `Bearer ${auth_token}`
         });

        console.log("before delete")
     //   return this.http.delete(`http://localhost:8080/api/car/${car}`, { headers: headers });
        return this.http.delete("http://localhost:8080/api/car/"+car+"", { headers: headers });

    }
}