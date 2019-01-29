import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Admin } from '../../../vmodel/admin';
import { AdminService } from '../../../service/admin.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-admin-detail',
  templateUrl: './admin-detail.component.html',
  styleUrls: ['./admin-detail.component.css']
})
export class AdminDetailComponent implements OnInit {

  admin: Admin;
  
	constructor(private location: Location,
		private adminService: AdminService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('操作员详细-操作员管理-秀逗啊');
		this.loadData();
  }
	
	/**
	* 
	*/
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.adminService.detail(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.admin = response.data;
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
