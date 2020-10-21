import { PnotifyService } from './../../services/pnotify.service';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { CustomersService } from './../../services/customers.service';
import { Customer } from './../../models/Customer';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  @ViewChild('customerModal', { static: false } ) customerModal: ModalDirective;
  customer = {} as Customer;
  customers: Customer[] = [];
  page: number = 1;
  itemsPerPage: number = 3;
  constructor(private customersService: CustomersService, private pnotify: PnotifyService) { }

  private loadingData() {
    this.customersService.getList().subscribe(res => {
      this.customers = res;
    });
  }

  ngOnInit(): void {
    this.loadingData();
  }

  delete(e: Event, id: number) {
    e.preventDefault();
    this.pnotify.showConfirm("Confirm", "Are you sure ?", yes => {
      if (yes) {
        this.customersService.delete(id).subscribe(res => {
          console.log(res);
          if (res != null) {
            this.pnotify.showSuccess('Success', 'Delete successfully !');
            this.loadingData();
          } else {
            this.pnotify.showFailure('Failed', 'Delete failed !')
          }
        });
      }
    });
  };

  showAdd() {
    this.customer = { id: 0 } as Customer
    this.customerModal.show();
  }

  showEdit(e, id: number) {
    e.preventDefault();
    this.customersService.get(id).subscribe(res => {
      this.customer = res;
      this.customerModal.show();
    });
  }

  closeModal() {
    this.customerModal.hide();
  }

  save() {
    if (this.customer.id === 0) {
      this.customersService.add(this.customer).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Insert successfully !')
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Insert failed !')
        }

      });
    } else {
      this.customersService.update(this.customer).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Update successfully !')
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Update failed !')
        }
      });
    }
  }
}