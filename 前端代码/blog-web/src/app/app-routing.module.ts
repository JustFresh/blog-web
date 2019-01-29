import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeIndexComponent } from './home/home-index/home-index.component';
import { HomeChannelComponent } from './home/home-channel/home-channel.component';
import { HomeArticleComponent } from './home/home-article/home-article.component';
import { HomeLoginComponent } from './home/home-login/home-login.component';
import { HomeRegisterComponent } from './home/home-register/home-register.component';
import { HomeUserComponent } from './home/home-user/home-user.component';
import { HomeSearchResComponent } from './home/home-search-res/home-search-res.component';

import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminIndexComponent } from './admin/admin-index/admin-index.component';
import { AdminMngComponent } from './admin/admin-mng/admin-mng.component';
import { AdminAddComponent } from './admin/admin-mng/admin-add/admin-add.component';
import { AdminEditComponent } from './admin/admin-mng/admin-edit/admin-edit.component';
import { AdminDetailComponent } from './admin/admin-mng/admin-detail/admin-detail.component';
import { UserMngComponent } from './admin/user-mng/user-mng.component';
import { UserAddComponent } from './admin/user-mng/user-add/user-add.component';
import { UserEditComponent } from './admin/user-mng/user-edit/user-edit.component';
import { UserDetailComponent } from './admin/user-mng/user-detail/user-detail.component';
import { ChannelMngComponent } from './admin/channel-mng/channel-mng.component';
import { ChannelAddComponent } from './admin/channel-mng/channel-add/channel-add.component';
import { ChannelEditComponent } from './admin/channel-mng/channel-edit/channel-edit.component';
import { ChannelDetailComponent } from './admin/channel-mng/channel-detail/channel-detail.component';
import { AdvMngComponent } from './admin/adv-mng/adv-mng.component';
import { AdvAddComponent } from './admin/adv-mng/adv-add/adv-add.component';
import { AdvEditComponent } from './admin/adv-mng/adv-edit/adv-edit.component';
import { AdvDetailComponent } from './admin/adv-mng/adv-detail/adv-detail.component';
import { LinksMngComponent } from './admin/links-mng/links-mng.component';
import { LinksAddComponent } from './admin/links-mng/links-add/links-add.component';
import { LinksEditComponent } from './admin/links-mng/links-edit/links-edit.component';
import { LinksDetailComponent } from './admin/links-mng/links-detail/links-detail.component';
import { CommentMngComponent } from './admin/comment-mng/comment-mng.component';
import { CommentAddComponent } from './admin/comment-mng/comment-add/comment-add.component';
import { CommentEditComponent } from './admin/comment-mng/comment-edit/comment-edit.component';
import { CommentDetailComponent } from './admin/comment-mng/comment-detail/comment-detail.component';
import { ArticleMngComponent } from './admin/article-mng/article-mng.component';
import { ArticleAddComponent } from './admin/article-mng/article-add/article-add.component';
import { ArticleEditComponent } from './admin/article-mng/article-edit/article-edit.component';
import { ArticleDetailComponent } from './admin/article-mng/article-detail/article-detail.component';
import { AdminChartsComponent } from './admin/admin-charts/admin-charts.component';
const routes: Routes = [
	/**
	* 添加路由URL及对应组件配置
	*/
	{ path: '', redirectTo: '/home', pathMatch: 'full' },
	{ path: 'home', component: HomeIndexComponent },
	{ path: 'home/channel/:id', component: HomeChannelComponent },
	{ path: 'home/article/:id', component: HomeArticleComponent },
	{ path: 'home/login', component: HomeLoginComponent },
	{ path: 'home/register', component: HomeRegisterComponent },
	{ path: 'home/user', component: HomeUserComponent },
	{ path: 'home/search', component: HomeSearchResComponent },
	
	{ path: 'admin',redirectTo: '/admin/login', pathMatch: 'full' },
	{ path: 'admin/login', component: AdminLoginComponent },
	{ path: 'admin/index', component: AdminIndexComponent },
	{ path: 'admin/admin', redirectTo: '/admin/admin/list', pathMatch: 'full' },
	{ path: 'admin/admin/list', component: AdminMngComponent },
	{ path: 'admin/admin/add', component: AdminAddComponent },
	{ path: 'admin/admin/edit/:id', component: AdminEditComponent },
	{ path: 'admin/admin/detail/:id', component: AdminDetailComponent },
	{ path: 'admin/user', redirectTo: '/admin/user/list', pathMatch: 'full' },
	{ path: 'admin/user/list', component: UserMngComponent},
	{ path: 'admin/user/add', component: UserAddComponent },
	{ path: 'admin/user/edit/:id', component: UserEditComponent },
	{ path: 'admin/user/detail/:id', component: UserDetailComponent },
	{ path: 'admin/channel', redirectTo: '/admin/channel/list', pathMatch: 'full' },
	{ path: 'admin/channel/list', component: ChannelMngComponent },
	{ path: 'admin/channel/add', component: ChannelAddComponent },
	{ path: 'admin/channel/edit/:id', component: ChannelEditComponent },
	{ path: 'admin/channel/detail/:id', component: ChannelDetailComponent },
	{ path: 'admin/adv', redirectTo: '/admin/adv/list', pathMatch: 'full' },
	{ path: 'admin/adv/list', component: AdvMngComponent },
	{ path: 'admin/adv/add', component: AdvAddComponent },
	{ path: 'admin/adv/edit/:id', component: AdvEditComponent },
	{ path: 'admin/adv/detail/:id', component: AdvDetailComponent },
	{ path: 'admin/links', redirectTo: '/admin/links/list', pathMatch: 'full' },
	{ path: 'admin/links/list', component: LinksMngComponent },
	{ path: 'admin/links/add', component: LinksAddComponent },
	{ path: 'admin/links/edit/:id', component: LinksEditComponent },
	{ path: 'admin/links/detail/:id', component: LinksDetailComponent },
	{ path: 'admin/comment', redirectTo: '/admin/comment/list', pathMatch: 'full' },
	{ path: 'admin/comment/list', component: CommentMngComponent },
	{ path: 'admin/comment/add', component: CommentAddComponent },
	{ path: 'admin/comment/edit/:id', component: CommentEditComponent },
	{ path: 'admin/comment/detail/:id', component: CommentDetailComponent },
	{ path: 'admin/article', redirectTo: '/admin/article/list', pathMatch: 'full' },
	{ path: 'admin/article/list', component: ArticleMngComponent },
	{ path: 'admin/article/add', component: ArticleAddComponent },
	{ path: 'admin/article/edit/:id', component: ArticleEditComponent },
	{ path: 'admin/article/detail/:id', component: ArticleDetailComponent },
	{ path: 'admin/chart', redirectTo: '/admin/chart/list', pathMatch: 'full' },
	{ path: 'admin/chart/list', component: AdminChartsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
