import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleMngComponent } from './article-mng.component';

describe('ArticleMngComponent', () => {
  let component: ArticleMngComponent;
  let fixture: ComponentFixture<ArticleMngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleMngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleMngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
