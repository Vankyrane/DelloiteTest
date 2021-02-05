import { TestBed } from '@angular/core/testing';

import { HttpdataService } from './httpdata.service';

describe('HttpdataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpdataService = TestBed.get(HttpdataService);
    expect(service).toBeTruthy();
  });
});
