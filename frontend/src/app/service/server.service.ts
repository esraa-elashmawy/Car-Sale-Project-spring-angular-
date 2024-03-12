import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { AuthRequest } from "../shared/AuthRequest.model";
import { User } from "../shared/user.model";
import { catchError, throwError } from "rxjs";

@Injectable()
export class ServerService {
   token:String;
   id:number;
   role:String;

   constructor(private http: HttpClient) { }

   //  getCars():  Observable<any> {
   //     return this.http.get('http://localhost:8080/cars');
   //  }


   // checkUser(email: String, password: String): Observable<any> {
   //    return this.http.get('http://localhost:8080/auth/checkUser/' + email + "/" + password);
   // }
   // checkUserByEmail(email: String): Observable<any> {
   //    return this.http.get('http://localhost:8080/auth/checkUserByEmail/' + email);
   // }


   // removeCar(id: number){
   //    return this.http.delete(`http://localhost:8080/api/car/${id}`);
   // }

   addUser(user: User){
      return this.http.post<void>("http://localhost:8080/auth/addNewUser", user)
   }

   generateToken(request: AuthRequest) {
  //  this.http.post<String[]>('http://localhost:8080/auth/generateToken', request)
   
     return this.http.post<String[]>('http://localhost:8080/auth/generateToken', request).pipe(  catchError(this.handleError))

 //   return this.token
   }

   private handleError(error: HttpErrorResponse) {
      if (error.status === 0 || error.status === 403) {
        // A client-side or network error occurred. Handle it accordingly.
        console.error('An error occurred:', error.error);
      } else {
        // The backend returned an unsuccessful response code.
        // The response body may contain clues as to what went wrong.
        console.error(
          `Backend returned code ${error.status}, body was: `, error.error);
      }
      // Return an observable with a user-facing error message.
      return throwError(() => new Error('Something bad happened; please try again later.'));
    }



}