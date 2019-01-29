import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Channel } from '../../../vmodel/channel';
import { ChannelService } from '../../../service/channel.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-channel-edit',
  templateUrl: './channel-edit.component.html',
  styleUrls: ['./channel-edit.component.css']
})
export class ChannelEditComponent implements OnInit {

	isBlankSelect = [{key: 1,value: '新窗口打开'},{key: 0,value: '当前窗口打开'}];
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	channel: Channel;
	parents: [];

  constructor(private location: Location,
		private channelService: ChannelService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('栏目编辑-栏目管理-秀逗啊');
		this.initSelect();
		this.loadData();
  }

	/**
	* 
	*/
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.channelService.detail(id).subscribe(response => {
			this.channel = response.data;
		});
	}
	
	/**
	* 
	*/
	goBack(): void {
		this.location.back();
	}
	
	/**
	* 初始化父级下拉菜单
	*/
	initSelect(): void{
		this.channelService.listSelect().subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.parents = response.data;
				}
			}
		});
	}
	
	/**
	* 
	*/
	sendForm(): void{
		this.channelService.edit(this.channel).subscribe(response => {
			if(response.code == "200"){
				//处理成功
				const modal = this.modalService.success({nzTitle: '修改栏目成功'});
				modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/channel/list?module=index&opt=channel"));
			}else{
				this.modalService.error({nzTitle: response.msg});
			}
		});
	}

}
