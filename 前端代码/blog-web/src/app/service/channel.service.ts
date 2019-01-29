import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Channel } from '../vmodel/channel';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ChannelService {
	
	private siteUrl = environment.SERVER_URL;
	/**
	 * 分页条件查询
	 */
	page(pageNumber: number = 0, size: number = 10, sort: string, 
		channelName: string,isBlank: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('channelName', channelName).set('isBlank', isBlank).set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/channel/treegrid",{params}); 
	}
	
	/**
	 * 
	 */
	listSelect(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/layout/channels"); 
	};
	
	/**
	 * 添加用户对象
	 */
	save(channel: Channel): Observable<any>{
		return this.http.post<Channel>(`${this.siteUrl}` + "/1.0/channel/add", channel, httpOptions).pipe(
			catchError(this.handleError('save', channel))
		);
	}

	/**
	 * 获取一条栏目数据
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/channel/" + id);
	};
	
	/**
	* 添加栏目
	*/
	edit(channel: Channel): Observable<any>{
		return this.http.put<Channel>(`${this.siteUrl}` + "/1.0/channel/update", channel, httpOptions).pipe(
			catchError(this.handleError('edit', channel))
		);
	}
	
	/**
	 * 
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/channel/" + id);
	};
	
	/**
	 * 统计栏目下文章数量
	 */
	channelArticleCount(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/commom/channelArticleCount");
	}

  constructor(private http: HttpClient) {}
	
	/**
	* 异常处理
	*/
	private handleError<T> (operation = 'operation', result?: T) {
		return (error: any): Observable<T> => {
			return of(result as T)
		};
	}
	
}