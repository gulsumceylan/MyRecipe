import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { ShoppingListComponent } from './shopping-list/shopping-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    ShoppingListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild([
      {path: '', component: ShoppingListComponent}
    ]),
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class ShoppingListModule { }
