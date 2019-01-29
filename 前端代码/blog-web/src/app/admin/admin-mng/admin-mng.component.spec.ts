import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMngComponent } from './admin-mng.component';

describe('AdminMngComponent', () => {
  let component: AdminMngComponent;
  let fixture: ComponentFixture<AdminMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
