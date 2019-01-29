import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeArticleBodyComponent } from './home-article-body.component';

describe('HomeArticleBodyComponent', () => {
  let component: HomeArticleBodyComponent;
  let fixture: ComponentFixture<HomeArticleBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeArticleBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeArticleBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
