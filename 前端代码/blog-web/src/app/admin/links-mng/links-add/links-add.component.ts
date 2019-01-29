import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,Validators} from '@angular/forms';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Links } from '../../../vmodel/links';
import { CommonService } from '../../../service/common.service';
import { LinksService } from '../../../service/links.service';
import { environment } from '../../../../environments/environment';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-links-add',
  templateUrl: './links-add.component.html',
  styleUrls: ['./links-add.component.css']
})
export class LinksAddComponent implements OnInit {

  thumbUrl;
	siteUrl = environment.SERVER_URL;

	links: Links = {
		id: null,
		title: '',
		logo: '',
		url: '#',
		createTime: '',
		description: '',
		isBlank: '0',
		isDel: '0',
		lastModifiedDate: '',
		reorder: 1,
		status: '1'
	};
	isBlankSelect = [{key: 1,value: '新窗口打开'},{key: 0,value: '当前窗口打开'}];
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	constructor(private location: Location,
		private linksService: LinksService,
		private commonService: CommonService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }
	
	ngOnInit() {
		this.titleService.setTitle('友情链接添加-友情链接管理-秀逗啊');
	}
		
	/**
	 * 返回上一步
	 */
	goBack(): void {
		this.location.back();
	}
	
	/**
	 * 保存管理员信息
	 */
	sendForm(): void{
		if(!this.checkForm()){
			return;
		}
		this.linksService.save(this.links).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					//处理成功
					const modal = this.modalService.success({nzTitle: '添加友情链接成功'});
					modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/links/list?module=index&opt=links"));
				}else{
					this.modalService.error({nzTitle: response.msg});
				}
			}
		});
	}
	
	/**
	* 缩略图上传
	*/
	uploadImg(title: string,event: any): void{
		let file = event.target.files[0];
		this.commonService.uploadImg(title,file).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.links.logo = response.data.filePath;
				}
			}
		});
	}
		
	/**
	 * 表单校验
	 */
	checkForm(): boolean{
		if(this.links.title == null || this.links.title == ""){
			this.modalService.error({nzTitle: '标题必填！'});
			return false;
		}
		return true;
	}
  
}