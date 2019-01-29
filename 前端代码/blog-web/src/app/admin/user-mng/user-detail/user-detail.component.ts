import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { User } from '../../../vmodel/user';
import { UserService } from '../../../service/user.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user: User;
    
	constructor(private location: Location,
		private userService: UserService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('用户详情-用户管理-秀逗啊');
		this.loadData();
	}
	
	/**
	* 
	*/
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.userService.detail(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.user = response.data;
			}
		});
	}
	
	/**
	* 
	*/
	goBack(): void {
		this.location.back();
	}

}
