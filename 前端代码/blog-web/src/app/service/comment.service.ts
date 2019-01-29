import { HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Response } from '../vmodel/response';
import { environment } from '../../environments/environment';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class CommentService {
	
	private siteUrl = environment.SERVER_URL;
	
}