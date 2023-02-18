import {Component, OnInit} from '@angular/core';
import {CustomerInfo, CustomerInfoService} from "../customer-info.service";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-customer-info-page',
  templateUrl: './customer-info-page.component.html',
  styleUrls: ['./customer-info-page.component.css']
})
export class CustomerInfoPageComponent implements OnInit {
  customerInfo$: Observable<CustomerInfo> | undefined ;
  constructor(private customerInfoService: CustomerInfoService, private router: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customerInfo$ = this.router.queryParams
      .pipe(switchMap(p => this.customerInfoService.getCustomerInfo$(p['customerId'])));
  }
}
