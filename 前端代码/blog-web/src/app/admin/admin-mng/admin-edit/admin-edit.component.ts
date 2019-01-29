import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Admin } from '../../../vmodel/admin';
import { AdminService } from '../../../service/admin.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {

	admin: Admin;

  constructor(private location: Location,
		private adminService: AdminService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('操作员修改-操作员管理-秀逗啊');
		this.loadData();
  }
	
	/**
	 * 
	 */
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.adminService.detail(id).subscribe(response => {
			this.admin = response.data;
		});
	}
	
	/**
	 * 
	 */
	goBack(): void {
		this.location.back();
	}
	
	/**
	 * 
	 */
	sendForm(): void{
		this.adminService.editAdmin(this.admin).subscribe(response => {
			if(response.code == "200"){
				//处理成功
				const modal = this.modalService.success({nzTitle: '修改管理员成功'});
				modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/admin/list?module=index&opt=admin"));
			}else{
				this.modalService.error({nzTitle: response.msg});
			}
		});
	}

}
