import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { User } from 'src/app/core/models/user.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  public catUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }
  
  // get all Users
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.catUrl}/users`).pipe(
      tap(_ => console.log('fetched users')),
      catchError(this.handleError<User[]>('getUsers', []))
    );
  }
  
  // get user by id
  getUserByID(id: number): Observable<any> {
    return this.http.get(`${this.catUrl}/users/${id}`);
  }

  
  // update user
  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.catUrl}/users/${id}`, value);
  }

  //delete user
  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.catUrl}/users/${id}`, { responseType: 'text' });
  }

 
  // create new user
  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.catUrl}/users`, user);
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
