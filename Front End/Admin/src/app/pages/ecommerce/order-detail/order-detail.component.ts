import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Commande } from 'src/app/core/models/Commande.model';
import { DetailCommande } from 'src/app/core/models/detailleCommande.module';
import { CommandeService } from 'src/app/core/services/Ecommerce/Commande/commande.service';
import { DetailCommandeService } from 'src/app/core/services/Ecommerce/DetailCommande/detail-commande.service';
import { ActivatedRoute } from '@angular/router';
import { LivraisonService } from 'src/app/core/services/Ecommerce/Livraison/livraison.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.scss']
})
export class OrderDetailComponent implements OnInit {
  OrdersData: Commande[];
  commandeData: any[]=[];
  commande: any;
  id:number;
  constructor(private commandeService: CommandeService,private modalService: NgbModal, private detailCommandeServices: DetailCommandeService,
     private actRouter: ActivatedRoute,
     private livraisonServices: LivraisonService) { }

  ngOnInit(): void {
    this.id = parseInt(this.actRouter.snapshot.paramMap.get("id"));
    this.getdetailCommandeId(this.id);
    this.getAllCommande();
    //this.getCommandeByid(this.id);
  }
  getAllCommande(){
    this.commandeService.getCommandes()
    .subscribe( data => {
      this.OrdersData = data
      console.log('All Commande::',data);
    })
  }

  getdetailCommandeId(id: number){
  this.detailCommandeServices.getDetailCommande()
  .subscribe(data => {
    this.commandeData =  data;
    this.commandeData = this.commandeData.filter(data => data.commande.id == id)
    console.log(this.commandeData);
  })
}
  /*getCommandeByid(id: number){
    this.commandeService.getCommandeByID(id)
    .subscribe(data =>{
      this.OrdersData = data
      console.log('id commande:: ', data)
    })
  }*/
  Annuler(){
    console.log('annule')
    let comm = {};
    comm['etat'] = "Annuler";
    this.commandeService.updateCommande(this.commande.id,comm).subscribe(data=>{
      console.log(data)
      this.modalService.dismissAll();
      this.getAllCommande();
    });
  }
  
  confirm(){
    console.log('confirm')
    let comm = {};
    comm['etat'] = "confirmer";
    this.commandeService.updateCommande(this.commande.id,comm).subscribe(data=>{
      console.log(data)
      this.modalService.dismissAll();
      this.addlivraison();
      Swal.fire(  
        'Confirmation!',  
        'Votre commande a été confirmer.',  
        'success'  
      )  
    });
  }

  addlivraison(){
    this.livraisonServices.createLivraison(this.commande).subscribe(data =>{
      console.log(data)
      this.modalService.dismissAll();
    });
  }

  
}


