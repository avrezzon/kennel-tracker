import { TestBed } from '@angular/core/testing';

import { KennelService } from './kennel.service';

describe('KennelServiceService', () => {
  let service: KennelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KennelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
