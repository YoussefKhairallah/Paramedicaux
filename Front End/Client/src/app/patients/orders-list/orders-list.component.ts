import { Component, OnInit } from '@angular/core';
import { CommandeService } from '../../shared/services/Ecommerce/Commande/commande.service';
import { Commande } from '../../shared/models/Commande.model';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {
  orders!: Commande[];

  constructor(private cmdService: CommandeService) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders(){
    this.cmdService.getCommandes().subscribe(
      data => {
        console.log(data);
        this.orders = data;
      },
      error => {
        console.log(error);
      }
    );
  }

}
