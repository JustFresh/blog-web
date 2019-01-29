import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Adv } from '../vmodel/adv';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class AdvService {
	
	private siteUrl = environment.SERVER_URL;
	
	/**
	* 分页条件查询
	*/
	page(pageNumber: number = 0, size: number = 10, sort: string, 
		advName: string,advUrl: string,advType: string,
		positionId: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('advName', advName).set('advUrl', advUrl)
		.set('advType', advType).set('positionId', positionId)
		.set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/adv/page",{params}); 
	}
	
	/**
	 * 添加广告对象
	 */
	save(adv: Adv): Observable<any>{
		return this.http.post<Adv>(`${this.siteUrl}` + "/1.0/adv/add", adv, httpOptions).pipe(
			catchError(this.handleError('save', adv))
		);
	}

	/**
	 * 查询详细
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/adv/" + id);
	};
	
	/**
	* 添加广告对象
	*/
	edit(adv: Adv): Observable<any>{
		return this.http.put<Adv>(`${this.siteUrl}` + "/1.0/adv/update", adv, httpOptions).pipe(
			catchError(this.handleError('edit', adv))
		);
	}
	
	/**
	 * 删除
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/adv/" + id);
	};
	
	/**
	 * 广告位下拉菜单数据
	 */
	positionSelect(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/layout/advPositions"); 
	};
	
	/**
	* 广告类型下拉菜单数据
	*/
	typeSelect(): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/layout/advTypes"); 
	};

  constructor(private http: HttpClient) {}
	
	/**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
	return (error: any): Observable<T> => {
	  // TODO: send the error to remote logging infrastructure
	  console.error(error); // log to console instead
	  // TODO: better job of transforming error for user consumption
	  // Let the app keep running by returning an empty result.
	  return of(result as T);
	};
  }
}