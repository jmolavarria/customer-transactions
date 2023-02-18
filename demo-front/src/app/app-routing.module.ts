import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomerInfoPageComponent} from "../feature/account-managment/customer-info-page/customer-info-page.component";

const routes: Routes = [
  {
    path: 'customer-info',
    component: CustomerInfoPageComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
