import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-comment-add',
  templateUrl: './comment-add.component.html',
  styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent implements OnInit {

  constructor(private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('评论添加-评论管理-秀逗啊');
  }

}
