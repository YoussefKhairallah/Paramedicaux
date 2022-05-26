import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Categorie } from 'src/app/core/models/categorie.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }, )
};

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  public catUrl = 'http://localhost:8080/categories';

  constructor(private http: HttpClient) { }
  
  // get all categories
  getCategories (): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(this.catUrl +'/findcategories').pipe(
      tap(_ => console.log('fetched categories')),
      catchError(this.handleError<Categorie[]>('getCategories', []))
    );
  }
  
  // get categorie by id
  getCategorieByID(id: number): Observable<any> {
    return this.http.get(`${this.catUrl}/findcategoriesbyid/${id}`);
  }

  
  // update categorie
  updatecategorie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.catUrl}/${id}`, value);
  }

  // Delete categorie
  deletecategorie(id: number): Observable<any> {
    return this.http.delete(`${this.catUrl}/deletecategorie/${id}`, { responseType: 'text' });
  }

 

  // create new categorie
  createcategorie(categorie: Object): Observable<Object> {
    return this.http.post(`${this.catUrl}/addcategorie`, categorie);
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