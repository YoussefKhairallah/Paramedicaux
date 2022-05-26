import { Component, OnInit } from '@angular/core';
import { Commande } from 'src/app/core/models/Commande.model';
import { CommandeService } from 'src/app/core/services/Ecommerce/Commande/commande.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})

/**
 * Ecommerce orders component
 */
export class OrdersComponent implements OnInit {

  // bread crumb items
  breadCrumbItems: Array<{}>;
  term: any;
  transactions;
  commandeData: Array<Commande> = [];
  constructor(private commandeService: CommandeService) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Liste des Commandes', active: true }];
    this.transactions = [
      {
        id: '#SK2540',
        name: 'Neal Matthews',
        date: '07 Oct, 2019',
        total: '$400',
        status: 'Paid',
        payment: ['fab fa-cc-mastercard', 'Mastercard'],
        index: 1,
      }]
      this.getCommande()
  }


  getCommande(){
    this.commandeService.getCommandes()
    .subscribe(data=>{
      this.commandeData=data
      console.log(data)
    })
  }
}
