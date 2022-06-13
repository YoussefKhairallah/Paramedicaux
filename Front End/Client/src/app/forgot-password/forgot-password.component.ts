import { Component, OnInit } from '@angular/core';

declare const $: any;
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  value: any;

  constructor() { }

  ngOnInit(): void {
    if($('.floating').length > 0 ){
      $('.floating').on('focus blur',  (e:any) => {
      $(this).parents('.form-focus').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
      }).trigger('blur');
    }
  }

}
