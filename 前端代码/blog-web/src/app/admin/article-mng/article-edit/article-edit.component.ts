import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { CommonService } from '../../../service/common.service';
import { Article } from '../../../vmodel/article';
import { ArticleService } from '../../../service/article.service';
import { ChannelService } from '../../../service/channel.service';
import { environment } from '../../../../environments/environment';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.css']
})
export class ArticleEditComponent implements OnInit {

  thumbUrl;
	siteUrl = environment.SERVER_URL;
	article: Article;
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	channelSelect = [];
	constructor(private location: Location,
		private articleService: ArticleService,
		private modalService: NzModalService,
		private channelService: ChannelService,
		private commonService: CommonService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('文章修改-文章管理-秀逗啊');
		this.initChannelSelect();
		this.loadData();
	}
	
	/**
	* 初始化栏目下拉菜单
	*/
	initChannelSelect(): void{
		this.channelService.listSelect().subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.channelSelect = response.data;
				}
			}
		});
	}
	
	/**
	 * 
	 */
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.articleService.detail(id).subscribe(response => {
			this.article = response.data;
		});
	}
	
	/**
	 * 
	 */
	goBack(): void {
		this.location.back();
	}
	
	/**
	 * 
	 */
	sendForm(): void{
		this.articleService.edit(this.article).subscribe(response => {
			if(response.code == "200"){
				//处理成功
				const modal = this.modalService.success({nzTitle: '修改文章成功'});
				modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/article/list?module=article&opt=article"));
			}else{
				this.modalService.error({nzTitle: response.msg});
			}
		});
	}
	
	/**
	* 缩略图上传
	*/
	uploadImg(title: string,event: any): void{
		let file = event.target.files[0];
		this.commonService.uploadImg(title,file).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.article.thumb = response.data.filePath;
				}
			}
		});
	}
		
	/**
	* 表单校验
	*/
	checkForm(): boolean{
		if(this.article.title == null || this.article.title == ""){
			this.modalService.error({nzTitle: '文章标题必填！'});
			return false;
		}
		if(this.article.content == null || this.article.content == ""){
			this.modalService.error({nzTitle: '文章内容必填！'});
			return false;
		}
		if(this.article.thumb == null || this.article.thumb == ""){
			this.modalService.error({nzTitle: '缩略图必传！'});
			return false;
		}
		if(this.article.channel == null){
			this.modalService.error({nzTitle: '文章栏目必选！'});
			return false;
		}
		return true;
	}
}
