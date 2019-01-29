import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeArticleCommentsComponent } from './home-article-comments.component';

describe('HomeArticleCommentsComponent', () => {
  let component: HomeArticleCommentsComponent;
  let fixture: ComponentFixture<HomeArticleCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeArticleCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeArticleCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
