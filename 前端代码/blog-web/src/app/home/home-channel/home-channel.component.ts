import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router,NavigationStart,NavigationEnd} from '@angular/router';
import { ArticleService } from '../../service/article.service';
import { Article } from '../../vmodel/article';
import { Channel } from '../../vmodel/channel';
import { ChannelService } from '../../service/channel.service';
import { environment } from '../../../environments/environment';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-home-channel',
  templateUrl: './home-channel.component.html',
  styleUrls: ['./home-channel.component.css']
})
export class HomeChannelComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 10;
	sort = "id,desc";
	channelId = '';
	channel = Channel;
	title = '';
	keywords = '';
	source = '';
	author = '';
	isRecommend = '';
	isTop = '';
	status = "1";
	dataSet = [];
	total = 0;
  
	constructor(private articleService: ArticleService,
		private channelService: ChannelService,
		private titleService: Title,
		private route: ActivatedRoute,
		private router: Router) {
	}

	ngOnInit() {
		const channelId = +this.route.snapshot.paramMap.get('id') + "";
		//监听路由参数上栏目ID的变化而修改栏目数据的获取
		this.router.events.subscribe((event:NavigationEnd) => {
			//路由导航成功时执行数据更换
			if (event instanceof NavigationEnd) {
				const channelId = +this.route.snapshot.paramMap.get('id') + "";
				this.loadChannel(channelId);
				this.loadData(this.pageNumber,channelId);
			}
		});
		this.titleService.setTitle('***栏目-秀逗啊');
		this.loadChannel(channelId);
		this.loadData(this.pageNumber,channelId);
	}
	
	/**
	 * 查询栏目信息
	 */
	loadChannel(channelId: any): void{
		this.channelService.detail(channelId).subscribe(response => {
			this.channel = response.data;
		});
	}
	
	/**
	 * 初始化加载分页数据
	 */
	loadData(pageNumber: any,channelId: any): void {
		this.articleService.page(pageNumber - 1, this.size, this.sort,
			channelId, this.title, this.keywords, this.source,this.author,
			this.isRecommend,this.isTop,this.status).subscribe((response: any) => {
			if(response.code == "200"){
				this.dataSet = response.data.content;
				this.total = response.data.totalElements;
			}
		});
	}

}