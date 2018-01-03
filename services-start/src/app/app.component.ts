import { Component ,OnInit} from '@angular/core';
import { AccountService } from 'app/service/account.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[AccountService]
})
export class AppComponent implements OnInit{
  accounts:{name:string,status:string}[]=[];
  constructor(private accountService:AccountService){
      this.accountService.statusChanged.subscribe(
        (status:String)=>{alert(status)}
    );
  }

  ngOnInit(){
    this.accounts=this.accountService.accounts;
  }
  
  
}
