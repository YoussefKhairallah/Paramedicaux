import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Commande } from 'src/app/core/models/Commande.model';
import { DetailCommande } from 'src/app/core/models/detailleCommande.module';

import { User } from 'src/app/core/models/user.model';
import { UserService } from 'src/app/core/services/auth/user.service';

import { CommandeService } from 'src/app/core/services/Ecommerce/Commande/commande.service';
import { DetailCommandeService } from 'src/app/core/services/Ecommerce/DetailCommande/detail-commande.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})

/**
 * Ecommerce orders component
 */
export class OrdersComponent implements OnInit {
  userData: User[];
  // bread crumb items
  breadCrumbItems: Array<{}>;
  term: any;
  OrdersData: Commande[];
  commandeData: DetailCommande[];
  subtotal=0;
  commande: any;
  constructor(private commandeService: CommandeService,private modalService: NgbModal, private userServices: UserService, private detailCommande: DetailCommandeService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Liste des Commandes', active: true }];
      this.getCommande();
      this.getDetailCommande();

  }

  /**
   * Open modal
   * @param content modal content
   */
   openModal(content: any, commande: Object) {
    this.commande = commande;
    console.log('commande id::', commande);
    this.modalService.open(content, { centered: true });
  }
  getCommande(){
    this.commandeService.getCommandes()
    .subscribe(data=>{
      this.OrdersData=data
      console.log("cmd",data)
    })
  }

  /*
  getAllUser(){
    this.userServices.getUsers()
    .subscribe(data =>{
      this.userData= data
      console.log('user::', data)
    })
  }*/

  getDetailCommande(){
    this.detailCommande.getDetailCommande()
    .subscribe(data =>{
      this.commandeData= data
      console.log('Detail Commande:: ', data)
    })
  }

  Annuler(){
    console.log('annule')
    let comm = {};
    comm['etat'] = "Annuler";
    this.commandeService.updateCommande(this.commande.id,comm).subscribe(data=>{
      console.log(data)
      this.modalService.dismissAll();
      this.getCommande();
    });
  }
}
