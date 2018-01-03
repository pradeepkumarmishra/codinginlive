import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx'
import { Observer } from 'rxjs/Observer';
import { Data } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit,OnDestroy {
  numberSubscription:Subscription;
  cutomSubscription:Subscription;
  constructor() { }

  ngOnInit() {
    // const myNumber=Observable.interval(10000);
    //numberSubscription= myNumber.subscribe(
    //   (number:number)=>{
    //       console.log(number);
    //   }
    // )
    // ;

    const myOservable=Observable.create(
      (observer:Observer<string>)=>{
        setTimeout(()=>{observer.next("first packet")}
        ,2000);
        setTimeout(()=>{observer.next("second packet")}
        ,4000);
        setTimeout(()=>{observer.complete()}
        ,6000);
        setTimeout(()=>{observer.next("third packet")}
        ,8000);
      }
      
    );

    this.cutomSubscription=myOservable.subscribe(
      (data:String)=>{console.log(data)},
      (error:String)=>{console.log(error)},
      ()=>{console.log('completed')}
    );
  }

  ngOnDestroy() {
    this.cutomSubscription.unsubscribe();
  }


}
