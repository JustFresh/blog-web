import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { User } from '../../../vmodel/user';
import { UserService } from '../../../service/user.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

	user: User = {
		id: null,
		username: '',
		nickName: '',
		password: '111111',
		loginSecret: '',
		sex: '男',
		userQQ: '',
		userPhone: '',
		userEmail: '',
		thumb: '',
		status: '1',
		isDel: 0,
		descritption: ''
	};
	statusSelect = [{key: 1,value: '启用'},{key: 0,value: '禁用'}];
	sexSelect = [{key: '男',value: '男'},{key: '女',value: '女'}];
  constructor(private location: Location,
		private userService: UserService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('用户添加-用户管理-秀逗啊');
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
		this.userService.save(this.user).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				if(response.code == "200"){
					//处理成功
					const modal = this.modalService.success({nzTitle: '添加用户成功'});
					modal.afterClose.subscribe(() => this.router.navigateByUrl("/admin/user/list?module=index&opt=user"));
				}else{
					this.modalService.error({nzTitle: response.msg});
				}
			}
		});
	}
	
	/**
	 * 表单校验
	 */
	checkForm(): boolean{
		if(this.user.username == null || this.user.username == ""){
			this.modalService.error({nzTitle: '登录名必填！'});
			return false;
		}
		if(this.user.nickName == null || this.user.nickName == ""){
			this.modalService.error({nzTitle: '昵称必填！'});
			return false;
		}
		if(this.user.userPhone == null || this.user.userPhone == ""){
			this.modalService.error({nzTitle: '联系电话必填！'});
			return false;
		}
		return true;
	}

}