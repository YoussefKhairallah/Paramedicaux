import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { DetailCommande } from '../../../models/detail-commande.models';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DetailCommandeService {

  public DetCommUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }
  
  // get all DetailCommande
  getDetailCommande (): Observable<DetailCommande[]> {
    return this.http.get<DetailCommande[]>(`${this.DetCommUrl}/detailcommande`).pipe(
      tap(_ => console.log('fetched detailCommandes')),
      catchError(this.handleError<DetailCommande[]>('getDetailCommande', []))
    );
  }
  
  // get detailCommande by id
  getDetailCommandeByID(id: number): Observable<any> {
    return this.http.get(`${this.DetCommUrl}/detailcommande/${id}`);
  }

  
  // update detailCommande
  updateDetailCommande(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.DetCommUrl}/detailcommande/${id}`, value);
  }

  
  deleteDetailCommande(id: number): Observable<any> {
    return this.http.delete(`${this.DetCommUrl}/detailcommande/${id}`, { responseType: 'text' });
  }

 

  // create new detailCommande  /commande/{commandeId}/detailcommande
  createDetailCommande(detailCommande: Object): Observable<Object> {
    return this.http.post(`${this.DetCommUrl}/detailcommande`, detailCommande);
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
