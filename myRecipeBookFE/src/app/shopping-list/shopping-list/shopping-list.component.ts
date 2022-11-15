import {Component, OnInit} from '@angular/core';
import {ShoppingListService} from "../../services/shopping-list.service";
import {ShoppingList} from "../../models/shoppingList";
import {Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html'
})
export class ShoppingListComponent implements OnInit {

  shoppingList: ShoppingList[];
  shoppingListForm: any;

  constructor(private shoppingListService: ShoppingListService,
              private router: Router,
              private fb: FormBuilder,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getList();

    this.shoppingListForm = this.fb.group({
      name: [null, Validators.required],
      amount: [null, Validators.required],
    });

  }

  getList() {
    this.shoppingListService.getShoppingListByUserId(1).subscribe(res => {
      this.shoppingList = res;
    });
  }

  onClear() {
    this.shoppingListForm.clear();
  }

  onAdd() {
    const payload = {
      name: this.shoppingListForm.get('name').value,
      amount: this.shoppingListForm.get('amount').value,
      userId: 1
    }
    this.shoppingListService.createShoppingList(payload).subscribe(res => {
      this.toastr.success("Listeye eklendi", this.shoppingListForm.get('name').value);
      this.getList();
    })
  }

  drawLine(item: ShoppingList) {
    const element = document.getElementById("shopping-list-" + item.shoppingId).classList;
    element.contains("selected") ? element.remove("selected") : element.add("selected");
  }

  onDeleteItem(item: ShoppingList) {
    this.shoppingListService.deleteShoppingList(item.shoppingId).subscribe(res => {
      this.toastr.warning("Listeden kaldırıldı", item.name);
      this.getList();
    })
  }
}
