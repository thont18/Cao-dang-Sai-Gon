import { PnotifyService } from './../../services/pnotify.service';
import { ProductService } from './../../services/product.service';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { ProductTypeService } from './../../services/product-type.service';
import { ProductType } from './../../models/ProductType';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Product } from '../../models/Product';

@Component({
  selector: 'app-product-types',
  templateUrl: './product-types.component.html',
  styleUrls: ['./product-types.component.css']
})
export class ProductTypesComponent implements OnInit {

  @ViewChild('productTypeModal', { static: false }) productTypeModal: ModalDirective;
  productType = {} as ProductType;
  productTypes: ProductType[] = [];
  products: Product[] = []
  product: Product = { productType: { id: 0 } } as Product;
  page: number = 1;
  itemsPerPage: number = 3;
  filter = '';
  constructor(private productService: ProductService, private productTypeService: ProductTypeService, private pnotify: PnotifyService) { }

  private loadingData() {
    this.productTypeService.getList().subscribe(res => {
      this.productTypes = res;
    });
  }

  test():Boolean {
    this.productTypes.forEach(e=> {
      if(e.ptypCode.localeCompare( this.productType.ptypCode)){
        return true;
      } 
    });
    return false;
  }

  ngOnInit(): void {
    this.loadingData();
    this.productService.getList().subscribe(res => {
      this.products = res;
    });
  }

  showAdd() {
    this.productType = { id: 0 } as ProductType
    this.productTypeModal.show();
  }

  showEdit(e, id: number) {
    e.preventDefault();
    this.productTypeService.get(id).subscribe(res => {
      this.productType = res;
      this.productTypeModal.show();
    });
  };

  closeModal() {
    this.productTypeModal.hide();
  };

  delete(e: Event, id: number) {
    e.preventDefault();
    this.pnotify.showConfirm("Confirm", "Are you sure ?", yes => {
      if (yes) {
        for (let i = 0; i < this.products.length; i++) {
          if (this.products[i].productType.id === id) {
            this.pnotify.showFailure('Failed', 'Delete failed, this type had used!')
            return;
          }
        }

        this.productTypeService.delete(id).subscribe(res => {
          if (Error) {
            this.pnotify.showSuccess('Success', 'Delete successfully !')
            this.loadingData();
          } else {
            this.pnotify.showFailure('Failed', 'Delete failed !')
          }
        });
      }
    })

    this.loadingData();
  };
  save() {
    if (this.productType.id === 0) {
      this.productTypeService.add(this.productType).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Insert successfully !')
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Insert failed !')
        }
      });
    } else {
      this.productTypeService.update(this.productType).subscribe(res => {
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

  showByFilter() {
    if (this.filter === '') {
      this.loadingData();
    } else {
      this.productTypeService.filter(this.filter).subscribe(res => {
        this.productTypes = res;
      });
    }
  }
}
