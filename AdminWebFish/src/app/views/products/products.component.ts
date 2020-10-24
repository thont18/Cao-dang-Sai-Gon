import { PnotifyService } from './../../services/pnotify.service';
import { ProductTypeService } from './../../services/product-type.service';
import { ProductType } from './../../models/ProductType';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { ProductService } from './../../services/product.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Product } from '../../models/Product';
import { renderFlagCheckIfStmt } from '@angular/compiler/src/render3/view/template';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  @ViewChild('fileUpload', { static: false }) fileUpload: ElementRef;
  @ViewChild('productModal', { static: false }) productModal: ModalDirective;
  products: Product[] = [];
  product: Product = { productType: { id: 0 } } as Product;
  productTypes: ProductType[] = [];
  productType: ProductType = {} as ProductType;
  page: number = 1;
  itemsPerPage: number = 3;
  selectedFile: File = null;
  imagePreview: String = '';
  public imgPath: any;
  imgUrl: any;
  // Sorting data
  key: string = 'code';
  reverse: boolean = false;
  filter = '';

  constructor(private productService: ProductService, private productTypeService: ProductTypeService, private pnotify: PnotifyService) { }

  private loadingData() {
    this.productService.getList().subscribe(res => {
      this.products = res;
    });

    this.productTypeService.getList().subscribe(res => {
      this.productTypes = res;
      // console.log(res);
    });
  }

  ngOnInit(): void {
    this.loadingData();
    // console.log(this.product.productType.id);
  }

  showAdd() {
    this.product = { id: 0, productType: { id: 0 } } as Product;
    this.productModal.show();
  }

  showEdit(e, id: number) {
    e.preventDefault();
    this.productService.get(id).subscribe(res => {
      this.imgUrl = res.image;
      this.product = res;
      this.productModal.show();
    });
  }
  onFileSelected(event) {
    this.selectedFile = <File>event.target.files[0];
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      // tslint:disable-next-line:no-shadowed-variable
      reader.onload = (event: any) => {
        this.imagePreview = event.target.result;
      };
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  // uploadFile() {

  //   data.append('image', this.selectedFile, this.selectedFile.name);
  //   this.productService.uploadImage(data).subscribe(res => {
  //     console.log(res);
  //   });
  // }
  closeModal() {
    this.productModal.hide();
  }

  reviewPhoto(file: any) {
    if (file.length === 0) {
      return;
    }
    const reader = new FileReader();
    this.imgPath = file;
    reader.readAsDataURL(this.fileUpload.nativeElement.files[0]);
    reader.onload = (_event => {
      this.imgUrl = reader.result;
    });
  }

  delete(e: Event, id: number) {
    e.preventDefault();
    this.pnotify.showConfirm('Confirm', 'Are you sure ?', yes => {
      if (yes) {
        this.productService.delete(id).subscribe(res => {
            this.pnotify.showSuccess('Success', 'Delete successfully !');
            this.loadingData();
        });
      }
    });
  }

  save() {
    const data = new FormData();
    data.append('image', this.selectedFile);

    if (this.product.id === 0) {
      this.productService.add(this.product, this.fileUpload.nativeElement.files[0]).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Insert successfully !');
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Insert failed !');
        }

      });
    } else {
      if (this.fileUpload.nativeElement.files[0] === undefined) {
        this.productService.updateNoPhoto(this.product).subscribe(res => {
          if (Error) {
            this.pnotify.showSuccess('Success', 'Update successfully !');
            this.closeModal();
            this.loadingData();
          } else {
            this.pnotify.showFailure('Failed', 'Update failed !');
          }
        });
      } else {
        this.productService.update(this.product, this.fileUpload.nativeElement.files[0]).subscribe(res => {
          if (Error) {
            this.pnotify.showSuccess('Success', 'Update successfully !');
            this.closeModal();
            this.loadingData();
          } else {
            this.pnotify.showFailure('Failed', 'Update failed !');
          }
        });
      }
    }
  }

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  showByFilter() {
    if (this.filter === '') {
      this.loadingData();
    } else {
      this.productService.filter(this.filter).subscribe(res => {
        this.products = res;
      });
    }
  }
}
