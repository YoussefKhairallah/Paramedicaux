import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Produit } from 'src/app/core/models/produit.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  public prodUrl = 'http://localhost:8080/api';
  constructor(private http: HttpClient) { }
  
  // get all Produits
  getProduits (): Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.prodUrl}/produits`).pipe(
      tap(_ => console.log('fetched produits')),
      catchError(this.handleError<Produit[]>('getProduits', []))
    );
  }
  
  // get produit by id
  getProduitByID(id: number): Observable<any> {
    return this.http.get(`${this.prodUrl}/produits/${id}`);
  }

  
  // update produit
  updateProduit(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.prodUrl}/produits/${id}`, value);
  }

  
  deleteProduit(id: number): Observable<any> {
    return this.http.delete(`${this.prodUrl}/produits/${id}`, { responseType: 'text' });
  }

 

  // create new produit
  createProduit(id: number, produit: Object): Observable<Object> {
    return this.http.post(`${this.prodUrl}/categories/${id}/produits`, produit);
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
