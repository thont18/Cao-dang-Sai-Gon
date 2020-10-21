import { TestBed } from '@angular/core/testing';

import { PnotifyService } from './pnotify.service';

describe('PnotifyService', () => {
  let service: PnotifyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PnotifyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
