import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../vmodel/user';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class UserService {
	
	private siteUrl = environment.SERVER_URL;
	
	/**
	* 分页条件查询
	*/
	page(pageNumber: number = 0, size: number = 10, sort: string, 
		username: string,nickName: string,userPhone: string,
		userEmail: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('username', username).set('nickName', nickName)
		.set('userPhone', userPhone).set('userEmail', userEmail)
		.set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/user/page",{params}); 
	}
	
	/**
	 * 添加用户对象
	 */
	save(user: User): Observable<any>{
		return this.http.post<User>(`${this.siteUrl}` + "/1.0/user/add", user, httpOptions).pipe(
			catchError(this.handleError('save', user))
		);
	}

	/**
	 * 查询详细
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/user/" + id);
	};
	
	/**
	* 添加用户对象
	*/
	edit(user: User): Observable<any>{
		return this.http.put<User>(`${this.siteUrl}` + "/1.0/user/update", user, httpOptions).pipe(
			catchError(this.handleError('edit', user))
		);
	}
	
	/**
	 * 删除
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/user/" + id);
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