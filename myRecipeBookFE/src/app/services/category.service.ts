import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from 'src/environments/environment';
import {Category} from '../models/category';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  api: string = environment.baseUrl + '/categories/';

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Category[]>(this.api + 'getAll');
  }

  getCategory(id: number) {
    return this.http.get<Category>(this.api + 'getById');
  }
}
