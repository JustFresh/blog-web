import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinksMngComponent } from './links-mng.component';

describe('LinksMngComponent', () => {
  let component: LinksMngComponent;
  let fixture: ComponentFixture<LinksMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinksMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinksMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
