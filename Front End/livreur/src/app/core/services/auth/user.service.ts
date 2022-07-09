import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { User } from '../../models/user.model'
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })

};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public catUrl = 'http://localhost:8080/api/users';
  public userUrl = 'http://127.0.0.1:8080/api/auth/signup';

  constructor(private http: HttpClient) { }

  // get all user
  getUsers (): Observable<User[]> {
    return this.http.get<User[]>(this.catUrl).pipe(
      tap(_ => console.log('fetched users')),
      catchError(this.handleError<User[]>('getUsers', []))
    );
  }


  // get categorie by  usersByRole
  getUserByID(id: number): Observable<any> {
    return this.http.get(`${this.catUrl}/${id}`);
  }

  getUserByRole(id: any): Observable<any> {
    return this.http.get(`${this.catUrl}/usersByRole/${id}`);
  }


  // update categorie
  updatecategorie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.catUrl}/${id}`, value);
  }


  deleteuser(id: number): Observable<any> {
    return this.http.delete(`${this.catUrl}/${id}`, { responseType: 'text' });
  }



  // create new categorie
  createuser(user: Object,role:number): Observable<Object> {
    return this.http.post(`${this.catUrl}/${role}`, user);
  }




  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
