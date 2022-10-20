export class CreateRecipeRequest {
  constructor(
    public name: string,
    public categoryId: number,
    public description: string,
    public imagePath: string,
    public userId: number
  ) {
    this.name = name;
    this.categoryId = categoryId;
    this.description = description;
    this.imagePath = imagePath;
    this.userId = userId;
  }
}
