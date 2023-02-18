import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface CustomerInfo {
  name: string;
  surname: string;
  accounts: AccountInfo[]
}

interface AccountInfo {
  balance: number;
  transactions: TransactionInfo[]
}

interface TransactionInfo{
  amount: number;
}

@Injectable()
export class CustomerInfoService {
  constructor(private http: HttpClient) { }

  getCustomerInfo$(customerId: number): Observable<CustomerInfo> {
    return this.http.get<CustomerInfo>('/api/customer-info?customerId=' + customerId);
  }
}
