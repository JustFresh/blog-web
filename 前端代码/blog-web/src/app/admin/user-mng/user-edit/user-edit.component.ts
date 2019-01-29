import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { User } from '../../../vmodel/user';
import { UserService } from '../../../service/user.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  user: User;
  statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
  sexSelect = [{key: '男',value: '男'},{key: '女',value: '女'}];
	constructor(private location: Location,
		private userService: UserService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('用户编辑-用户管理-秀逗啊');
		this.loadData();
	}
	
	/**
	 * 
	 */
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.userService.detail(id).subscribe(response => {
			this.user = response.data;
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
		this.userService.edit(this.user).subscribe(response => {
			if(response.code == "200"){
				//处理成功
				const modal = this.modalService.success({nzTitle: '修改用户成功'});
				modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/user/list?module=index&opt=user"));
			}else{
				this.modalService.error({nzTitle: response.msg});
			}
		});
	}

}
