import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMainChannelsComponent } from './home-main-channels.component';

describe('HomeMainChannelsComponent', () => {
  let component: HomeMainChannelsComponent;
  let fixture: ComponentFixture<HomeMainChannelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeMainChannelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeMainChannelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
