import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Article } from '../../../vmodel/article';
import { Channel } from '../../../vmodel/channel';
import { ArticleService } from '../../../service/article.service';
import { ChannelService } from '../../../service/channel.service';
import { CommonService } from '../../../service/common.service';
import { environment } from '../../../../environments/environment';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html',
  styleUrls: ['./article-add.component.css']
})
export class ArticleAddComponent implements OnInit {

	siteUrl = environment.SERVER_URL;

	article: Article = {
		id: null,
		isDel: 0,
		abstracts: '',
		author: '',
		clickNum: 0,
		content: '',
		createTime: '',
		description: '',
		isRecommend: '0',
		isTop: '0',
		keywords: '',
		lastModifiedDate: '',
		source: '',
		status: '1',
		thumb: '',
		title: '',
		channel: {
			id: null,
			channelName: '',
			reorder: '',
			uri: '',
			icon: '',
			isBlank: '',
			children:[],
			createTime: '',
			status: '',
			description: '',
			level: null,
			expand: false
		}
	};
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	channelSelect = [];
  constructor(private location: Location,
		private articleService: ArticleService,
		private channelService: ChannelService,
		private commonService: CommonService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

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

  ngOnInit() {
		this.titleService.setTitle('文章添加-文章管理-秀逗啊');
		this.initChannelSelect();
  }
	
	/**
	* 返回上一步
	*/
	goBack(): void {
		this.location.back();
	}
	
	/**
	* 保存文章信息
	*/
	sendForm(): void{
		if(!this.checkForm()){
			return;
		}
		this.articleService.save(this.article).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					//处理成功
					const modal = this.modalService.success({nzTitle: '添加文章成功'});
					modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/article/list?module=article&opt=article"));
				}else{
					this.modalService.error({nzTitle: response.msg});
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
	
	/**
	 * 富文本编辑框内容改变
	 */
	changeContent(event: any): void{
		this.article.content = event;
	};
	
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

}