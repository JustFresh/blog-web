import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-comment-mng',
  templateUrl: './comment-mng.component.html',
  styleUrls: ['./comment-mng.component.css']
})
export class CommentMngComponent implements OnInit {

	data = [
			{
				key    : '1',
				name   : 'John Brown',
				age    : 32,
				address: 'New York No. 1 Lake Park',
			},
			{
				key    : '2',
				name   : 'Jim Green',
				age    : 42,
				address: 'London No. 1 Lake Park',
			},
			{
				key    : '3',
				name   : 'Joe Black',
				age    : 32,
				address: 'Sidney No. 1 Lake Park',
			}
		];

  constructor(private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('评论管理-秀逗啊');
  }

}
