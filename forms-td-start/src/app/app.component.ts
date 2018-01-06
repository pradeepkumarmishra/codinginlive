import { Component } from '@angular/core';
import { ElementRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') f:NgForm;
  defaultSecretAnswer="pet";
  answer='';
  genders=['Male','Female'];
  deafaultGender="Male";

  submitForm=false;
  user={
    username:'',
    email:'',
    secretQuestion:'',
    answer:'',
    gender:''
  }
  
  suggestUserName() {
    const suggestedName = 'Superuser';

    this.f.form.patchValue({
      userData:{
        userName:suggestedName
      }
    }
    );
  }

  // onSubmit(form:NgForm){
  //   console.log(form);
  // }

  onSubmit(){
    console.log(this.f);
    this.submitForm=true;

    this.user.username=this.f.value.userData.userName;
    this.user.email=this.f.value.userData.email;
    this.user.secretQuestion=this.f.value.secret;
    this.user.answer=this.f.value.questionAns;
    this.user.gender=this.f.value.gender;

    this.f.form.reset();
  }

  
   
  
}
