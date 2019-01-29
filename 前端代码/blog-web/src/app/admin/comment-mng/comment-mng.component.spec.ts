import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentMngComponent } from './comment-mng.component';

describe('CommentMngComponent', () => {
  let component: CommentMngComponent;
  let fixture: ComponentFixture<CommentMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
