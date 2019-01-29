import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChannelAddComponent } from './channel-add.component';

describe('ChannelAddComponent', () => {
  let component: ChannelAddComponent;
  let fixture: ComponentFixture<ChannelAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChannelAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChannelAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
