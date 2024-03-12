import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { ServerService } from "./service/server.service";

@Injectable()
export class AuthGuard implements CanActivate{

    constructor(private router:Router, private user:ServerService){}


    canActivate(route: ActivatedRouteSnapshot,
                state: RouterStateSnapshot): boolean  | Observable<boolean > | Promise<boolean > {
                    if(this.user.token != null){
                        return true;

                    }else{
                    return this.router.navigate(['/not-found']);
                    }
                    
    }    

}