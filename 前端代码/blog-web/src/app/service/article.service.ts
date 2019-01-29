import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Article } from '../vmodel/article';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ArticleService {
	
	private siteUrl = environment.SERVER_URL;
	
	/**
	* 分页条件查询
	*/
	page(pageNumber: number = 0, size: number = 10, sort: string, 
		channelId: string,title: string,keywords: string,source: string,author: string,
		isRecommend: string,isTop: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('channelId', channelId).set('title', title).set('keywords', keywords)
		.set('source', source).set('author', author)
		.set('isRecommend', isRecommend).set('isTop', isTop)
		.set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/article/page",{params}); 
	}
	
	/**
	 * 添加文章对象
	 */
	save(article: Article): Observable<any>{
		return this.http.post<Article>(`${this.siteUrl}` + "/1.0/article/add", article, httpOptions).pipe(
			catchError(this.handleError('save', article))
		);
	}

	/**
	 * 查询详细
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/article/" + id);
	};
	
	/**
	 * 上一篇
	 */
	prevArticle(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/article/prev/" + id);
	};
	
	/**
	* 下一篇
	*/
	nextArticle(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/article/next/" + id);
	};
	
	/**
	* 添加文章对象
	*/
	edit(article: Article): Observable<any>{
		return this.http.put<Article>(`${this.siteUrl}` + "/1.0/article/update", article, httpOptions).pipe(
			catchError(this.handleError('edit', article))
		);
	}
	
	/**
	 * 删除
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/article/" + id);
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