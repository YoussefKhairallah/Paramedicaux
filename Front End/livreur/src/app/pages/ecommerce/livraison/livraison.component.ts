import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { LivraisonService } from 'src/app/core/services/Ecommerce/Livraison/livraison.service';
import { Livraison } from 'src/app/core/models/livraison.model';

@Component({
  selector: 'app-livraison',
  templateUrl: './livraison.component.html',
  styleUrls: ['./livraison.component.scss']
})
export class LivraisonComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  livraisonForm: FormGroup;
  livraisonData: Array <Livraison> = [];
  term: any;
  router: any;
  submitted = false;
  constructor(private modalService: NgbModal, private formBuilder: FormBuilder, private livraisonServices:LivraisonService) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Livraison', active: true }];
    this.livraisonForm = this.formBuilder.group({
      IdCommande: ['', [Validators.required]],
      Idlivreur: ['', [Validators.required]],
      societe: ['', [Validators.required]],
      client: ['', [Validators.required]],
      livraison: ['', [Validators.required]],
      jour: ['', [Validators.required]],
      etat: ['', [Validators.required]],
    })
    this.getAll();
  }

  get form() {
    return this.livraisonForm.controls;
  }
  getAll(){
    this.livraisonServices.getLivraisons()
    .subscribe(data=>{
      this.livraisonData=data
      console.log(data)
    })
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
      formData.append('name', this.livraisonForm.get('IdCommande').value);
      formData.append('name', this.livraisonForm.get('Idlivreur').value);
      formData.append('name', this.livraisonForm.get('societe').value);
      formData.append('name', this.livraisonForm.get('client').value);
      formData.append('name', this.livraisonForm.get('livraison').value);
      formData.append('name', this.livraisonForm.get('jour').value);
      formData.append('name', this.livraisonForm.get('etat').value);
      
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
    saveLivraison(): void {
      this.livraisonServices.createLivraison(this.livraisonData)
        .subscribe(res => {
          this.router.navigate(['categories'])
        }, error => {
          error: error = console.error()
        });
     }
}
