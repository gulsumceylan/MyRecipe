import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private auth: AuthService,private fb: FormBuilder,private toastr:ToastrService,private router:Router) {
  }

  ngOnInit(): void {
    this.registerForm=this.fb.group({
      email:["",Validators.required],
      password:["",Validators.required],
    })
  }

  register() {
    if(!this.registerForm.get('email').value || !this.registerForm.get('password').value){
      this.toastr.error("Lütfen formu eksiksiz doldurunuz.");
    }else{
      this.auth.register(this.registerForm.value).subscribe(res=>{
     this.router.navigate(['/login']);
    },err=>{
     this.toastr.error("Hatalı giriş.Bilgilerinizi kontrol edin.");
    })
    }
 }
}
