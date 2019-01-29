import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMainCommentsComponent } from './home-main-comments.component';

describe('HomeMainCommentsComponent', () => {
  let component: HomeMainCommentsComponent;
  let fixture: ComponentFixture<HomeMainCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeMainCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeMainCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
