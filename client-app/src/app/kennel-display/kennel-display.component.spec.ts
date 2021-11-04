import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KennelDisplayComponent } from './kennel-display.component';

describe('KennelDisplayComponent', () => {
  let component: KennelDisplayComponent;
  let fixture: ComponentFixture<KennelDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KennelDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KennelDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
