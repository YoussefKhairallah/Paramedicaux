import { Component, OnInit } from '@angular/core';
import { productModel, productList } from '../product.model';
import { HttpClient } from '@angular/common/http';
import { ProduitService } from 'src/app/core/services/Ecommerce/Produit/produit.service';
import { Produit } from 'src/app/core/models/produit.model';
import { Categorie } from 'src/app/core/models/categorie.model';
import Swal from 'sweetalert2';
import { CategorieService } from 'src/app/core/services/Ecommerce/Categorie/categorie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AngularFireStorage } from '@angular/fire/storage';
import { finalize } from 'rxjs/operators';
import { DropzoneConfigInterface } from 'ngx-dropzone-wrapper';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})

/**
 * Ecommerce products component
 */

export class ProductsComponent implements OnInit {
  categories: Categorie[];
  editable = false;
  id: number;
  public produitSearch: Produit []= [];
  produitData: Produit[];
  categoriesData: Categorie[];
  breadCrumbItems: Array<{}>;
  pricevalue = 0;
  minVal = 10;
  maxVal = 500;
  product: any;
  /**
   * Returns form
   */
   get form() {
    return this.productForm.controls;
  }
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

  onAccept(file: any) {
    this.image = file.name;
    this.file = file;
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
  image = '';
  file = '';
  myFiles:string ;
  productForm: FormGroup;
  // Form submition
  submit: boolean;


  log = '';
  discountRates: number[] = [];
  public products: productModel[] = [];
  public productTemp: productModel[] = [];


  constructor(public formBuilder: FormBuilder, private modalService: NgbModal, private http: HttpClient, private prodServices:ProduitService, private categorieServices:CategorieService, private storage: AngularFireStorage, private produitService:ProduitService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Les produits', active: true }];
    this.products = Object.assign([], productList);
    this.getAllCategorie();
    this.getAllProduit();
    this.productForm = this.formBuilder.group({
      nom: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]+')]],
      fournisseur: ['', [Validators.required]],
      prix: ['', [Validators.required]],
      description: ['', [Validators.required]],
      qte: ['', [Validators.required]],
      qteLimite: ['', [Validators.required]],
      categorie: ['', [Validators.required]]

    });
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

  saveProduct(){

    console.log(this.productForm.value);
    if(this.editable)
    {
      let produit = this.productForm.value;
    produit['image'] = this.myFiles;
      this.produitService.updateProduit(this.id,produit)
      .subscribe(res => {
        this.getAllProduit();
        this.modalService.dismissAll();
        this.productForm.reset();
      }, error => {
        error: error = console.error()
      });
    }
    else{let produit = this.productForm.value;
    produit['image'] = this.myFiles;
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
           this.productForm.reset();
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
  }
  openModal(content: any) {
    this.modalService.open(content);
  }
  edit(product,content){
    console.log(product);
    this.productForm.patchValue({
      nom: product.nom,
      fournisseur: product.fournisseur,
      prix: product.prix,
      description: product.description,
      qte: product.qte,
      qteLimite: product.qteLimite,
      categorie: product.categorie,
    });
    this.id = product.id;
    this.editable = true;
    this.modalService.open(content);
  }
  searchFilter(e) {
    const searchStr = e.target.value;
    this.produitSearch = this.produitData.filter((produitSearch) => {
      return produitSearch.nom.toLowerCase().search(searchStr.toLowerCase()) !== -1;
    });
  }

  discountLessFilter(e, percentage) {
    if (e.target.checked && this.discountRates.length === 0) {
      this.products = productList.filter((product) => {
        return product.discount < percentage;
      });
    }
    else {
      this.products = productList.filter((product) => {
        return product.discount >= Math.max.apply(null, this);
      }, this.discountRates);
    }
  }

  discountMoreFilter(e, percentage: number) {
    if (e.target.checked) {
      this.discountRates.push(percentage);
    } else {
      this.discountRates.splice(this.discountRates.indexOf(percentage), 1);
    }
    this.products = productList.filter((product) => {
      return product.discount >= Math.max.apply(null, this);
    }, this.discountRates);
  }

  valueChange(value: number, boundary: boolean): void {
    if (boundary) {
      this.minVal = value;
    } else {
      this.maxVal = value;
      this.products = productList.filter(function (product) {
        return product.disRate <= value && product.disRate >= this;
      }, this.minVal);
    }
  }
  getAllProduit(){
    this.prodServices.getProduits()
    .subscribe(data=>{
      this.produitData=data
      console.log(data)
    })
  }

  getAllCategorie(){
    this.categorieServices.getCategories()
    .subscribe(data=>{
      this.categoriesData=data
      console.log(data)})
  }
  confirmSupp(id: number){
    Swal.fire({
      title: 'Voulez-vous vraiment supprimer ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, supprimez-le !',
      cancelButtonText: 'Non, gardez-le'
    }).then((result) => {
      if (result.value) {
        this.delete(id);
        Swal.fire(
          'Supprimé !',
          'Votre produit a été supprimée.',
          'success'
        )
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Annulé',
          'Votre produit est sécurisée :)',
          'success'
        )
      }
    })
  }

  delete(id: number) {
    this.prodServices.deleteProduit(id).subscribe(data => {
      console.log(data);
      this.getAllProduit();
    }
    );
  }

}
