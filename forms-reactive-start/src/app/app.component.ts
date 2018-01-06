import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  genders = ['male', 'female'];
  signUpForm:FormGroup;
  forBiddenUserNames=['Anna','Max','pradeep'];

ngOnInit(){
  this.signUpForm=new FormGroup(
    {userData:new FormGroup(
      {'username':new FormControl(null,[Validators.required,this.forBiddenNamesValidation.bind(this)]),
       'email':new FormControl(null,[Validators.required,Validators.email])
      }),
    'gender':new FormControl('male',Validators.required),
    'hobbies':new FormArray([])
    })
}

onSubmit(){
  console.log(this.signUpForm);

}
onAddHobbies(){
  const formControl=new FormControl(null,Validators.required);
  (<FormArray>this.signUpForm.get('hobbies')).push(formControl);
}

forBiddenNamesValidation(control:FormControl): {[s:string]:boolean}{
  if(this.forBiddenUserNames.indexOf(control.value)!=-1){
    return {'nameIsForbidden':true};
  }
  return null;
}

}
