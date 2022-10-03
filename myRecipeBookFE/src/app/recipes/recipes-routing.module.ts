import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { RecipeEditComponent } from "./recipe-edit/recipe-edit.component";
import { RecipeListComponent } from "./recipe-list/recipe-list.component";
import { RecipesComponent } from "./recipes.component";

const routes: Routes = [
  {
    path: '', component: RecipesComponent, children: [
      {path: '', component: RecipeListComponent},
      {path: 'edit', component: RecipeEditComponent},
      {path: ':id/edit', component: RecipeEditComponent},
    ]
  },
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecipesRoutingModule {
}
