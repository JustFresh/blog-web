import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { UserService } from '../../service/user.service';
import { CommonService } from '../../service/common.service';
import { User } from '../../vmodel/user';
@Component({
  selector: 'app-admin-index',
  templateUrl: './admin-index.component.html',
  styleUrls: ['./admin-index.component.css']
})
export class AdminIndexComponent implements OnInit {
	
	pageNumber = 1;
	size = 8;
	sort = "id";
	username = '';
	nickName = '';
	userPhone = '';
	userEmail = '';
	status = "1";
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	count = {
		advCount: 0,
		articleCount: 0,
		channelCount: 0,
		commentCount: 0
	}
  constructor(private userService: UserService,
	private titleService: Title,
	private commonService: CommonService) { }
  
  ngOnInit() {
  	this.titleService.setTitle('控制台-Xiudoua-BLOG');
		this.loadCounts();
		this.loadData();
  }
	
	/**
	 * 加载分页数据
	 */
	loadData(reset: boolean = false): void {
		if (reset) {
			this.pageNumber = 1;
		}
		this.loading = true;
		this.userService.page(this.pageNumber - 1, this.size, this.sort,
		this.username, this.nickName, this.userPhone,this.userEmail,this.status).subscribe((response: any) => {
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
	 * 加载统计数据
	 */
	loadCounts(): void{
		this.commonService.counts().subscribe((response: any) => {
			this.count = response.data;
		});
	}

}