import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../service/article.service';
import { Article } from '../../vmodel/article';
import { environment } from '../../../environments/environment';
@Component({
  selector: 'app-home-main',
  templateUrl: './home-main.component.html',
  styleUrls: ['./home-main.component.css']
})
export class HomeMainComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 3;
	sort = "id,desc";
	channelId = '';
	title = '';
	keywords = '';
	source = '';
	author = '';
	isRecommend = '';
	isTop = '1';
	status = "1";
	tops = [];

  constructor(private articleService: ArticleService) { }
  
	ngOnInit() {
		this.loadData();
	}

	loadData(): void{
		this.articleService.page(this.pageNumber - 1, this.size, this.sort,
			this.channelId, this.title, this.keywords, this.source,this.author,
			this.isRecommend,this.isTop,this.status).subscribe((response: any) => {
				if(response.code == "200"){
					this.tops = response.data.content;
				}
		});
	}
}
