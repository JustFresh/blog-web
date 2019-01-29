import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FormControl } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd';
import { UserService } from '../../service/user.service';
import { User } from '../../vmodel/user';
import { saveAs } from "file-saver";//前端导出Excel插件
@Component({
  selector: 'app-user-mng',
  templateUrl: './user-mng.component.html',
  styleUrls: ['./user-mng.component.css']
})
export class UserMngComponent implements OnInit {
	
	pageNumber = 1;
	size = 10;
	sort = "id";
	username = '';
	nickName = '';
	userPhone = '';
	userEmail = '';
	status = "";
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	
	constructor(private modalService: NzModalService,
		private userService: UserService,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('用户管理-秀逗啊');
		this.searchData();
	}
	
	searchData(reset: boolean = false): void {
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
	* 
	*/
	delete(id: number): void{
		this.modalService.confirm({
			nzTitle     : '确定要删除此用户?',
			nzOkText    : '是',
			nzOkType    : 'danger',
			nzOnOk      : () => {
				this.userService.delete(id).subscribe((response: any) => {
					if(response.code == "200"){
						//处理成功
						const modal = this.modalService.success({nzTitle: '删除用户成功'});
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
		const excel = new Blob([document.getElementById('userTable').innerHTML], {
			type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		});
		saveAs(excel, '用户列表.xls');
	}

}