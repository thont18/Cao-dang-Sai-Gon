import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FishsComponent } from './fishs.component';

describe('FishsComponent', () => {
  let component: FishsComponent;
  let fixture: ComponentFixture<FishsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FishsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FishsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
