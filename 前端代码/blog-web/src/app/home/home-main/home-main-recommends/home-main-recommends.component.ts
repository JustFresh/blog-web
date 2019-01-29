import { Component, OnInit } from '@angular/core';
import { CommonService } from '../../../service/common.service';
import { ArticleService } from '../../../service/article.service';
import { Article } from '../../../vmodel/article';
import { environment } from '../../../../environments/environment';
@Component({
  selector: 'app-home-main-recommends',
  templateUrl: './home-main-recommends.component.html',
  styleUrls: ['./home-main-recommends.component.css']
})
export class HomeMainRecommendsComponent implements OnInit {
	
	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 10;
	sort = "createTime,desc";
	channelId = '';
	title = '';
	keywords = '';
	source = '';
	author = '';
	isRecommend = '1';
	isTop = '';
	status = "";
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
  constructor(private articleService: ArticleService,
  	private commonService: CommonService) { }

  ngOnInit() {
		this.loadData();
  }
	
	loadData(reset: boolean = false): void {
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
			}else{
				this.dataSet = [];
			}
		});
	}

}
