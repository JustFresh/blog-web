import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from '../app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgZorroAntdModule, NZ_I18N, zh_CN } from 'ng-zorro-antd';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';

import { HomeArticleComponent } from './home-article/home-article.component';
import { HomeChannelComponent } from './home-channel/home-channel.component';
import { HomeHeaderComponent } from './home-header/home-header.component';
import { HomeFooterComponent } from './home-footer/home-footer.component';
import { HomeIndexComponent } from './home-index/home-index.component';
import { HomeMainComponent } from './home-main/home-main.component';
import { HomeRegisterComponent } from './home-register/home-register.component';
import { HomeSearchResComponent } from './home-search-res/home-search-res.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { HomeSliderComponent } from './home-index/home-slider/home-slider.component';
import { HomeMainChannelsComponent } from './home-main/home-main-channels/home-main-channels.component';
import { HomeMainRecommendsComponent } from './home-main/home-main-recommends/home-main-recommends.component';
import { HomeMainPagingComponent } from './home-main/home-main-paging/home-main-paging.component';
import { HomeLinksComponent } from './home-links/home-links.component';
import { HomeMainCommentsComponent } from './home-main/home-main-comments/home-main-comments.component';
import { HomeLoginComponent } from './home-login/home-login.component';
import { HomeArticleBodyComponent } from './home-article/home-article-body/home-article-body.component';
import { HomeArticleCommentsComponent } from './home-article/home-article-comments/home-article-comments.component';

@NgModule({
  declarations: [HomeArticleComponent, HomeChannelComponent, HomeHeaderComponent, HomeFooterComponent, HomeIndexComponent, HomeMainComponent, HomeRegisterComponent, HomeSearchResComponent, HomeUserComponent, HomeSliderComponent, HomeMainChannelsComponent, HomeMainRecommendsComponent, HomeMainPagingComponent, HomeLinksComponent, HomeMainCommentsComponent, HomeLoginComponent, HomeArticleBodyComponent, HomeArticleCommentsComponent],
  imports: [
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgZorroAntdModule,
		ReactiveFormsModule
  ]
})
export class HomeModule { }
