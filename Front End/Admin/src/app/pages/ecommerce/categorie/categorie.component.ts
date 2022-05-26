import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Categorie } from 'src/app/core/models/categorie.model';
import { CategorieService } from 'src/app/core/services/Ecommerce/Categorie/categorie.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.scss']
})
export class CategorieComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  categorieForm: FormGroup;
  submitted = false;
  term: any;
  categorieData:Array<Categorie> =[]
  router: any;
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private categorieServices: CategorieService, router:Router) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Categorie', active: true }];
    
    this.categorieForm = this.formBuilder.group({
      categorie: ['', [Validators.required]],
    })
    this.getAll();
  }
  get form() {
    return this.categorieForm.controls;
  }
   /**
   * Open modal
   * @param content modal content
   */
    openModal(content: any) {
      this.modalService.open(content);
    }
  
  validSubmit() {
    this.submitted = true;
    const formData = new FormData();
    formData.append('name', this.categorieForm.get('categorie').value);
  }
  confirmSupp(){
    Swal.fire({  
      title: 'Voulez-vous vraiment supprimer ?',   
      icon: 'warning',  
      showCancelButton: true,  
      confirmButtonText: 'Oui, supprimez-le !',  
      cancelButtonText: 'Non, gardez-le'  
    }).then((result) => {  
      if (result.value) {  
        Swal.fire(  
          'Supprimé !',  
          'Votre catégorie a été supprimée.',  
          'success'  
        )  
      } else if (result.dismiss === Swal.DismissReason.cancel) {  
        Swal.fire(  
          'Annulé',  
          'Votre catégorie est sécurisée :)',  
          'error'  
        )  
      }  
    })  
  }
  getAll():void{
    this.categorieServices.getCategories()
    .subscribe(data=>{
      this.categorieData=data
      console.log(data)
    })
  }
  
  saveCategorie(): void {
    this.categorieServices.createcategorie(this.categorieData)
      .subscribe(res => {
        this.router.navigate(['categories'])
      }, error => {
        error: error = console.error()
      });
   }
}
