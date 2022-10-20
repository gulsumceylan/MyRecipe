import {Category} from './category';
import {Ingredient} from './ingredient';

export class Recipe {
  public recipeId?: number;
  public name: string;
  public category: Category;
  public categoryId?: number;
  public description: string;
  public imagePath: string;
  public ingredients?: Ingredient[];
  public userId?: number;

  constructor(
    recipeId: number,
    name: string,
    category: Category,
    categoryId: number,
    description: string,
    imagePath: string,
    ingredients: Ingredient[],
    userId: number
  ) {
    this.recipeId = recipeId;
    this.name = name;
    this.category = category;
    this.categoryId = categoryId;
    this.description = description;
    this.imagePath = imagePath;
    this.ingredients = ingredients;
    this.userId = userId;
  }
}
