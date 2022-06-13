import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { DropzoneConfigInterface } from 'ngx-dropzone-wrapper';

import { ProduitService } from 'src/app/core/services/Ecommerce/Produit/produit.service';
import Swal from 'sweetalert2';
import { CategorieService } from '../../../core/services/Ecommerce/Categorie/categorie.service';
import { Categorie } from '../../../core/models/categorie.model';

import { finalize } from 'rxjs/operators';
import { AngularFireStorage } from '@angular/fire/storage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.scss']
})

/**
 * Ecommerce add-product component
 */
export class AddproductComponent implements OnInit {
  categories: Categorie[];


  constructor(public formBuilder: FormBuilder, private http: HttpClient, private produitService:ProduitService
    , private categorieServices: CategorieService, private storage: AngularFireStorage,
    private router: Router) { }
  /**
   * Returns form
   */
  get form() {
    return this.productForm.controls;
  }

  myFiles:string ;
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
      this.upload(file);
    }
  };
  image = '';
  file = '';
  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Ajouter un produit', active: true }];

    this.productForm = this.formBuilder.group({
      nom: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]+')]],
      fournisseur: ['', [Validators.required]],
      prix: ['', [Validators.required]],
      description: ['', [Validators.required]],
      qte: ['', [Validators.required]],
      qteLimite: ['', [Validators.required]],
      categorie: ['', [Validators.required]]

    });
    this.submit = false;
    this.getAllCategories();
  }

  onAccept(file: any) {
    this.image = file.name;
    this.file = file;
  }
  validSubmit() {
    this.submit = true;
    const formData = new FormData();
    formData.append('nom', this.productForm.get('nom').value);
    formData.append('nom', this.productForm.get('fournisseur').value);
    formData.append('nom', this.productForm.get('prix').value);
    formData.append('nom', this.productForm.get('description').value);
    formData.append('nom', this.productForm.get('qte').value);
    formData.append('nom', this.productForm.get('qteLimite').value);
    formData.append('nom', this.productForm.get('categorie').value);
  }
  /**
   * Bootsrap validation form submit method
   */
  /* */
  saveProduct(){
    let produit = this.productForm.value;
    produit['image'] = this.myFiles;
    produit.categorie = parseInt(produit.categorie);
    console.log('id::', produit.categorie,produit);
      this.produitService.createProduit(produit.categorie, produit)
       .subscribe({
         next: (res) => {
           Swal.fire({
             position: 'top-end',
             title: 'Merci...',
             text: 'Le produit a éte ajoute avec succes!',
             icon: 'success'
           });
           this.router.navigate(['/ecommerce/products']);
         },
           error:() => {
             Swal.fire({
               position: 'top-end',
               icon: 'error',
               title: 'Oops...',
               text: "il y a un erreur avec l'ajout!!"
             })
           }
       });
   }

   getAllCategories():void{
    this.categorieServices.getCategories()
    .subscribe(data=>{
      this.categories=data
      console.log(data)
    })
  }

  onFileChange(event:any) {
   
    this.upload(event.target.files[0]);
        console.log(event.target.files[0].name)
    console.log(this.myFiles);
  }


  upload(fileUpload) {
    const path = `/images/${fileUpload.name}`;
    console.log(path);
    const storageReference = this.storage.ref('/images/' + fileUpload.name);
    console.log(storageReference);
    const uploadTask = this.storage.upload(path,(fileUpload));
    uploadTask.snapshotChanges().pipe(
      finalize(() => {
        storageReference.getDownloadURL().subscribe(downloadURL => {
         
          //this.publicationForm.controls.photo.setValue(downloadURL);
          //fileUpload.name = fileUpload.file.name;
          console.log(downloadURL);
          this.myFiles = downloadURL;
        });
      })
    ).subscribe();
  }
}


