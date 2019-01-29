import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Admin } from '../vmodel/admin';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class AdminService {
	
	private siteUrl = environment.SERVER_URL;
	/**
	 * 分页条件查询
	 */
	getAdminPage(pageNumber: number = 0, size: number = 10, sort: string, 
		username: string,nickName: string,status : string): Observable<{}> {
		const params = new HttpParams().set('page', `${pageNumber}`)
		.set('size', `${size}`).set('sort', sort)
		.set('username', username).set('nickName', nickName).set('status', status);
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/page",{params}); 
	}
	
	/**
	 * 添加用户对象
	 */
	saveAdmin(admin: Admin): Observable<any>{
		return this.http.post<Admin>(`${this.siteUrl}` + "/1.0/admin/add", admin, httpOptions).pipe(
			catchError(this.handleError('saveAdmin', admin))
		);
	}

	/**
	 * 获取一条管理员数据
	 */
	detail(id: number): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/" + id);
	};
	
	/**
	* 添加用户对象
	*/
	editAdmin(admin: Admin): Observable<any>{
		return this.http.put<Admin>(`${this.siteUrl}` + "/1.0/admin/update", admin, httpOptions).pipe(
			catchError(this.handleError('editAdmin', admin))
		);
	}
	
	/**
	 * 
	 */
	delete(id: number): Observable<any>{
		return this.http.delete(`${this.siteUrl}` + "/1.0/admin/" + id);
	};
	
	/**
	 * 管理员登录
	 */
	login(username: string,password: string): Observable<any>{
		return this.http.get(`${this.siteUrl}` + "/1.0/admin/login?username=" + username + "&password=" + password);
	}

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
