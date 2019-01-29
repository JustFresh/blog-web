import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminChartsComponent } from './admin-charts.component';

describe('AdminChartsComponent', () => {
  let component: AdminChartsComponent;
  let fixture: ComponentFixture<AdminChartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminChartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminChartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
