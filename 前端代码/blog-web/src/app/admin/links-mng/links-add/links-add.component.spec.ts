import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinksAddComponent } from './links-add.component';

describe('LinksAddComponent', () => {
  let component: LinksAddComponent;
  let fixture: ComponentFixture<LinksAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinksAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinksAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
