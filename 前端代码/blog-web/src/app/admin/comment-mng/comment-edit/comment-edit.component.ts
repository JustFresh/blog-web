import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-comment-edit',
  templateUrl: './comment-edit.component.html',
  styleUrls: ['./comment-edit.component.css']
})
export class CommentEditComponent implements OnInit {

  constructor(private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('评论修改-评论管理-秀逗啊');
  }

}
