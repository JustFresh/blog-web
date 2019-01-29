import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeRegisterComponent } from './home-register.component';

describe('HomeRegisterComponent', () => {
  let component: HomeRegisterComponent;
  let fixture: ComponentFixture<HomeRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
