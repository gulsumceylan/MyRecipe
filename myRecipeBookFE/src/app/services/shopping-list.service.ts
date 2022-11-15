import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {ShoppingList} from "../models/shoppingList";
import {Recipe} from "../models/recipe";

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  api: string = environment.baseUrl + '/shoppingLists/';

  constructor(private http: HttpClient) {
  }

  createShoppingList(shoppingList: ShoppingList) {
    return this.http.post(this.api + 'add', shoppingList);
  }

  updateShoppingList(shoppingList: ShoppingList) {
    return this.http.post(this.api + 'update', shoppingList);
  }

  deleteShoppingList(id: number) {
    return this.http.post(this.api + 'delete', id);
  }

  getShoppingListByUserId(id: number) {
    return this.http.get<ShoppingList[]>(this.api + '/getShoppingListByUserId/?userId=' + id);
  }
}
