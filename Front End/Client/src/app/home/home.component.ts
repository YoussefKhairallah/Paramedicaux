import { Component, OnInit, ViewEncapsulation, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { CommonServiceService } from '../common-service.service';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { SlickCarouselComponent } from 'ngx-slick-carousel';
import { ProduitService } from '../shared/services/Ecommerce/Produit/produit.service';
import { Produit } from '../shared/models/produit.model';
import Swal from 'sweetalert2';
import { DetailCommande } from '../shared/models/detail-commande.models';
declare const $: any;

export interface Doctors {
  id: number;
  doctor_name: string;
  speciality: string;
  Education: string;
  location: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  // encapsulation : ViewEncapsulation.None
})
export class HomeComponent implements OnInit {
  @ViewChild('slickModal1')
  slickModal1!: SlickCarouselComponent;
  @ViewChild('slickModal2')
  slickModal2!: SlickCarouselComponent;
  @ViewChild('slickModal3')
  slickModal3!: SlickCarouselComponent;
  specialityList: any = [];
  doctors: any = [];
  slidepage: any;
  employeeCtrl = new FormControl();
  filteredEmployee: Observable<Doctors[]>;
  blogs: any = [];
  keyword = 'name';
  searchDoctor = [];
  produitData: Array<Produit> = [];
  public countries = [
    {
      id: 1,
      name: 'Albania',
      img: 'image',
    },
    {
      id: 2,
      name: 'Belgium',
    },
    {
      id: 3,
      name: 'Denmark',
    },
    {
      id: 4,
      name: 'Montenegro',
    },
    {
      id: 5,
      name: 'Turkey',
    },
    {
      id: 6,
      name: 'Ukraine',
    },
    {
      id: 7,
      name: 'Macedonia',
    },
    {
      id: 8,
      name: 'Slovenia',
    },
    {
      id: 9,
      name: 'Georgia',
    },
    {
      id: 10,
      name: 'India',
    },
    {
      id: 11,
      name: 'Russia',
    },
    {
      id: 12,
      name: 'Switzerland',
    },
  ];

  cartItems: DetailCommande[]=[];
  error = false;
  exists: boolean =false;
  article!: Produit;
  quantity: number = 1;
  i!: number;
  key!: number;
  oldquantite: any;

  constructor(
    public router: Router,
    public commonService: CommonServiceService, private prodServices:ProduitService
  ) {
    this.filteredEmployee = this.employeeCtrl.valueChanges.pipe(
      startWith(''),
      map((employee) =>
        employee ? this._filterEmployees(employee) : this.doctors.slice()
      )
    );
  }

