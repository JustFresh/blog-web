import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd';
import { CommonService } from '../../service/common.service';
import { AdvService } from '../../service/adv.service';
import { Adv } from '../../vmodel/adv';
import { environment } from '../../../environments/environment';
import { Title } from '@angular/platform-browser';
import { saveAs } from "file-saver";//前端导出Excel插件
@Component({
  selector: 'app-adv-mng',
  templateUrl: './adv-mng.component.html',
  styleUrls: ['./adv-mng.component.css']
})
export class AdvMngComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 10;
	sort = "id";
	advName = '';
	advUrl = '';
	advType = '';
	positionId = '';
	status = "";
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	typeSelect = [];
	positionSelect = [];
	
	constructor(private modalService: NzModalService,
		private advService: AdvService,
		private commonService: CommonService,
		private titleService: Title) { }
	
	ngOnInit() {
		this.titleService.setTitle('广告管理-秀逗啊');
		this.initPositionSelect();
		this.initTypeSelect();
		this.searchData();
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
	 * 搜索数据
	 */
	searchData(reset: boolean = false): void {
		if (reset) {
			this.pageNumber = 1;
		}
		this.loading = true;
		this.advService.page(this.pageNumber - 1, this.size, this.sort,
		this.advName, this.advUrl, this.advType,this.positionId,this.status).subscribe((response: any) => {
			this.loading = false;
			if(response.code == "200"){
				this.dataSet = response.data.content;
				//处理将结果数据的“类型”、“广告位”等下拉菜单的key转换成对应的value
				if(this.dataSet != null && this.dataSet.length > 0){
					var rowList = this.dataSet;
					for(var i=0;i<rowList.length;i++){
						var advType = this.commonService.transAdsType(rowList[i].advType);
						var positionId = this.commonService.transPositionId(rowList[i].positionId);
						rowList[i].advType = advType;
						rowList[i].positionId = positionId;
					}
				}
				this.total = response.data.totalElements;
			}else{
				this.dataSet = [];
				this.total = 0;
			}
		});
	}
	
	/**
	* 
	*/
	delete(id: number): void{
		this.modalService.confirm({
			nzTitle     : '确定要删除此广告?',
			nzOkText    : '是',
			nzOkType    : 'danger',
			nzOnOk      : () => {
				this.advService.delete(id).subscribe((response: any) => {
					if(response.code == "200"){
						//处理成功
						const modal = this.modalService.success({nzTitle: '删除广告成功'});
						//调用重新查询分页数据
						this.searchData();
					}else{
						this.modalService.error({nzTitle: response.msg});
					}
				});
			},
			nzCancelText: '否',
			nzOnCancel  : () => {}
		});
	}
	
	/**
	* 导出当前页
	*/
	importExcel(): void{
		const excel = new Blob([document.getElementById('advTable').innerHTML], {
			type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		});
		saveAs(excel, '广告列表.xls');
	}

}