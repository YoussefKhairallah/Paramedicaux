import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/pages/ecommerce/categories/categories.model';
import { UserService } from '../user.service';
const baseUrl = 'http://localhost:8080/categories';
@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient, private categorieService: CategorieService, userService: UserService) { }
  getAll(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(`${baseUrl}/searchcategories`);
  }
  /*get(id): Observable<Categorie> {
    return this.http.get(`${baseUrl}/searchcategoriesbyid/${id}`);
  }
  add(data): Observable<any> {
    return this.http.post(baseUrl + '/addcategorie', data);
  }*/
  addcategorie(categorie: Categorie): Observable<Categorie>{
    return this.categorieService.addcategorie(categorie);
  }
  findAll():Observable<Categorie[]>{
    return this.categorieService.findAll();
  }
  delete(id): Observable<any> {
    return this.http.delete(`${baseUrl}/deletecategorie/${id}`);
  }
  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
}
