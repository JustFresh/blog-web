import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd';
import { CommonService } from '../../service/common.service';
import { ArticleService } from '../../service/article.service';
import { ChannelService } from '../../service/channel.service';
import { Article } from '../../vmodel/article';
import { environment } from '../../../environments/environment';
import { Title } from '@angular/platform-browser';
import { saveAs } from "file-saver";//前端导出Excel插件
@Component({
  selector: 'app-article-mng',
  templateUrl: './article-mng.component.html',
  styleUrls: ['./article-mng.component.css']
})
export class ArticleMngComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 10;
	sort = "id,desc";
	channelId = '';
	title = '';
	keywords = '';
	source = '';
	author = '';
	isRecommend = '';
	isTop = '';
	status = "";
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	isRecommendSelect = [{key: '',value: '请选择--'},{key: 1,value: '推荐'},{key: 0,value: '不推荐'}];
	isTopSelect = [{key: null,value: '请选择--'},{key: 1,value: '置顶'},{key: 0,value: '不置顶'}];
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	channelSelect = [];

  constructor(private modalService: NzModalService,
		private channelService: ChannelService,
  	private articleService: ArticleService,
  	private commonService: CommonService,
		private titleService: Title) { }
  
  ngOnInit() {
		this.titleService.setTitle('文章管理-秀逗啊');
  	this.initChannelSelect();
  	this.searchData();
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
	* 搜索数据
	*/
	searchData(reset: boolean = false): void {
		if (reset) {
			this.pageNumber = 1;
		}
		this.loading = true;
		if(this.channelId == null || this.channelId == 'null'){
			this.channelId = '';
		}
		this.articleService.page(this.pageNumber - 1, this.size, this.sort,
		this.channelId, this.title, this.keywords, this.source,this.author,
		this.isRecommend,this.isTop,this.status).subscribe((response: any) => {
			this.loading = false;
			if(response.code == "200"){
				this.dataSet = response.data.content;
				this.total = response.data.totalElements;
			}else{
				this.dataSet = [];
				this.total = 0;
			}
		});
	}
	
	/**
	* 
	*/
	delete(id: number): void{
		this.modalService.confirm({
			nzTitle     : '确定要删除此文章?',
			nzOkText    : '是',
			nzOkType    : 'danger',
			nzOnOk      : () => {
				this.articleService.delete(id).subscribe((response: any) => {
					if(response.code == "200"){
						//处理成功
						const modal = this.modalService.success({nzTitle: '删除文章成功'});
						//调用重新查询分页数据
						this.searchData();
					}else{
						this.modalService.error({nzTitle: response.msg});
					}
				});
			},
			nzCancelText: '否',
			nzOnCancel  : () => {}
		});
	}
	
	/**
	* 导出当前页
	*/
	importExcel(): void{
		const excel = new Blob([document.getElementById('articleTable').innerHTML], {
			type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		});
		saveAs(excel, '文章列表.xls');
	}
}