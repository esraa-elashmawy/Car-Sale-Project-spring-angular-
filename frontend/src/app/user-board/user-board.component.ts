import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-board',
  templateUrl: './user-board.component.html',
  styleUrls: ['./user-board.component.css']
})
export class UserBoardComponent {

  constructor(    private router: Router) {}

  logOut(){
    sessionStorage.clear();
    this.router.navigate(['/']);
  
  }
}
