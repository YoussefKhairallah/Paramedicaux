import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authfackservice: AuthService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
            // add authorization header with jwt accessToken- if available
            const currentUser = this.authfackservice.currentUserValue;
            console.log(currentUser);
            if (currentUser && currentUser.accessToken) {
                console.log(currentUser.accessToken);
                request = request.clone({
                    setHeaders: {
                        Authorization: `Bearer ${currentUser.accessToken}`
                    }
                });
            }
        
        return next.handle(request);
    }
}
