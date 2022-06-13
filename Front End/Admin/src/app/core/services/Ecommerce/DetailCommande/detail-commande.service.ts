import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { DetailCommande } from 'src/app/core/models/detailleCommande.module';
@Injectable({
  providedIn: 'root'
})
export class DetailCommandeService {
  public DetCommUrl = 'http://localhost:8080/api/detailcommande';

  constructor(private http: HttpClient) { }
  
  // get all DetailCommande
  getDetailCommande (): Observable<DetailCommande[]> {
    return this.http.get<DetailCommande[]>(this.DetCommUrl).pipe(
      tap(_ => console.log('fetched detailCommandes')),
      catchError(this.handleError<DetailCommande[]>('getDetailCommande', []))
    );
  }
  
  // get detailCommande by id
  getDetailCommandeByID(id: number): Observable<any> {
    return this.http.get(`${this.DetCommUrl}/${id}`);
  }

  
  // update detailCommande
  updateDetailCommande(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.DetCommUrl}/${id}`, value);
  }

  
  deleteDetailCommande(id: number): Observable<any> {
    return this.http.delete(`${this.DetCommUrl}/${id}`, { responseType: 'text' });
  }

 

  // create new detailCommande
  createDetailCommande(detailCommande: Object): Observable<Object> {
    return this.http.post(this.DetCommUrl, detailCommande);
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
