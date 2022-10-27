import { Pipe, PipeTransform } from '@angular/core';
import {Recipe} from "../models/recipe";

@Pipe({
  name: 'searchRecipe'
})
export class SearchRecipePipe implements PipeTransform {

  transform(value: Recipe[], filterText: string): Recipe[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : "";

    return filterText ? value.filter((recipe: Recipe) => recipe.name
      .toLocaleLowerCase()
      .indexOf(filterText) !== -1) : value;
  }

}
