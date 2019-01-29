import { Component, OnInit } from '@angular/core';
import { LinksService } from '../../service/links.service';
import { Links } from '../../vmodel/links';
import { environment } from '../../../environments/environment';
@Component({
  selector: 'app-home-links',
  templateUrl: './home-links.component.html',
  styleUrls: ['./home-links.component.css']
})
export class HomeLinksComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 8;
	sort = "id,desc";
	title = '';
	isBlank = '';
	status = "1";
	dataSet = [];

	constructor(private linksService: LinksService) { }

	ngOnInit() {
		this.loadData();
	}
	
	/**
	 * 初始化加载友情链接列表数据
	 */
	loadData(): void{
		this.linksService.page(this.pageNumber - 1, this.size, this.sort,
			this.title, this.isBlank, this.status).subscribe((response: any) => {
			if(response.code == "200"){
				this.dataSet = response.data.content;
			}
		});
	};

}