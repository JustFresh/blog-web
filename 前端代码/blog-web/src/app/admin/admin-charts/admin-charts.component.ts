import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-admin-charts',
  templateUrl: './admin-charts.component.html',
  styleUrls: ['./admin-charts.component.css']
})
export class AdminChartsComponent implements OnInit {

	chartOptions = {   
		responsive: true 
	};    
	chartData = [   
		{ data: [330, 600, 260, 700], label: 'Account A' },   
		{ data: [120, 455, 100, 340], label: 'Account B' },   
		{ data: [45, 67, 800, 500], label: 'Account C' }  
	];    
	chartLabels = ['January', 'February', 'Mars', 'April'];    
	onChartClick(event) {   
		console.log(event);  
	} 

  constructor(private titleService: Title) { }

  ngOnInit() {
		this.titleService.setTitle('报表统计-秀逗啊');
  }

}