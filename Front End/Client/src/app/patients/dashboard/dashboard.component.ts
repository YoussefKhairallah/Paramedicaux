import { Component, OnInit } from '@angular/core';
import * as ApexCharts from 'apexcharts';
import { ApexAxisChartSeries, ApexChart, ApexXAxis, ApexStroke, ApexDataLabels, ApexGrid, ApexTitleSubtitle } from 'ng-apexcharts';
import {CommonServiceService  } from './../../common-service.service';

export type ChartOptions = {
  series: ApexAxisChartSeries | any;
  chart: ApexChart | any;
  xaxis: ApexXAxis | any;
  stroke: ApexStroke | any;
  dataLabels: ApexDataLabels | any;
  colors: string[] | any;
  grid: ApexGrid | any;
  title: ApexTitleSubtitle | any;
};

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  appointments:any ;
  patients:any ;
  public bmichartOptions: ChartOptions = {
    series: [
      {
        name: "Desktops",
        data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
      }
    ],
    chart: {
      height: 350,
      type: "line",
      zoom: {
        enabled: false
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      curve: "straight"
    },
    title: {
      text: "Product Trends by Month",
      align: "left"
    },
    grid: {
      row: {
        colors: ["#f3f3f3", "transparent"],
        opacity: 0.5
      }
    },
    xaxis: {
      categories: [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep"
      ]
    },
    colors: ['#03a4fb']
  };

  constructor(public commonService:CommonServiceService) { }

  ngOnInit(): void {
    
    this.getPatients();
    this.getAppointments();
      var chart = new ApexCharts(document.querySelector('#bmi-status'),
      this.bmichartOptions
      );
    chart.render();
  }

  getAppointments() {
    this.commonService.getAppointments()
      .subscribe(res=>{
        
        this.appointments = res;
        let scope = this;
        this.appointments.forEach((index:any)=>{
          let filter = scope.patients.filter((a:any)=>a.key === index.patient_key);
          if(filter.length != 0) {
            index['patients'] = filter[0];
          }
        })
       
      })
  }

  getPatients() {
    this.commonService.getpatients()
    .subscribe(res=>{
      this.patients = res;
    })
  }


 
}
