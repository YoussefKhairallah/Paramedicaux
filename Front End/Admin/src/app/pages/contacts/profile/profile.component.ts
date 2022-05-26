import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/core/services/auth/token-storage.service';
import { ChartType } from './profile.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})

/**
 * Contacts-profile component
 */
export class ProfileComponent implements OnInit {

  breadCrumbItems: Array<{}>;

  revenueBarChart: ChartType;
  statData;

  currentUser: any;
  constructor(private token: TokenStorageService) { }
  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Profile', active: true }];
    this.currentUser = this.token.getUser();
  }
}
/*
// bread crumb items
breadCrumbItems: Array<{}>;

revenueBarChart: ChartType;
statData;
constructor() { }

ngOnInit() {
  this.breadCrumbItems = [{ label: 'Contacts' }, { label: 'Profile', active: true }];

  // fetches the data
  this._fetchData();
}

/**
 * Fetches the data

private _fetchData() {
  this.revenueBarChart = revenueBarChart;
  this.statData = statData;
}
 */