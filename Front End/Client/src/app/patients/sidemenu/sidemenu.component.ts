import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/models/user.model';

import { CommonServiceService } from './../../common-service.service';

@Component({
  selector: 'app-sidemenu',
  templateUrl: './sidemenu.component.html',
  styleUrls: ['./sidemenu.component.css'],
})
export class SidemenuComponent implements OnInit {
  name: any;
  user: any;
  constructor(
    private router: Router,
    public commonService: CommonServiceService
  ) {}

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('userInfo') || '[]');
  }

  logout() {
    localStorage.clear();
    this.commonService.nextmessage('logout');

    this.router.navigate(['/']);
  }

  navigate(name: any) {
    this.name = name;
    this.commonService.nextmessage(name);
  }
}
