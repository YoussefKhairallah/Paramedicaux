import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CategorieService } from 'src/app/core/services/servicesEcommerce/categorie.service';
import { Categorie } from './categories.model';
import { categorieData } from './data';
@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {
  
  // bread crumb items
  currentCategorie = null;
  message = '';
  breadCrumbItems: Array<{}>;
  formData: FormGroup;
  submitted = false;
  categorieData: Categorie[];
  term: any;

  // page
  currentpage: number;

  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private categorieService: CategorieService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Categories', active: true }];

    this.formData = this.formBuilder.group({
      nom: ['', [Validators.required]],
      
    });

    this.currentpage = 1;

    /**
     * Fetches the data
     */
    this._fetchData();
  }

  /**
   * categorie data fetches
   */
  private _fetchData() {
    this.categorieData = categorieData;
  }
  get form() {
    return this.formData.controls;
  }

  /**
   * Open modal
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content);
  }

 
  updateCategorie(): void{
    this.categorieService.update(this.currentCategorie.id, this.currentCategorie)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'La catégorie a été mise à jour avec succès !';
        },
        error => {
          console.log(error);
        }
      );
  }
  deleteCat(): void{
    this.categorieService.delete(this.currentCategorie.id)
      .subscribe(
        response =>{
          console.log(response);
          this.message = 'La catégorie a été supprime avec succès !';
        },
        error => {
          console.log(error)
        }
      );
  }
}
