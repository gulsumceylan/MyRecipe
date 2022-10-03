import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  template:`
  <section id="home">
  <div class="home container2">
    <div>
      <h1>Welcome,<span></span></h1>
      <h1>Create your<span></span></h1>
      <h1>Recipe Book<span></span></h1>
      <a type="button" class="cta" routerLink="/login">Login / Register</a>
    </div>
  </div>
</section>
`,

})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
