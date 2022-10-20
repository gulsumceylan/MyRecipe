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


  constructor(private recipeService: RecipeService,
              private route: ActivatedRoute,
              private router: Router,
              private categoryService: CategoryService,
              private ingredientService: IngredientService) {
  }

  ngOnInit(): void {
    this.recipeService.getAll().subscribe((res: Recipe[]) => {
      this.recipes = res;
      res.forEach(recipe => {
        this.ingredientService
          .getIngredientsByRecipeId(recipe.recipeId)
          .subscribe((ingredientRes: any) => {
            this.ingredients = ingredientRes;
            console.log(this.ingredients)
            recipe.ingredients = ingredientRes;
          })
      })
    })
    this.categoryService.getAll().subscribe(res => {
      this.categories = res;
    })
  }

}
