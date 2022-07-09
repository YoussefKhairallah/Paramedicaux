import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { environment } from '../../../environments/environment';
import { AuthService } from '../services/auth/auth.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authServices: AuthService,
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
if(localStorage.length === 0)
{
  this.router.navigate(['/account/login']);
}
        const currentUser = this.authServices.currentUserValue;

        console.log(currentUser.roles[0]);
        if (currentUser) {
            // logged in so return true
            console.log(route.data.roles);
            if (route.data.roles.indexOf(currentUser.roles[0]) === 1) {
                // role not authorised so redirect to home page
                console.log(route.data.roles.indexOf(currentUser.roles));
                this.router.navigate(['/account/login']);
                return false;
            }


            // logged in so return true
            return true;
        }

        // not logged in so redirect to login page with the return url
        this.router.navigate(['/account/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
}
