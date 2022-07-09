import { Component, OnInit } from '@angular/core';

import { listData } from './data';

import { InvoiceList } from './list.model';
import { CommandeService } from '../../../core/services/Ecommerce/Commande/commande.service';
import { Commande } from '../../../core/models/Commande.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})

/**
 * Invoices list component
 */
export class ListComponent implements OnInit {

  // bread crumb items
  breadCrumbItems: Array<{}>;
  OrdersData: Commande[];
  listData: InvoiceList[];

  constructor(private commandeService: CommandeService,) { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Factures' }, { label: 'Liste des factures', active: true }];

    /**
     * fetches the data
     */
    this.getAllCommande();
  }

  getAllCommande(){
    this.commandeService.getCommandes()
    .subscribe( data => {
      this.OrdersData = data
      console.log('All Commande::',data);
    })
  }

  /**
   * fetches the invoice list data
   */
  private _fetchData() {
    this.listData = listData;
  }
}
