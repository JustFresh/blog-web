import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../../service/article.service';
import { Article } from '../../../vmodel/article';
import { environment } from '../../../../environments/environment';
@Component({
  selector: 'app-home-main-paging',
  templateUrl: './home-main-paging.component.html',
  styleUrls: ['./home-main-paging.component.css']
})
export class HomeMainPagingComponent implements OnInit {
	
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
	status = "1";
	dataSet = [];
	total = 0;

  constructor(private articleService: ArticleService) { }

  ngOnInit() {
		this.loadData(this.pageNumber);
  }
	
	loadData(pageNumber: any): void {
		this.articleService.page(pageNumber - 1, this.size, this.sort,
			this.channelId, this.title, this.keywords, this.source,this.author,
			this.isRecommend,this.isTop,this.status).subscribe((response: any) => {
			if(response.code == "200"){
				this.dataSet = response.data.content;
				this.total = response.data.totalElements;
			}
		});
  }

}