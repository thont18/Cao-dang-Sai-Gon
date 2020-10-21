import { BillService } from './../../services/bill.service';
import { Bill } from './../../models/bill';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  bills : Bill[] = []
  constructor(private billService : BillService) { }

  private loadingData() {
    this.billService.getList().subscribe(res => {
      this.bills = res;
    });
  }

  ngOnInit(): void {
    this.loadingData();
  }


}
