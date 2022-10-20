import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RecipesComponent} from './recipes.component';
import {RecipeListComponent} from './recipe-list/recipe-list.component';
import {RecipeEditComponent} from './recipe-edit/recipe-edit.component';
import {RouterModule} from '@angular/router';
import {RecipesRoutingModule} from './recipes-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [RecipesComponent, RecipeListComponent, RecipeEditComponent],
  imports: [
    CommonModule,
    RouterModule,
    RecipesRoutingModule,
    FormsModule,
    ReactiveFormsModule,

  ],
})
export class RecipesModule {
}
