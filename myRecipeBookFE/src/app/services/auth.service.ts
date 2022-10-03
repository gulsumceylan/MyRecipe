import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';


@Injectable({
  providedIn: 'root',
})
export class AuthService {

  api: string = environment.baseUrl + '/users/'

  constructor(private http: HttpClient) {}

  getAllUsers() {
   return this.http.get<User>(this.api+'getAll');
  }

  login(user:User) {
    return this.http.post<User>(this.api+'login',user);
   }

   register(user:User) {
    return this.http.post<User>(this.api+'register',user);
   }

}
