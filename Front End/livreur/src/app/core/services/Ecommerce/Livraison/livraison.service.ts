import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Livraison } from 'src/app/core/models/livraison.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class LivraisonService {

  public livUrl = 'http://localhost:8080/api/livraison';

  constructor(private http: HttpClient) { }
  
  // get all Livraisons
  getLivraisons (): Observable<Livraison[]> {
    return this.http.get<Livraison[]>(this.livUrl).pipe(
      tap(_ => console.log('fetched produits')),
      catchError(this.handleError<Livraison[]>('getLivraisons', []))
    );
  }
  
  // get produit by id
  getLivraisonByID(id: number): Observable<any> {
    return this.http.get(`${this.livUrl}/${id}`);
  }

  
  // update produit
  updateLivraison(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.livUrl}/${id}`, value);
  }

  
  deleteLivraison(id: number): Observable<any> {
    return this.http.delete(`${this.livUrl}/${id}`, { responseType: 'text' });
  }

 

  // create new produit
  createLivraison(livraison: Object): Observable<Object> {
    return this.http.post(this.livUrl, livraison);
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
