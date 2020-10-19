import { TestBed } from '@angular/core/testing';

import { FishTypeService } from './fish-type.service';

describe('FishTypeService', () => {
  let service: FishTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FishTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
