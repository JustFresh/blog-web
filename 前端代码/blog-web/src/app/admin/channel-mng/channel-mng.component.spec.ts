import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChannelMngComponent } from './channel-mng.component';

describe('ChannelMngComponent', () => {
  let component: ChannelMngComponent;
  let fixture: ComponentFixture<ChannelMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChannelMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChannelMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
