import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-recipes',
  template: `
    <section id="recipes">
      <div class="recipes container2">
        <router-outlet></router-outlet>
      </div>
    </section>
  `
})
export class RecipesComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

}
