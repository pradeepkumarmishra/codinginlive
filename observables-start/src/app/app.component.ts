import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { UserService } from './user/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  user1Activate=false;
  user2Activated=false;
  constructor(private userService:UserService){}

  ngOnInit() {
    this.userService.activated.subscribe(
      (id:number)=>{
        console.log(id);
          if(id==1){
            this.user1Activate=true;
          }else if(id==2){
            this.user2Activated=true;
          }
      }
    );
  }
  
}
