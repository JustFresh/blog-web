import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { NzModalService } from 'ng-zorro-antd';
import { AdminService } from '../../service/admin.service';
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

	admin = {
		username: "",
		password: ""
	};

	constructor(private router: Router,
		private modalService: NzModalService,
		private adminService: AdminService,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('管理员登录-秀逗啊');
	}
	
	/**
	 * 登录
	 */
	login(admin: any){
		if(admin == null){
			this.modalService.error({nzTitle: '请输入登录用户名！'});
			return;
		}
		if(admin.username == null || admin.username == ""){
			this.modalService.error({nzTitle: '请输入登录用户名！'});
			return;
		}
		if(admin.password == null || admin.password == ""){
			this.modalService.error({nzTitle: '请输入登录密码！'});
			return;
		}
		this.adminService.login(admin.username,admin.password).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					//处理成功
					//const modal = this.modalService.success({nzTitle: '恭喜您登录成功！'});
					sessionStorage.setItem('loginAdmin',response.data);
					//模拟登录成功，跳转到首页
					this.router.navigateByUrl('admin/index?module=index');
				}else{
					this.modalService.error({nzTitle: response.msg});
				}
			}else{
				this.modalService.error({nzTitle: '登录失败，请输入正确的用户名和密码！'});
			}
		});
	}

}
