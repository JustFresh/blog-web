import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd';
import { CommonService } from '../../service/common.service';
import { LinksService } from '../../service/links.service';
import { Links } from '../../vmodel/links';
import { environment } from '../../../environments/environment';
import { Title } from '@angular/platform-browser';
import { saveAs } from "file-saver";//前端导出Excel插件
@Component({
  selector: 'app-links-mng',
  templateUrl: './links-mng.component.html',
  styleUrls: ['./links-mng.component.css']
})
export class LinksMngComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 10;
	sort = "id";
	title = '';
	isBlank = '';
	status = "";
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];

  constructor(private modalService: NzModalService,
		private linksService: LinksService,
		private commonService: CommonService,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('有情链接管理-秀逗啊');
		this.searchData();
  }
	
	/**
	* 搜索数据
	*/
	searchData(reset: boolean = false): void {
		if (reset) {
			this.pageNumber = 1;
		}
		this.loading = true;
		this.linksService.page(this.pageNumber - 1, this.size, this.sort,this.title, this.isBlank,this.status).subscribe((response: any) => {
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
	* 
	*/
	delete(id: number): void{
		this.modalService.confirm({
			nzTitle     : '确定要删除此友情链接?',
			nzOkText    : '是',
			nzOkType    : 'danger',
			nzOnOk      : () => {
				this.linksService.delete(id).subscribe((response: any) => {
					if(response.code == "200"){
						//处理成功
						const modal = this.modalService.success({nzTitle: '删除友情链接成功'});
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
		const excel = new Blob([document.getElementById('linksTable').innerHTML], {
			type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		});
		saveAs(excel, '有情链接列表.xls');
	}

}