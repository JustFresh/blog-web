import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { Response } from '../../../vmodel/response';
import { Article } from '../../../vmodel/article';
import { ArticleService } from '../../../service/article.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-home-article-body',
  templateUrl: './home-article-body.component.html',
  styleUrls: ['./home-article-body.component.css']
})
export class HomeArticleBodyComponent implements OnInit {

  article: Article;
	prev: Article;
	next: Article;
  			
  constructor(private location: Location,
  	private articleService: ArticleService,
  	private route: ActivatedRoute,
  	private router: Router,
  	private titleService: Title) { }

  ngOnInit() {
		this.loadData();
		this.loadPrev();
		this.loadNext();
  }
	
	/**
	 * 加载当前文章 
	 */
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.articleService.detail(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.article = response.data;
				this.titleService.setTitle(this.article.title + "-" + this.article.channel.channelName + "-秀逗啊网站");
			}
		});
	}
	
	/**
	* 加载上一篇文章
	*/
	loadPrev(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.articleService.prevArticle(id).subscribe(response => { 
			if(response != null && JSON.stringify(response) != "{}"){
				this.prev = response.data;
			}
		});
	}
	
	/**
	 * 加载下一篇文章
	 */
	loadNext(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.articleService.nextArticle(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.next = response.data;
			}
		});
	}

}