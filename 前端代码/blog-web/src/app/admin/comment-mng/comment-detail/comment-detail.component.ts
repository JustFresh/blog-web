import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-comment-detail',
  templateUrl: './comment-detail.component.html',
  styleUrls: ['./comment-detail.component.css']
})
export class CommentDetailComponent implements OnInit {

  constructor(private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('评论详细-评论管理-秀逗啊');
  }

}
