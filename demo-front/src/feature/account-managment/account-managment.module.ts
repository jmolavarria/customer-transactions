import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerInfoPageComponent } from './customer-info-page/customer-info-page.component';
import {CustomerInfoService} from "./customer-info.service";
import {HttpClient} from "@angular/common/http";



@NgModule({
  declarations: [
    CustomerInfoPageComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [
    CustomerInfoService
  ]
})
export class AccountManagmentModule { }
