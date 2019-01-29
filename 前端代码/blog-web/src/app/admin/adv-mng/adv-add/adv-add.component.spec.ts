import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvAddComponent } from './adv-add.component';

describe('AdvAddComponent', () => {
  let component: AdvAddComponent;
  let fixture: ComponentFixture<AdvAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
