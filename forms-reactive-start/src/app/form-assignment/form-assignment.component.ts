import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';


@Component({
  selector: 'app-form-assignment',
  templateUrl: './form-assignment.component.html',
  styleUrls: ['./form-assignment.component.css']
})
export class FormAssignmentComponent implements OnInit {
myForm:FormGroup;
disableBtn=false;
validateName=['Test','test'];
  constructor() { }

  ngOnInit() {
    this.myForm=new FormGroup(
    { 'projectname':new FormControl(null,[Validators.required,this.nameValidator.bind(this)]),
      'mail':new FormControl(null,[Validators.required,Validators.email]),
      'projectstatus':new FormControl('critical')
    }
    );
  }

  Synchronous
  nameValidator(control:FormControl):{[s:string]:boolean}{
    if(this.validateName.indexOf(control.value)!=-1){
    return {'nameIsNotAllowed':true}
    }
  }

  // //Asynchronous
  // nameValidator(control:FormControl):Promise<any>|Observable<any>{
  //   const promise=new Promise<any>(
  //     (resolve,reject)=>{
  //      setTimeout(()=>{
  //       if(this.validateName.indexOf(control.value)!=-1){
  //        resolve({'nameIsNotAllowed':true})}
  //        else{
  //          resolve(null);
  //        }
  //      },3500);
  //     }
  //   );
  //   return promise;
  // }

  onSubmit(){
    console.log(this.myForm);
    this.myForm.valueChanges.subscribe(
      (value)=>{console.log(value)}
    );
  }

}
