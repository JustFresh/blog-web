import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NzModalService } from 'ng-zorro-antd';
import { ChannelService } from '../../service/channel.service';
import { Channel } from '../../vmodel/channel';
import { Title } from '@angular/platform-browser';
import { saveAs } from "file-saver";//前端导出Excel插件
@Component({
  selector: 'app-channel-mng',
  templateUrl: './channel-mng.component.html',
  styleUrls: ['./channel-mng.component.css']
})
export class ChannelMngComponent implements OnInit {

	pageNumber = 1;
	size = 10;
	sort = "id";
	channelName = '';
	isBlank = '';
	status = '';
	total = 0;
	dataSet = [];
	loading = true;
	sortValue = null;
	sortKey = null;
	
	constructor(private modalService: NzModalService,
		private channelService: ChannelService,
		private titleService: Title) { }

  expandDataCache = {};

  collapse(array: Channel[], data: Channel, $event: boolean): void {
    if ($event === false) {
      if (data.children) {
        data.children.forEach(d => {
          const target = array.find(a => a.id === d.id);
          target.expand = false;
          this.collapse(array, target, false);
        });
      } else {
        return;
      }
    }
  }

  convertTreeToList(root: object): Channel[] {
    const stack = [];
    const array = [];
    const hashMap = {};
    stack.push({ ...root, level: 0, expand: false });
    while (stack.length !== 0) {
      const node = stack.pop();
      this.visitNode(node, hashMap, array);
      if (node.children) {
        for (let i = node.children.length - 1; i >= 0; i--) {
          stack.push({ ...node.children[ i ], level: node.level + 1, expand: false, parent: node });
        }
      }
    }
    return array;
  }

  visitNode(node: Channel, hashMap: object, array: Channel[]): void {
    if (!hashMap[ node.id ]) {
      hashMap[ node.id ] = true;
      array.push(node);
    }
  }

  ngOnInit(): void {
		this.titleService.setTitle('栏目管理-秀逗啊');
		this.searchData();
  }
	
	searchData(reset: boolean = false): void {
		if (reset) {
			this.pageNumber = 1;
		}
		this.loading = true;
		this.channelService.page(this.pageNumber - 1, this.size, this.sort,
		this.channelName, this.isBlank, this.status).subscribe((response: any) => {
			this.loading = false;
			if(response.code == "200"){
				this.dataSet = response.data;
				this.dataSet.forEach(item => {
					this.expandDataCache[item.id] = this.convertTreeToList(item);
				});
			}else{
				this.dataSet = [];
			}
		});
	}
	
	/**
	* 
	*/
	delete(data: any): void{
		if(data != null){
			if(data.children != null && data.children.length > 0){
				this.modalService.error({nzTitle: "不能直接删除父栏目！"});
				return;
			}
			this.modalService.confirm({
				nzTitle     : '确定要删除此栏目?',
				nzOkText    : '是',
				nzOkType    : 'danger',
				nzOnOk      : () => {
					this.channelService.delete(data.id).subscribe((response: any) => {
						if(response.code == "200"){
							//处理成功
							const modal = this.modalService.success({nzTitle: '删除栏目成功'});
							//调用重新查询分页数据
							this.searchData();
						}else{
							this.modalService.error({nzTitle: response.msg});
						}
					});
				},
				nzCancelText: '否',
				nzOnCancel  : () => {}
			});
		}
	}

	/**
	* 导出当前页
	*/
	importExcel(): void{
		const excel = new Blob([document.getElementById('channelTable').innerHTML], {
			type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
		});
		saveAs(excel, '栏目列表.xls');
	}

}