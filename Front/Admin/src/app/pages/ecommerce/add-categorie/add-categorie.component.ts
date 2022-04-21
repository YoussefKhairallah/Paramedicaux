import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Command } from 'protractor';
import { CategorieService } from 'src/app/core/services/servicesEcommerce/categorie.service';
import { Categorie } from '../categories/categories.model';

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent implements OnInit {
  
  categories: Categorie;
  errorMsg: Array<String> = [];
  categorieForm: FormGroup;
  // bread crumb items
  breadCrumbItems: Array<{}>;
  // Form submition
  submit: boolean;

  constructor(private formBuilder: FormBuilder, private router: Router, private categorieService: CategorieService) { }
  
  get form() {
    return this.categorieForm.controls;
  }
  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Add Categorie', active: true }];

    this.categorieForm = this.formBuilder.group({
      name: ['', [Validators.required]]
    });
    this.submit = false;
  }
  /**
   * Bootsrap validation form submit method
   */
   validSubmit() {
    this.submit = true;
    const formData = new FormData();
    formData.append('name', this.categorieForm.get('name').value);
  }
  cancel(): void{
    this.router.navigate(Command['categories']);
  }
  enregistreCategorie(): void{
    this.categorieService.addcategorie(this.categories)
      .subscribe(res=> {
        this.router.navigate(Command['categories']);
      },error => {
        this.errorMsg = error.error.errors;
      })
  }
}
