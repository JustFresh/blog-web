import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from '../app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgZorroAntdModule, NZ_I18N, zh_CN } from 'ng-zorro-antd';
import { registerLocaleData } from '@angular/common';
import {CKEditorModule} from 'ng2-ckeditor';
import zh from '@angular/common/locales/zh';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminIndexComponent } from './admin-index/admin-index.component';
import { AdminMngComponent } from './admin-mng/admin-mng.component';
import { ChannelMngComponent } from './channel-mng/channel-mng.component';
import { ArticleMngComponent } from './article-mng/article-mng.component';
import { UserMngComponent } from './user-mng/user-mng.component';
import { UserAddComponent } from './user-mng/user-add/user-add.component';
import { UserEditComponent } from './user-mng/user-edit/user-edit.component';
import { UserDetailComponent } from './user-mng/user-detail/user-detail.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AdminFooterComponent } from './admin-footer/admin-footer.component';
import { AdminLeftNavComponent } from './admin-left-nav/admin-left-nav.component';
import { AdminChartsComponent } from './admin-charts/admin-charts.component';
import { AdminAddComponent } from './admin-mng/admin-add/admin-add.component';
import { AdminEditComponent } from './admin-mng/admin-edit/admin-edit.component';
import { AdminDetailComponent } from './admin-mng/admin-detail/admin-detail.component';
import { ChannelAddComponent } from './channel-mng/channel-add/channel-add.component';
import { ChannelEditComponent } from './channel-mng/channel-edit/channel-edit.component';
import { ChannelDetailComponent } from './channel-mng/channel-detail/channel-detail.component';
import { ArticleAddComponent } from './article-mng/article-add/article-add.component';
import { ArticleEditComponent } from './article-mng/article-edit/article-edit.component';
import { ArticleDetailComponent } from './article-mng/article-detail/article-detail.component';
import { AdvMngComponent } from './adv-mng/adv-mng.component';
import { AdvAddComponent } from './adv-mng/adv-add/adv-add.component';
import { AdvEditComponent } from './adv-mng/adv-edit/adv-edit.component';
import { AdvDetailComponent } from './adv-mng/adv-detail/adv-detail.component';
import { CommentMngComponent } from './comment-mng/comment-mng.component';
import { CommentAddComponent } from './comment-mng/comment-add/comment-add.component';
import { CommentEditComponent } from './comment-mng/comment-edit/comment-edit.component';
import { CommentDetailComponent } from './comment-mng/comment-detail/comment-detail.component';
import { environment } from '../../environments/environment';
import { LinksMngComponent } from './links-mng/links-mng.component';
import { LinksAddComponent } from './links-mng/links-add/links-add.component';
import { LinksEditComponent } from './links-mng/links-edit/links-edit.component';
import { LinksDetailComponent } from './links-mng/links-detail/links-detail.component';
@NgModule({
  declarations: [AdminLoginComponent, AdminIndexComponent, AdminMngComponent, ChannelMngComponent, ArticleMngComponent, UserMngComponent, UserAddComponent, UserEditComponent, UserDetailComponent, AdminHeaderComponent, AdminFooterComponent, AdminLeftNavComponent, AdminChartsComponent, AdminAddComponent, AdminEditComponent, AdminDetailComponent, ChannelAddComponent, ChannelEditComponent, ChannelDetailComponent, ArticleAddComponent, ArticleEditComponent, ArticleDetailComponent, AdvMngComponent, AdvAddComponent, AdvEditComponent, AdvDetailComponent, CommentMngComponent, CommentAddComponent, CommentEditComponent, CommentDetailComponent, LinksMngComponent, LinksAddComponent, LinksEditComponent, LinksDetailComponent],
  imports: [
    CommonModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		FormsModule,
		HttpClientModule,
		NgZorroAntdModule,
		ReactiveFormsModule,
		CKEditorModule,
		ChartsModule
  ]
})
export class AdminModule { }
