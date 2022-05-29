import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'patients',
    loadChildren: () =>
    import('./patients/patients.module').then((m) => m.PatientsModule),
  },
  {
    path: 'pharmacy',
    loadChildren: () =>
    import('./pharmacy/pharmacy.module').then((m) => m.PharmacyModule),
  },  
  {
    path: 'login-page',
    loadChildren: () =>
    import('./login/login.module').then((m) => m.LoginModule),
  },
  {
    path: 'change-password',
    loadChildren: () =>
    import('./change-password/change-password.module').then((m) => m.ChangePasswordModule),
  },
  {
    path: 'forgot-password',
    loadChildren: () =>
    import('./forgot-password/forgot-password.module').then((m) => m.ForgotPasswordModule),
  },
  {
    path: 'Register',
    loadChildren: () =>
    import('./register/register.module').then((m) => m.RegisterModule),
  },
  {
    path: 'invoice-details',
    loadChildren: () =>
    import('./invoice-details/invoice-details.module').then((m) => m.InvoiceDetailsModule),
  },
  {
    path: 'privacy-policy',
    loadChildren: () =>
    import('./privacy-policy/privacy-policy.module').then((m) => m.PrivacyPolicyModule),
  },
  {
    path: 'terms-conditions',
    loadChildren: () =>
    import('./terms-conditions/terms-conditions.module').then((m) => m.TermsConditionsModule),
  },
  { path: 'about-us', loadChildren: () => import('./about-us/about-us.module').then(m => m.AboutUsModule) },
  { path: 'contact-us', loadChildren: () => import('./contact-us/contact-us.module').then(m => m.ContactUsModule) },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
    onSameUrlNavigation: 'reload',
    preloadingStrategy: PreloadAllModules,
    relativeLinkResolution: 'legacy'
}),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
