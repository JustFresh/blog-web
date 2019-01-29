import { Component, OnInit,Output, EventEmitter} from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Admin } from '../../../vmodel/admin';
import { AdminService } from '../../../service/admin.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-admin-add',
  templateUrl: './admin-add.component.html',
  styleUrls: ['./admin-add.component.css']
})
export class AdminAddComponent implements OnInit {

	admin: Admin = {
		id: null,
		username: '',
		nickName: '',
		password: '111111',
		loginNum: 0,
		lastLoginIp: '',
		status: "",
		isDel: 0,
		descritption: ''
	};

  constructor(private location: Location,
		private adminService: AdminService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('操作员添加-操作员管理-秀逗啊'); 
  }
	
	goBack(): void {
		this.location.back();
	}

	/**
	 * 保存管理员信息
	 */
	sendForm(): void{
		this.adminService.saveAdmin(this.admin).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					//处理成功
					const modal = this.modalService.success({nzTitle: '添加管理员成功'});
					modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/admin/list?module=index&opt=admin"));
				}else{
					this.modalService.error({nzTitle: response.msg});
				}
			}
		});
	}
	
}