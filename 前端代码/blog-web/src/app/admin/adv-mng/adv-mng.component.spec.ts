import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvMngComponent } from './adv-mng.component';

describe('AdvMngComponent', () => {
  let component: AdvMngComponent;
  let fixture: ComponentFixture<AdvMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
