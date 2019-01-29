import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeChannelComponent } from './home-channel.component';

describe('HomeChannelComponent', () => {
  let component: HomeChannelComponent;
  let fixture: ComponentFixture<HomeChannelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeChannelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeChannelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
