export class CreateIngredientRequest {
  constructor(public name: string, public measurement: string, public recipeId: number) {
  }
}
