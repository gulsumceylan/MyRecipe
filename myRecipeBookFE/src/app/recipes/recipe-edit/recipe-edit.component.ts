import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Recipe} from 'src/app/models/recipe';
import {RecipeService} from 'src/app/services/recipe.service';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators,} from '@angular/forms';
import {Category} from 'src/app/models/category';
import {IngredientService} from 'src/app/services/ingredient.service';
import {CategoryService} from 'src/app/services/category.service';
import {Ingredient} from 'src/app/models/ingredient';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
})
export class RecipeEditComponent implements OnInit {
  id: number;
  editMode = false;
  recipeForm: FormGroup;
  isClikedAddButton = false;
  recipeIngredients = new FormArray([]);
  categories: Category[];
  recipe: Recipe;
  newRecipeId: number;
  updatedRecipe: any;
  ingredients: any;

  constructor(
    private route: ActivatedRoute,
    private recipeService: RecipeService,
    private ingredientService: IngredientService,
    private categoryService: CategoryService,
    private router: Router,
    private fb: FormBuilder,
    private toastr: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.recipeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      imagePath: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      category: new FormControl(null, Validators.required),
      ingredients: this.fb.array([]),
      user: new FormControl('', Validators.required),
    });

    this.categoryService.getAll().subscribe((res) => {
      this.categories = res;
    });

    this.recipeService.getAll().subscribe((res) => {
      this.newRecipeId = res[res.length - 1].recipeId + 1;
    });

    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.editMode = params['id'] != null;
    });

    this.initForm();
  }

  get controls() {
    return (<FormArray>this.recipeForm.get('ingredients')).controls;
  }

  onSubmit() {
    if (this.editMode) {
      this.updatedRecipe = {
        recipeId: this.id,
        name: this.recipeForm.get('name').value,
        categoryId: this.recipeForm.get('category').value,
        description: this.recipeForm.get('description').value,
        imagePath: this.recipeForm.get('imagePath').value,
        userId: 1
      };
      this.recipeService.updateRecipe(this.updatedRecipe).subscribe(
        (res) => {
          this.ingredients.forEach(i => {
            this.ingredientService.deleteIngredient(i.ingredientId).subscribe();
          });

          this.recipeForm.get('ingredients').value.forEach((ingredient) => {
            const createIngredient = {
              name: ingredient.name,
              measurement: ingredient.measurement,
              recipeId: this.id,
            };
            this.ingredientService.createIngredient(createIngredient).subscribe();
          });

          this.toastr.success('Recipe updated.');
        },
        (err) => {
          this.toastr.error(
            'There was an error updating the recipe, please try again!'
          );
        }
      );
    } else {
      const createRecipe = {
        name: this.recipeForm.get('name').value,
        imagePath: this.recipeForm.get('imagePath').value,
        description: this.recipeForm.get('description').value,
        categoryId: this.recipeForm.get('category').value,
        userId: 1
      }
      this.recipeService.createRecipe(createRecipe).subscribe(
        (res) => {
          this.recipeForm.get('ingredients').value.forEach((ingredient) => {
            const createIngredient = {
              name: ingredient.name,
              measurement: ingredient.measurement,
              recipeId: this.newRecipeId,
            };
            this.ingredientService.createIngredient(createIngredient).subscribe();
          });
          this.toastr.success('Recipe added');
        },
        (err) => {
          this.toastr.error(
            'There was an error updating the recipe, try again!'
          );
        }
      );
    }
  }

  private initForm() {
    if (this.editMode) {
      this.recipeService.getRecipe(this.id).subscribe((res) => {
        this.recipe = res;
        this.ingredientService
          .getIngredientsByRecipeId(this.id)
          .subscribe((ingredientRes: any) => {
            this.ingredients = ingredientRes;
            ingredientRes.forEach((ingredient: Ingredient) => {
              this.recipeIngredients.push(
                new FormGroup({
                  name: new FormControl(ingredient.name, Validators.required),
                  measurement: new FormControl(
                    ingredient.measurement,
                    Validators.required
                  ),
                  recipeId: new FormControl(this.id),
                })
              );
            });
            this.recipeForm.patchValue({
              name: res.name,
              imagePath: res.imagePath,
              description: res.description,
              category: res.categoryId,
              user: res.userId,
            });
            this.recipeForm.setControl('ingredients', this.recipeIngredients);
          });
      });
    }
  }

  onAddIngredient() {
    this.isClikedAddButton = true;
    (<FormArray>this.recipeForm.get('ingredients')).push(
      new FormGroup({
        name: new FormControl(null, Validators.required),
        measurement: new FormControl(null, Validators.required),
        recipeId: new FormControl(this.newRecipeId, Validators.required),
      })
    );
  }

  onDeleteIngredient(index: number) {
    this.recipeForm.get('ingredients').value.splice(index, 1);
    (<FormArray>this.recipeForm.get('ingredients')).controls.splice(index, 1);
  }

  onDelete() {
    this.ingredients.forEach(i => {
      this.ingredientService.deleteIngredient(i.ingredientId).subscribe();
    });
    this.recipeService.deleteRecipe(this.id).subscribe(
      (res) => {
        this.toastr.info('Recipe deleted');
      },
      (err) => {
        this.toastr.error('The recipe could not be deleted, try again!');
      }
    );
  }
}
