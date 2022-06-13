import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Produit } from '../../../models/produit.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  public prodUrl = 'http://localhost:8080/api/produits';

  constructor(private http: HttpClient) { }
  
  // get all Produits
  getProduits (): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.prodUrl).pipe(
      tap(_ => console.log('fetched produits')),
      catchError(this.handleError<Produit[]>('getProduits', []))
    );
  }
  
  // get produit by id
  getProduitByID(id: number): Observable<any> {
    return this.http.get(`${this.prodUrl}/${id}`);
  }

  getProduitsByCategories(id: number): Observable<any> {
    return this.http.get(`http://localhost:8080/api/categories/${id}/produits`);
  }

  
  // update produit
  updateProduit(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.prodUrl}/${id}`, value);
  }

  
  deleteProduit(id: number): Observable<any> {
    return this.http.delete(`${this.prodUrl}/${id}`, { responseType: 'text' });
  }

 

  // create new produit
  createProduit(produit: Object): Observable<Object> {
    return this.http.post(`${this.prodUrl}`, produit);
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
