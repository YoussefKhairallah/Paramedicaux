import { Component, OnInit, Input } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Commande } from 'src/app/core/models/Commande.model';


@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {


 @Input() transactions: Array<{
  OrdersData: Commande[];
}>;
  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  /**
   * Open modal
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content, { centered: true });
  }

}
