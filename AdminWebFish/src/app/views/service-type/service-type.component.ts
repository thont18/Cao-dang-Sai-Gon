import { PnotifyService } from './../../services/pnotify.service';
import { ServicesService } from './../../services/services.service';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { ServiceTypeService } from './../../services/service-type.service';
import { ServiceType } from './../../models/ServiceType';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Service } from '../../models/Service';

@Component({
  selector: 'app-service-type',
  templateUrl: './service-type.component.html',
  styleUrls: ['./service-type.component.css']
})
export class ServiceTypeComponent implements OnInit {

  @ViewChild('serviceTypeModal', { static: false }) serviceTypeModal: ModalDirective;
  serviceType = {} as ServiceType;
  serviceTypes: ServiceType[] = [];
  services: Service[] = [];
  service = { serviceType: { id: 0 } } as Service;
  page: number = 1;
  itemsPerPage: number = 3;
  constructor(private servicesService: ServicesService, private serviceTypeService: ServiceTypeService, private pnotify: PnotifyService) { }

  private loadingData() {
    this.serviceTypeService.getList().subscribe(res => {
      this.serviceTypes = res;
    });
  }


  ngOnInit(): void {
    this.loadingData();
    this.servicesService.getList().subscribe(res => {
      this.services = res;
    });
  }
  showAdd() {
    this.serviceType = { id: 0 } as ServiceType
    this.serviceTypeModal.show();
    console.log(this.services);
  }

  showEdit(e, id: number) {
    e.preventDefault();
    this.serviceTypeService.get(id).subscribe(res => {
      this.serviceType = res;
      this.serviceTypeModal.show();
    });
  }

  closeModal() {
    this.serviceTypeModal.hide();
  }

  delete(e: Event, id: number) {
    e.preventDefault();
    this.pnotify.showConfirm("Confirm", "Are you sure ?", yes => {
      if (yes) {
        for (let i = 0; i < this.services.length; i++) {
          if (this.services[i].serviceType.id === id) {
            this.pnotify.showFailure('Failed', 'Delete failed, this type had used!')
            return;
          }
        }

        this.serviceTypeService.delete(id).subscribe(res => {
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
    if (this.serviceType.id === 0) {
      this.serviceTypeService.add(this.serviceType).subscribe(res => {
        if (Error) {
          this.pnotify.showSuccess('Success', 'Insert successfully !')
          this.closeModal();
          this.loadingData();
        } else {
          this.pnotify.showFailure('Failed', 'Insert failed !')
        }
      });
    } else {
      this.serviceTypeService.update(this.serviceType).subscribe(res => {
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

