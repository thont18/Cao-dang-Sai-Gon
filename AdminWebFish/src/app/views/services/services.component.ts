import { PnotifyService } from './../../services/pnotify.service';
import { ServiceTypeService } from './../../services/service-type.service';
import { ServiceType } from './../../models/ServiceType';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { ServicesService } from './../../services/services.service';
import { Service } from './../../models/Service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  @ViewChild('fileUpload', { static: false }) fileUpload: ElementRef;
  @ViewChild('servicesModel', { static: false }) servicesModel: ModalDirective;
  service = { serviceType: { id: 0 } } as Service;
  services: Service[] = [];
  serviceTypes: ServiceType[] = [];
  serviceType = { id: 0 } as ServiceType;
  page: number = 1;
  itemsPerPage: number = 3;
  selectedFile: File = null
  imagePreview: String = "";
  public imgPath: any;
  imgUrl: any
  constructor(private servicesService: ServicesService, private serviceTypeService: ServiceTypeService, private pnotify: PnotifyService) { }

  loadingData() {
    this.servicesService.getList().subscribe(res => {
      this.services = res;
    });

    this.serviceTypeService.getList().subscribe(res => {
      this.serviceTypes = res;
    })
  }

  ngOnInit(): void {
    this.loadingData();
    console.log(this.services);
  }

  showAdd() {
    this.service = { id: 0, serviceType: { id: 0 } } as Service
    this.servicesModel.show();
    console.log(this.services);
  }

  showEdit(e, id: number) {
    e.preventDefault();
    this.servicesService.get(id).subscribe(res => {
      this.service = res;
      this.servicesModel.show();
    });
  }

  closeModal() {
    this.servicesModel.hide();
  }

  onFileSelected(event) {
    this.selectedFile = <File>event.target.files[0];
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.onload = (event: any) => {
        this.imagePreview = event.target.result;
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  reviewPhoto(file: any) {
    if (file.length === 0) {
      return;
    }
    let reader = new FileReader();
    this.imgPath =file;
    reader.readAsDataURL(this.fileUpload.nativeElement.files[0]);
    reader.onload = (_event => {
      this.imgUrl = reader.result;
    })
  }

  delete(e: Event, id: number) {
    e.preventDefault();
    this.pnotify.showConfirm("Confirm", "Are you sure ?", yes => {
      if (yes) {
        this.servicesService.delete(id).subscribe(res => {
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

  }

  save() {
    if (this.service.id === 0) {
      this.servicesService.add(this.service, this.fileUpload.nativeElement.files[0]).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Insert successfully !')
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Insert failed !')
        }

      });
    } else {
      this.servicesService.update(this.service, this.fileUpload.nativeElement.files[0]).subscribe(res => {
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