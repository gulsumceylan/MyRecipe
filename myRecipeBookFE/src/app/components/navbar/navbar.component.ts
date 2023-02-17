import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    const hamburger: any = document.querySelector('.header .nav-bar .nav-list .hamburger');
    const mobile_menu: any = document.querySelector('.header .nav-bar .nav-list ul');
    const menu_item: any = document.querySelectorAll('.header .nav-bar .nav-list ul li a')
    const header: any = document.querySelector('.header.container2');

    hamburger.addEventListener('click', () => {
      hamburger.classList.toggle('active');
      mobile_menu.classList.toggle('active');
    })

    menu_item.forEach((item: any) => {
      item.addEventListener('click', () => {
        hamburger.classList.toggle('active');
        mobile_menu.classList.toggle('active');
      })
    })
  }

  logout() {

  }

}
