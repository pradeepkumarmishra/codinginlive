import { Component, EventEmitter, Input, Output } from '@angular/core';
import { UsersService } from '../services/service.users';
import { CounterService } from '../services/service.counter';

@Component({
  selector: 'app-active-users',
  templateUrl: './active-users.component.html',
  styleUrls: ['./active-users.component.css']
})
export class ActiveUsersComponent {
  @Input() users: string[];

  constructor(private userService:UsersService,
              private counterService:CounterService){}
  onSetToInactive(id: number) {
    this.userService.onSetToInactive(id);
    this.counterService.inActiveCount.emit();
  }
}
