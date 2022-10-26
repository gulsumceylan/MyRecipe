import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from 'src/environments/environment';
import {Recipe} from '../models/recipe';
import {CreateRecipeRequest} from "../models/createRecipeRequest";

@Injectable({
  providedIn: 'root',
})
export class RecipeService {
  api: string = environment.baseUrl + '/recipes/';

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Recipe[]>(this.api + 'getAll');
  }

  getRecipe(id: number) {
    return this.http.get<Recipe>(this.api + 'getById/?id=' + id);
  }

  getRecipesByCategoryId(id: number) {
    return this.http.get<Recipe[]>(this.api + 'getRecipesByCategoryId/?categoryId=' + id);
  }

  createRecipe(recipe: CreateRecipeRequest) {
    return this.http.post(this.api + 'add', recipe);
  }

  updateRecipe(recipe: Recipe) {
    return this.http.post(this.api + 'update', recipe);
  }

  deleteRecipe(id: number) {
    return this.http.post(this.api + 'delete', id);
  }
}
