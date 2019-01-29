import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,Validators} from '@angular/forms';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Adv } from '../../../vmodel/adv';
import { CommonService } from '../../../service/common.service';
import { AdvService } from '../../../service/adv.service';
import { environment } from '../../../../environments/environment';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-adv-add',
  templateUrl: './adv-add.component.html',
  styleUrls: ['./adv-add.component.css']
})
export class AdvAddComponent implements OnInit {

	thumbUrl;
	siteUrl = environment.SERVER_URL;

	adv: Adv = {
  		id: null,
  		advName: '',
  		advType: '1',
  		advUrl: '#',
  		clickNum: 0,
  		createTime: '',
  		description: '',
  		isBlank: '0',
  		isDel: '0',
  		lastModifiedDate: '',
  		positionId: '1',
  		reorder: 1,
  		status: '1',
			thumb: ''
  	};
  	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
		isBlankSelect = [{key: 1,value: '新窗口打开'},{key: 0,value: '当前窗口打开'}];
  	typeSelect = [];
  	positionSelect = [];
    constructor(private location: Location,
  		private advService: AdvService,
			private commonService: CommonService,
  		private modalService: NzModalService,
  		private route: ActivatedRoute,
  		private router: Router,
			private titleService: Title) { }
  
    ngOnInit() {
			this.titleService.setTitle('广告添加-广告管理-秀逗啊');
			this.initPositionSelect();
			this.initTypeSelect();
    }
		
	/**
	* 初始化广告位下拉菜单
	*/
	initPositionSelect(): void{
		this.advService.positionSelect().subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.positionSelect = response.data;
				}
			}
		});
	}
	
	/**
	* 广告类型下拉菜单
	*/
	initTypeSelect(): void{
		this.advService.typeSelect().subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					this.typeSelect = response.data;
				}
			}
		});
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
  		this.advService.save(this.adv).subscribe(response => {
  			if(response != null && JSON.stringify(response) != "{}"){
  				if(response.code == "200"){
  					//处理成功
  					const modal = this.modalService.success({nzTitle: '添加广告成功'});
  					modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/adv/list?module=index&opt=adv"));
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
					this.adv.thumb = response.data.filePath;
				}
			}
		});
	}
  	
	/**
	 * 表单校验
	 */
	checkForm(): boolean{
		if(this.adv.advName == null || this.adv.advName == ""){
			this.modalService.error({nzTitle: '广告标题必填！'});
			return false;
		}
		if(this.adv.thumb == null || this.adv.thumb == ""){
			this.modalService.error({nzTitle: '请上传广告图片！'});
			return false;
		}
		return true;
	}

}