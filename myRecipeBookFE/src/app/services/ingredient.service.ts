import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from 'src/environments/environment';
import {Ingredient} from '../models/ingredient';
import {CreateIngredientRequest} from "../models/createIngredientRequest";

@Injectable({
  providedIn: 'root',
})
export class IngredientService {
  api: string = environment.baseUrl + '/ingredients/';

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Ingredient[]>(this.api + 'getAll');
  }

  getIngredient(id: number) {
    return this.http.get<Ingredient>(this.api + 'getById');
  }

  getIngredientsByRecipeId(id: number) {
    return this.http.get<Ingredient>(this.api + 'getIngredientsByRecipeId?recipeId=' + id);
  }

  createIngredient(ingredient: CreateIngredientRequest) {
    return this.http.post(this.api + 'add', ingredient);
  }

  updateIngredient(ingredient: Ingredient) {
    return this.http.post(this.api + 'update', ingredient);
  }

  deleteIngredient(id: number) {
    return this.http.post(this.api + 'delete', id);
  }
}
