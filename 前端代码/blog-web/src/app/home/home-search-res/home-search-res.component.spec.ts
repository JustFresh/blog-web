import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeSearchResComponent } from './home-search-res.component';

describe('HomeSearchResComponent', () => {
  let component: HomeSearchResComponent;
  let fixture: ComponentFixture<HomeSearchResComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeSearchResComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeSearchResComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
