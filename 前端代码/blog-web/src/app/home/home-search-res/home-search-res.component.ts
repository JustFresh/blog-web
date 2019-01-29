import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-search-res',
  templateUrl: './home-search-res.component.html',
  styleUrls: ['./home-search-res.component.css']
})
export class HomeSearchResComponent implements OnInit {
	keyword = "JustFresh";
	data: any[] = [];
  constructor() { }
  ngOnInit() {
  	this.loadData(1);
  }
  	
  loadData(pi: number): void {
		this.data = new Array(10).fill({}).map((i, index) => {
			return {
				href: 'http://ant.design',
				title: `ant design part ${index} (page: ${pi})`,
				avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
				description: 'Ant Design, a design language for background applications, is refined by Ant UED Team.',
				content: 'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.'
			};
		});
   }
}
