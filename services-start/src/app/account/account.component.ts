import { Component, EventEmitter, Input, Output } from '@angular/core';
import {AccountService} from '../service/account.service'

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
 
})
export class AccountComponent {
  @Input() account: {name: string, status: string};
  @Input() id: number;
  

  constructor(private accountService:AccountService){}

  onSetTo(status: string) {
    this.accountService.updateStatus(this.id,status);
    this.accountService.getLog('A server status changed, new status: ' + status);
    this.accountService.statusChanged.emit(status);
  }
}
