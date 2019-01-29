import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvEditComponent } from './adv-edit.component';

describe('AdvEditComponent', () => {
  let component: AdvEditComponent;
  let fixture: ComponentFixture<AdvEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
