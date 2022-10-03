import { Ingredient } from "./ingredient";


export class Recipe{
  public recipeId?: string;
  public recipeName:string;
  public description:string;
  public imagePath:string;
  public ingredients:Ingredient[];

  constructor(recipeId:string,recipeName:string,description:string,imagePath:string,ingredients:Ingredient[]) {
    this.recipeId=recipeId;
    this.recipeName=recipeName;
    this.description=description;
    this.imagePath=imagePath;
    this.ingredients=ingredients;
  }
}
