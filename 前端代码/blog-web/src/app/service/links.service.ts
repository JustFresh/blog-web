import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Links } from '../vmodel/links';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class LinksService {
	
	private siteUrl = environment.SERVER_URL;
	
	/**
	* 分页条件查询
	*/
	page(pageNumber: number = 0, size: number = 10, sort: string, 
		title: string,isBlank: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('title', title).set('isBlank', isBlank)
		.set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/links/page",{params}); 
	}
	
	/**
	 * 添加友情链接对象
	 */
	save(links: Links): Observable<any>{
		return this.http.post<Links>(`${this.siteUrl}` + "/1.0/links/add", links, httpOptions).pipe(
			catchError(this.handleError('save', links))
		);
	}

	/**
	 * 查询详细
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/links/" + id);
	};
	
	/**
	* 添加友情链接对象
	*/
	edit(links: Links): Observable<any>{
		return this.http.put<Links>(`${this.siteUrl}` + "/1.0/links/update", links, httpOptions).pipe(
			catchError(this.handleError('edit', links))
		);
	}
	
	/**
	 * 删除
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/links/" + id);
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