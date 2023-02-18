import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{

  customers : any;
  bills : any;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    /* Making a GET request to the customer service to get all the customers. */
    this.http.get("http://localhost:9999/CUSTOMER-SERVICE/customers").subscribe({
      next : (data) => {
        this.customers = data;
      },
      error : (err) => {}
    })
  }

  getBills(customer: any) {
    this.router.navigateByUrl(`/bills/${customer.id}`)
  }

}
