import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinksEditComponent } from './links-edit.component';

describe('LinksEditComponent', () => {
  let component: LinksEditComponent;
  let fixture: ComponentFixture<LinksEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinksEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinksEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
