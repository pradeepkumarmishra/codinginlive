import {EventEmitter,Output} from '@angular/core'
export class AccountService{

    accounts = [
        {
          name: 'Master Account',
          status: 'active'
        },
        {
          name: 'Testaccount',
          status: 'inactive'
        },
        {
          name: 'Hidden Account',
          status: 'unknown'
        }
      ];
     
      @Output() statusChanged=new EventEmitter<String>();
      addAccount(name:string,status:string){
        this.accounts.push( {name:name,status:status});
      }

      updateStatus(id:number,status:string){
        this.accounts[id].status= status;  
      }
    
    getLog(param:String){
        console.log("log from service:"+param);
    }
}