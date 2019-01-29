import { Component, OnInit } from '@angular/core';
import { ChannelService } from '../../../service/channel.service';
import { Article } from '../../../vmodel/article';
import { environment } from '../../../../environments/environment';
@Component({
  selector: 'app-home-main-channels',
  templateUrl: './home-main-channels.component.html',
  styleUrls: ['./home-main-channels.component.css']
})
export class HomeMainChannelsComponent implements OnInit {

	counts: [];

  constructor(private channelService: ChannelService) { }

  ngOnInit() {
		this.loadData();
  }
	
	loadData(): void{
		this.channelService.channelArticleCount().subscribe((response: any) => {
				if(response.code == "200"){
					this.counts = response.data;
				}
		});
	}

}
