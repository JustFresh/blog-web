import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMainPagingComponent } from './home-main-paging.component';

describe('HomeMainPagingComponent', () => {
  let component: HomeMainPagingComponent;
  let fixture: ComponentFixture<HomeMainPagingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeMainPagingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeMainPagingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
