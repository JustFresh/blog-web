import { Component, OnInit, Output, EventEmitter, Inject } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { ADMIN_MENUS } from '../../mock/mock-menu';
import { AdminMenu } from '../../vmodel/admin-menu';
@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

	menus = ADMIN_MENUS;
	current_module = 'index';
  constructor(private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
		this.route.queryParams.subscribe((params: any) => {
		  var temp = params.module || '';
			if(temp != null && temp != ""){
				this.current_module = temp;
			}
		});
  }
	
	/**
	* 跳转到指定URL
	*/
	goUrl(url: String,module: String, opt: String): void{
		var urlHtml = url + "?module=" + module + "&opt=" + opt;
		this.router.navigateByUrl(urlHtml);
	}
	
	/**
	 * 用户退出登录
	 */
	logout(): void{
		this.router.navigateByUrl("/admin/login");
	}
	
}
