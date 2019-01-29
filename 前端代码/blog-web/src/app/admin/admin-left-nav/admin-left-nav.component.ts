import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Location } from '@angular/common';
import { ADMIN_MENUS } from '../../mock/mock-menu';
import { AdminMenu } from '../../vmodel/admin-menu';
@Component({
  selector: 'app-admin-left-nav',
  templateUrl: './admin-left-nav.component.html',
  styleUrls: ['./admin-left-nav.component.css']
})
export class AdminLeftNavComponent implements OnInit {

	module = "index";
	all_menus = ADMIN_MENUS;
	left_menus: AdminMenu[];
	current_opt = 'index';
	constructor(private route: ActivatedRoute,private router: Router) { }
	ngOnInit() {
		this.route.queryParams.subscribe((params: any) => {
      		var temp = params.module || '';
			if(temp != null && temp != ""){
				this.module = temp;
			}
			if(params.opt != null){
				this.current_opt = params.opt;
			}
			this.initLeftMenus(this.module);
    });
	}
	
	/**
	 * 初始化左侧菜单
	 */
	initLeftMenus(modue: string): void{
		var menus = this.all_menus;
		if(menus != null && menus.length > 0){
			for(var i=0;i<menus.length;i++){
				if(menus[i].module == this.module){
					this.left_menus = menus[i].children;
				}
			}
		}
	}
	
	/**
	 * 跳转到指定URL
	 */
	goUrl(url: String,module: String, opt: String): void{
		var urlHtml = url + "?module=" + module + "&opt=" + opt;
		this.router.navigateByUrl(urlHtml);
	}

}