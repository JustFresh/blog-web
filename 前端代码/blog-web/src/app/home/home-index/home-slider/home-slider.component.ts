import { Component, OnInit } from '@angular/core';
import { AdvService } from '../../../service/adv.service';
import { Adv } from '../../../vmodel/adv';
import { environment } from '../../../../environments/environment';
@Component({
  selector: 'app-home-slider',
  templateUrl: './home-slider.component.html',
  styleUrls: ['./home-slider.component.css']
})
export class HomeSliderComponent implements OnInit {

	siteUrl = environment.SERVER_URL;
	pageNumber = 1;
	size = 5;
	sort = "reorder,desc";
	advName = '';
	advUrl = '';
	advType = '';
	positionId = '';
	status = "1";
	dataSet = [];

  constructor(private advService: AdvService) { }

  ngOnInit() {
		this.loadData();
  }
	
	loadData(): void{
		this.advService.page(this.pageNumber - 1, this.size, this.sort,
			this.advName, this.advUrl, this.advType,this.positionId,this.status).subscribe((response: any) => {
			if(response.code == "200"){
				this.dataSet = response.data.content;
			}
		});
	}

}