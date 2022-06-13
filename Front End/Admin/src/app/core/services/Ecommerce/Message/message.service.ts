import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Message } from 'src/app/core/models/message.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  public msgUrl = 'http://localhost:8080/api/message';

  constructor(private http: HttpClient) { }
  
  // get all Messages
  getMessages (): Observable<Message[]> {
    return this.http.get<Message[]>(this.msgUrl).pipe(
      tap(_ => console.log('fetched produits')),
      catchError(this.handleError<Message[]>('getMessages', []))
    );
  }
  
  // get message by id
  getMessageByID(id: number): Observable<any> {
    return this.http.get(`${this.msgUrl}/${id}`);
  }

  
  // update message
  updateMessage(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.msgUrl}/${id}`, value);
  }

  
  deleteMessage(id: number): Observable<any> {
    return this.http.delete(`${this.msgUrl}/${id}`, { responseType: 'text' });
  }

 

  // create new message
  createMessage(message: Object): Observable<Object> {
    return this.http.post(this.msgUrl, message);
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
