import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvDetailComponent } from './adv-detail.component';

describe('AdvDetailComponent', () => {
  let component: AdvDetailComponent;
  let fixture: ComponentFixture<AdvDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
