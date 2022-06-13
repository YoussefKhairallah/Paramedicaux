import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Commande } from 'src/app/shared/models/Commande.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  public prodUrl = 'http://localhost:8080/api/commande';

  constructor(private http: HttpClient) { }
  
  // get all Commandes
  getCommandes (): Observable<Commande[]> {
    return this.http.get<Commande[]>(this.prodUrl).pipe(
      tap(_ => console.log('fetched commande')),
      catchError(this.handleError<Commande[]>('getCommandes', []))
    );
  }
  
  // get Commande by id
  getCommandeByID(id: number): Observable<any> {
    return this.http.get(`${this.prodUrl}/${id}`);
  }

  
  // update Commande
  updateCommande(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.prodUrl}/${id}`, value);
  }

  
  deleteCommande(id: number): Observable<any> {
    return this.http.delete(`${this.prodUrl}/${id}`, { responseType: 'text' });
  }

 

  // create new Commande
  createCommande(Commande: Object): Observable<Object> {
    return this.http.post(`${this.prodUrl}`, Commande);
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