  ngOnInit() {
    window.scrollTo(0, 0);
    this.getAllProduit();

    // User's voice slider
    $('.testi-slider').each( () => {
      var $show = $(this).data('show');
      var $arr = $(this).data('arrow');
      var $dots = !$arr;
      var $m_show = $show;
      if ($show == 3) $m_show = $show - 1;
      $(this).slick({
        slidesToShow: $show,
        slidesToScroll: 1,
        arrows: $arr,
        autoplay: false,
        autoplaySpeed: 6000,
        adaptiveHeight: true,
        prevArrow:
          '<button type="button" class="prev-nav"><i class="icon ion-ios-arrow-back"></i></button>',
        nextArrow:
          '<button type="button" class="next-nav"><i class="icon ion-ios-arrow-forward"></i></button>',
        responsive: [
          {
            breakpoint: 991,
            settings: {
              slidesToShow: $m_show,
              slidesToScroll: 1,
              infinite: true,
              arrows: $arr,
              dots: $dots,
            },
          },
          {
            breakpoint: 767,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1,
              arrows: false,
              dots: true,
            },
          },
          {
            breakpoint: 480,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1,
              arrows: false,
              dots: true,
            },
          },
        ],
      });
    });
  }
  //Get All Produits
  getAllProduit(){
    this.prodServices.getProduits()
    .subscribe(data=>{
      this.produitData=data
      console.log(data)
    })
  }

  //Add to cart
  addToCart(){
    /*
    let product :DetailCommande = {} as DetailCommande;
    //product = this.article;
    product.qte = this.quantity;
    product.total = parseInt(this.article.prix) * this.quantity;
    product.id_produit = this.article;
    console.log('product',product);
    this.cartItems.push(product);
    localStorage.setItem('cartItems',JSON.stringify(this.cartItems));
    */
    console.log(this.exists);
    //alert('Your product has been added to the cart!');
    if(this.quantity > this.article.qte || this.quantity < 1){
      this.error = true;
    }
    
      this.i = 0;
      this.cartItems.filter(pro  => {
        console.log(pro);
        if(pro.produit.id == this.article!.id){
          this.exists = true;
          this.oldquantite = pro.qte;
          this.key = this.i;
          this.confirm();
        }
        this.i++;
      });
      if(this.exists){
        this.cartItems[this.key].qte= this.oldquantite + this.quantity;
        this.cartItems[this.key].total= (this.oldquantite + this.quantity) * parseFloat(this.article.prix);
        console.log(this.cartItems);
        localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    }
        else{
              let product = new DetailCommande();
              product['id'] = this.article.id;
              product['qte'] = this.quantity;
              product.total = parseFloat(this.article.prix) * this.quantity;
              product.produit = this.article;
              console.log(product);
              this.cartItems =JSON.parse(localStorage.getItem('cartItems') || '[]');
              this.cartItems.push(product);
              localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
              this.router.navigate(['/panier']);
              this.confirm();
          }  

          
  }
  confirm() {
    Swal.fire({
      title: 'Panier',
      text: 'Votre Produit ajouter avec succé',
      icon: 'success',
      showCancelButton: true,
      confirmButtonColor: '#34c38f',
      cancelButtonColor: '#f46a6a',
      confirmButtonText: 'acceder au panier!',
      cancelButtonText: 'Continuez vos achats!'
    }).then(result => {
      if (result.value) {
        this.router.navigate(['/pharmacy/cart']);
      }
      else {
        this.router.navigate(['/home']);
      }
    });
  }
  private _filterEmployees(value: string): Doctors[] {
    const filterValue = value.toLowerCase();
    return this.doctors.filter(
      (state:any) => state.doctor_name.toLowerCase().indexOf(filterValue) === 0
    );
  }

  slides = [
    {
      img: 'assets/img/specialities/Visage.webp',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Visage',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/specialities/A8-SOIN-CORPS-ADULTE.webp',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Corps',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/specialities/Health.webp',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Sante',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/specialities/protection-solaire.webp',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Solaire',
      position: 'CEO of VoidCoders',
    }
   
    
  ];
  slideConfig = {
    slidesToShow: 5,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  };

  slideConfig2 = {
    dots: true,
    infinite: true,
    centerMode: true,
    slidesToShow: 3,
    speed: 500,
    variableWidth: true,
    arrows: false,
    autoplay: false,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  };

  slideConfig3 = {
    dots: true,
    arrows: false,
    variableWidth: true
  };

  next() {
    this.slickModal1.slickNext();
  }

  prev() {
    this.slickModal1.slickPrev();
  }

  getspeciality() {
    this.commonService.getSpeciality().subscribe((res) => {
      this.specialityList = res;
    });
  }

  getDoctors() {
    this.commonService.getDoctors().subscribe((res) => {
      this.doctors = res;
      this.slidepage = {
        slidesToShow: 5,
        slidesToScroll: 1,
        responsive: [
          {
            breakpoint: 1024,
            settings: {
              slidesToShow: 3,
            },
          },
          {
            breakpoint: 600,
            settings: {
              slidesToShow: 2,
            },
          },
          {
            breakpoint: 480,
            settings: {
              slidesToShow: 1,
            },
          },
        ],
      };
      this.countries = [];
      this.doctors.forEach((index:any, i:any) => {
        this.countries.push({
          id: index.id,
          name: index.doctor_name,
        });
      });
    });
  }

  

  selectEvent(item:any) {
    //let filter = this.countries.filter((a) => a.name === item.name);
    //this.router.navigateByUrl('/patients/doctor-profile?id=' + filter[0].id);
    // do something with selected item
  }

  onChangeSearch(search: string) {
    // fetch remote data from here
    // And reassign the 'data' which is binded to 'data' property.
  }

  onFocused(e:any) {
    // do something
  }

  //// next step 2
  sliderContent = [
    {
      img: 'assets/img/features/feature-01.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Patient Ward',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-02.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Test Room',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-03.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'ICU',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-04.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Laboratory',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-05.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Operation',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-06.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Medical',
      position: 'CEO of VoidCoders',
    },
    {
      img: 'assets/img/features/feature-05.jpg',
      msg:
        '"Lorem Ipsum is simply dummy text of the printing and typesetting industry."',
      name: 'Patient Ward',
      position: 'CEO of VoidCoders',
    },
  ];
  slideConfigure = {
    dots: false,
    autoplay: false,
    infinite: true,
    variableWidth: true,
  };
  nextslide() {
    this.slickModal2.slickNext();
  }

  prevslide() {
    this.slickModal2.slickPrev();
  }

  nextpage() {
    this.slickModal3.slickNext();
  }

  prevpage() {
    this.slickModal3.slickPrev();
  }
}
