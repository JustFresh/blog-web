import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMainRecommendsComponent } from './home-main-recommends.component';

describe('HomeMainRecommendsComponent', () => {
  let component: HomeMainRecommendsComponent;
  let fixture: ComponentFixture<HomeMainRecommendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeMainRecommendsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeMainRecommendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
