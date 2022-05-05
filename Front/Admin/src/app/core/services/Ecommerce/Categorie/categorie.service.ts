import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
const baseUrl = 'http://localhost:8080/categories';
@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient) { }
  /*getAll() {
    return this.http.get<categorie[]>(baseUrl +'/searchcategories');
  }*/
  get(id) {
    return this.http.get(`${baseUrl}/searchcategoriesbyid/${id}`);
  }
  create(data) {
    return this.http.post(baseUrl+'/addcategorie', data);
  }
  update(id, data) {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  delete(id) {
    return this.http.delete(`${baseUrl}/deletecategorie/${id}`);
  }


}
