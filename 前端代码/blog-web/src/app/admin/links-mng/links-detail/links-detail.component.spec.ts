import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinksDetailComponent } from './links-detail.component';

describe('LinksDetailComponent', () => {
  let component: LinksDetailComponent;
  let fixture: ComponentFixture<LinksDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinksDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinksDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
