import { Component } from '@angular/core';
import { ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
@ViewChild('fm') fm:NgForm;
  defaultSubscription="advance";

  subscription={
    subscriberMail:'',
    subscriptionName:'',
    password:''
  }

  onSubmit(){
    console.log(this.fm);
    this.subscription.subscriberMail=this.fm.value.mail;
    this.subscription.subscriptionName=this.fm.value.subscription;
    this.subscription.password=this.fm.value.pwd;
  }

}
