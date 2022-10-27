import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Category} from 'src/app/models/category';
import {Ingredient} from 'src/app/models/ingredient';
import {Recipe} from 'src/app/models/recipe';
import {CategoryService} from 'src/app/services/category.service';
import {IngredientService} from 'src/app/services/ingredient.service';
import {RecipeService} from 'src/app/services/recipe.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html'
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[];
  categories: Category[];
  ingredients: Ingredient[];
  notFound: string;
  filterText: string;

  constructor(private recipeService: RecipeService,
              private route: ActivatedRoute,
              private router: Router,
              private categoryService: CategoryService,
              private ingredientService: IngredientService) {
  }

  ngOnInit(): void {
    this.getAllRecipes();
    this.categoryService.getAll().subscribe(res => {
      this.categories = res;
    })
  }

  getAllRecipes() {
    this.recipeService.getAll().subscribe((res: Recipe[]) => {
      this.recipes = res;
      this.getIngredients(res);
    })
  }

  filterCategory(category: Category) {
    this.categories.forEach(i => {
      const element = document.getElementById(i.categoryId);
      element.classList.remove("categoryImgSelected");
    })
    const element = document.getElementById(category.categoryId);
    document.getElementById('all').classList.remove("categoryImgSelected");
    document.getElementById('all').classList.add("categoryImg");
    element.classList.add("categoryImgSelected");

    this.recipeService.getRecipesByCategoryId(Number(category.categoryId)).subscribe(res => {
      if (res.length >= 1) {
        this.recipes = res;
        this.getIngredients(res);
        this.notFound = "";
      } else {
        this.recipes = [];
        this.notFound = `${category.name} kategorisinde tarif bulunamadı`;
      }
    })
  }

  getIngredients(recipe: Recipe[]) {
    recipe.forEach(recipe => {
      this.ingredientService
        .getIngredientsByRecipeId(recipe.recipeId)
        .subscribe((ingredientRes: any) => {
          this.ingredients = ingredientRes;
          recipe.ingredients = ingredientRes;
        })
    })
  }

  allRecipes() {
    this.getAllRecipes();
    this.categories.forEach(i => {
      const element = document.getElementById(i.categoryId);
      element.classList.remove("categoryImgSelected");
    })
    document.getElementById('all').classList.add("categoryImgSelected");
  }
}
