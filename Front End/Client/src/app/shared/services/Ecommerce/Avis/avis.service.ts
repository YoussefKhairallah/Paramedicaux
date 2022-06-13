import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Avis } from 'src/app/core/models/avis.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AvisService {

  public avisUrl = 'http://localhost:8080/avis';

  constructor(private http: HttpClient) { }
  
  // get all Avis
  getAvis (): Observable<Avis[]> {
    return this.http.get<Avis[]>(this.avisUrl +'/findAvis').pipe(
      tap(_ => console.log('fetched avis')),
      catchError(this.handleError<Avis[]>('getAvis', []))
    );
  }
  
  // get avis by id
  getAvisByID(id: number): Observable<any> {
    return this.http.get(`${this.avisUrl}/findAvisById/${id}`);
  }

  
  // update avis
  updateAvis(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.avisUrl}/${id}`, value);
  }

  
  deleteAvis(id: number): Observable<any> {
    return this.http.delete(`${this.avisUrl}/deleteAvis/${id}`, { responseType: 'text' });
  }

 

  // create new avis
  createAvis(avis: Object): Observable<Object> {
    return this.http.post(`${this.avisUrl}/addAvis`, avis);
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
