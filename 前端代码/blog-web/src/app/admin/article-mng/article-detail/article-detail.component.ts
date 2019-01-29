import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Article } from '../../../vmodel/article';
import { ArticleService } from '../../../service/article.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {

  article: Article;
        
	constructor(private location: Location,
		private articleService: ArticleService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('文章详情-文章管理-秀逗啊');
		this.loadData();
	}
	
	/**
	* 
	*/
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.articleService.detail(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.article = response.data;
			}
		});
	}
	
	/**
	* 
	*/
	goBack(): void {
		this.location.back();
	}

}
