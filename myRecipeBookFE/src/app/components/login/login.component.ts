import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { FormControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private auth: AuthService,private fb: FormBuilder,private toastr:ToastrService,private router:Router) {
  }

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      email:["",Validators.required],
      password:["",Validators.required],
    })
  }

  login() {
    if(!this.loginForm.get('email').value || !this.loginForm.get('password').value){
      this.toastr.error("Please fill out the form completely.");
    }else{
     this.auth.login(this.loginForm.value).subscribe(res=>{
      this.router.navigate(['/recipes']);
     },err=>{
      this.toastr.error("Incorrect login. Check your information.");
     })
    }
  }

}
