import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute,Router } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { Response } from '../../../vmodel/response';
import { Adv } from '../../../vmodel/adv';
import { AdvService } from '../../../service/adv.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-adv-detail',
  templateUrl: './adv-detail.component.html',
  styleUrls: ['./adv-detail.component.css']
})
export class AdvDetailComponent implements OnInit {

  adv: Adv;
      
	constructor(private location: Location,
		private advService: AdvService,
		private modalService: NzModalService,
		private route: ActivatedRoute,
		private router: Router,
		private titleService: Title) { }

	ngOnInit() {
		this.titleService.setTitle('广告详情-广告管理-秀逗啊');
		this.loadData();
	}
	
	/**
	* 
	*/
	loadData(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.advService.detail(id).subscribe(response => {
			if(response != null && JSON.stringify(response) != "{}"){
				this.adv = response.data;
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