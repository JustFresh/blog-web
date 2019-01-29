import { Component, OnInit } from '@angular/core';
import { FormControl,AbstractControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd';
import { ActivatedRoute,Router } from '@angular/router';
import { ChannelService } from '../../service/channel.service';
import { Channel } from '../../vmodel/channel';
import { CommonService } from '../../service/common.service';
@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styleUrls: ['./home-header.component.css']
})
export class HomeHeaderComponent implements OnInit {

	headers = [];
	curChannelId = null;

  constructor(private commonService: CommonService,
		private route: ActivatedRoute,
		private router: Router,) { }

  ngOnInit() {
		//初始化顶部导航选中标识
		this.route.queryParams.subscribe((params: any) => {
			this.curChannelId = params.curChannelId || null;	
		});
		this.loadHeader();
  }
	
	/**
	 * 加载顶部导航数据
	 */
	loadHeader(): void{
		this.commonService.homeHeaders().subscribe((response: any) => {
			if(response.code == "200"){
				this.headers = response.data;
			}
		});
	}

}