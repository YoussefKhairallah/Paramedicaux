import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { DropzoneConfigInterface } from 'ngx-dropzone-wrapper';
import { Produit } from '../products/produit.module';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.scss']
})

/**
 * Ecommerce add-product component
 */
export class AddproductComponent implements OnInit {

  constructor(public formBuilder: FormBuilder, private http: HttpClient) { }
  /**
   * Returns form
   */
  get form() {
    return this.productForm.controls;
  }

  productForm: FormGroup;

  // bread crumb items
  breadCrumbItems: Array<{}>;
  // Form submition
  submit: boolean;
  config: DropzoneConfigInterface = {
    // Change this to your upload POST address:
    maxFilesize: 50,
    acceptedFiles: 'image/*',
    method: 'POST',
    uploadMultiple: false,
    accept: (file) => {
      this.onAccept(file);
    }
  };
  image = '';
  file = '';
  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Ajouter un produit', active: true }];

    this.productForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]+')]],
      fournisseur: ['', [Validators.required]],
      categorie: ['', [Validators.required]],
      price: ['', [Validators.required], Validators.pattern('[0123456789.]')],
      productdesc: ['', [Validators.required]],
      quantiteProd: ['', [Validators.required]]

    });
    this.submit = false;
  }

  onAccept(file: any) {
    this.image = file.name;
    this.file = file;
  }
  /**
   * Bootsrap validation form submit method
   */
  validSubmit() {
    this.submit = true;
    const formData = new FormData();
    formData.append('name', this.productForm.get('name').value);
    formData.append('fournisseur', this.productForm.get('fournisseur').value);
    formData.append('categorie', this.productForm.get('categorie').value);
    formData.append('productdesc', this.productForm.get('productdesc').value);
    formData.append('price', this.productForm.get('price').value);
    formData.append('quantiteProd', this.productForm.get('quantiteProd').value);
    formData.append('image', this.file, this.image);

    this.http.post<Produit>(`http://localhost:8080/produit/AddProduit`, formData)
      .subscribe((data) => {
        return data;
      });
  }
}
