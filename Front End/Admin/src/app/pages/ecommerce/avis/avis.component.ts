import { Component, OnInit } from '@angular/core';
import { AvisService } from 'src/app/core/services/Ecommerce/Avis/avis.service';
import { Avis } from '../../../core/models/avis.model';

@Component({
  selector: 'app-avis',
  templateUrl: './avis.component.html',
  styleUrls: ['./avis.component.scss']
})
export class AvisComponent implements OnInit {
  breadCrumbItems: Array<{}>;
  term: any;
  avisData: Avis[];
  constructor(private avisServices: AvisService) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Avis' }, { label: 'Liste des avis', active: true }];
    this.getAllAvis();
  }
  getAllAvis(){
    this.avisServices.getAvis()
    .subscribe(data=>{
      this.avisData=data
      console.log(data)
    })
  }
}
