import { TestBed } from '@angular/core/testing';

import { Sse } from './sse';

describe('Sse', () => {
  let service: Sse;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Sse);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
