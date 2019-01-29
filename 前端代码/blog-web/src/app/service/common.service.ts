import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
import { ADV_TYPES,ADV_POSITIONS } from '../mock/mock-select';
const httpOptions = {
  headers: new HttpHeaders({'Accept': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class CommonService {
	
	advTypes = ADV_TYPES;
	positionIds = ADV_POSITIONS;
	private siteUrl = environment.SERVER_URL;	
	ngOnInit() {
	}
	
	constructor(private http: HttpClient) {}
	
	/**
	 * 图片上传
	 */
	uploadImg(title: string,file: any): Observable<any>{
		let formData = new FormData();
		formData.append('file',file);
		return this.http.post(`${this.siteUrl}` + "/1.0/upload/image?dirPath=" + title, formData, httpOptions).pipe(
			catchError(this.handleError('upload', file))
		);
	};
	
	/**
	 * 
	 */
	counts(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/commom/counts").pipe(
			catchError(this.handleError('counts'))
		);
	};
	
	/**
	 * Home模块顶部导航
	 */
	homeHeaders(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/commom/homeHeaderNavs").pipe(
			catchError(this.handleError('counts'))
		);
	};
	
	/********************************* JustFresh 2018-12-18 Begin 通过下拉菜单key转变为值 ******************************************/
	/**
	 * 广告类型转换
	 */
	transAdsType(key: string): string{
		var res = '无';
		var advTypeList = this.advTypes;
		if(advTypeList != null && advTypeList.length > 0){
			for(var i=0;i<advTypeList.length;i++){
				if(advTypeList[i].key == key){
					res = advTypeList[i].value;
					break;
				}
			}
		}
		return res;
	};
	
	/**
	 * 转换广告位文字
	 */
	transPositionId(key: string){
		var res = '无';
		var positionList = this.positionIds;
		if(positionList != null && positionList.length > 0){
			for(var i=0;i<positionList.length;i++){
				if(positionList[i].key == key){
					res = positionList[i].value;
					break;
				}
			}
		}
		return res;
	}
	/********************************* JustFresh 2018-12-18 End 通过下拉菜单key转变为值 ******************************************/
	/**
	 * 异常处理
	 */
	private handleError<T> (operation = 'operation', result?: T) {
		return (error: any): Observable<T> => {
			return of(result as T)
		};
	}
	
}