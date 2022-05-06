import { Component, OnInit } from '@angular/core';
import { Avis } from './avis.module';

@Component({
  selector: 'app-avis',
  templateUrl: './avis.component.html',
  styleUrls: ['./avis.component.scss']
})
export class AvisComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  term: any;
  avisData: Avis[];
  constructor() { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Avis' }, { label: 'Liste des avis', active: true }];
  }

}
