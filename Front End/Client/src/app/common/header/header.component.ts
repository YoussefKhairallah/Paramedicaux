import {
  Component,
  OnInit,
  ChangeDetectorRef,
  AfterViewInit,
  Inject,
} from '@angular/core';
import {
  Event,
  NavigationStart,
  Router,
  ActivatedRoute,
  NavigationEnd,
} from '@angular/router';
import { DOCUMENT } from '@angular/common';

import { CommonServiceService } from './../../common-service.service';
import * as AOS from 'aos';
import { CategorieService } from '../../shared/services/Ecommerce/Categorie/categorie.service';
import { Categorie } from '../../shared/models/categorie.model';
import { AuthService } from '../../shared/services/auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  auth: boolean = false;
  comrytmenu: boolean = true;
  isPatient: boolean = false;
  comlogo: boolean = true;
  whitelogo: boolean = false;
  pharmcart: boolean = false;
  page:any;
  splitVal:any;
  headerTop: boolean = false;
  admin_submenu: boolean = true;
  admin_menu: boolean = false;
  categorieData:Array<Categorie> =[]

  base:any;
  url1:any;
  $menuItem!: JQuery<HTMLElement>;
  user: any;
  constructor(
    private categorieServices: CategorieService,
    private cdr: ChangeDetectorRef,
    public router: Router,
    private activeRoute: ActivatedRoute,
    public commonService: CommonServiceService,
    private authService: AuthService
  ) {
    router.events.subscribe((event: Event) => {
      
    });
    this.url1 = this.router.url;
    this.commonService.message.subscribe((res) => {
      if (res === 'patientLogin') {
        this.auth = true;
        console.log("result",res)
        // this.isPatient = true;
      }
      if (res === 'doctorLogin') {
        this.auth = true;
        // this.isPatient = false;
      }

      if (res === 'logout') {
        this.auth = false;
        this.isPatient = false;
      }
    });
  }

  getAll():void{
    this.categorieServices.getCategories()
    .subscribe(data=>{
      this.categorieData=data
      console.log('categorieData',data)
    })
  }

  ngOnInit(): void {
    this.getAll();
    this.auth = this.authService.isLoggedIn;
    this.user = JSON.parse(localStorage.getItem('userInfo') || '[]');

    AOS.init({
      duration: 1200,
		  once: true,
    });
    // Sidebar
	
	if((window.innerWidth) <= 991){
    var Sidemenu = () => {
      this.$menuItem = $('.main-nav a');
    };
    $("#cart").on("click", function(o) {
      o.preventDefault();
     $(".shopping-cart").fadeToggle();
     $(".shopping-cart").toggleClass('show-cart');
   });
    
      var $this = Sidemenu;
      $('.main-nav a').on('click', function(e) {
        if($(this).parent().hasClass('has-submenu')) {
          e.preventDefault();
        }
        if(!$(this).hasClass('submenu')) {
          $('ul', $(this).parents('ul:first')).slideUp(350);
          $('a', $(this).parents('ul:first')).removeClass('submenu');
          $(this).next('ul').slideDown(350);
          $(this).addClass('submenu');
        } else if($(this).hasClass('submenu')) {
          $(this).removeClass('submenu');
          $(this).next('ul').slideUp(350);
        }
      });
    
  
    
    }
    

    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd) {
        $('html').removeClass('menu-opened');
        $('.sidebar-overlay').removeClass('opened');
        $('.main-wrapper').removeClass('slide-nav');
      }
    });
    
        $(window).scroll(function(){
        var scroll = window.pageYOffset;
          if (scroll > 95) {
          $(".header-trans").css("background" , "#FFFFFF");
          }
  
          else{
            $(".header-trans").css("background" , "transparent");  	
          }
          if (scroll > 95) {
            $(".header-trans.custom").css("background" , "#2b6ccb");
            }
    
            else{
              $(".header-trans.custom").css("background" , "transparent");  	
            }
        })
  }

  ngAfterViewInit() {
    this.cdr.detectChanges();
  }
 
  change(name:any) {
    this.page = name;
    this.commonService.nextmessage('main');
  }

  logout() {
    localStorage.clear();
    this.auth = false;
    this.isPatient = false;
    this.commonService.nextmessage('logout');
    this.router.navigate(['/login']);
  }

  home() {
    this.commonService.nextmessage('main');
    this.router.navigateByUrl('/').then(() => {
      this.router.navigate(['/']);
    });
  }

  navigate(name:any) {
    this.page = name;
    if (name === 'Admin') {
      this.router.navigate(['/admin']);
      this.commonService.nextmessage('admin');
    } else if (name === 'Pharmacy Admin') {
      this.router.navigate(['/pharmacy-admin']);
      this.commonService.nextmessage('pharmacy-admin');
    }
  }
}
