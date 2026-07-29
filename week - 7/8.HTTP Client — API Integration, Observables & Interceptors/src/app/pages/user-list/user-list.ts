import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ApiService } from '../../services/api';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.html',
  styleUrl: './user-list.css'
})
export class UserList implements OnInit {

  users: any[] = [];

  constructor(private api: ApiService) {}

  ngOnInit(): void {

    this.api.getUsers().subscribe((data: any) => {

      this.users = data;

    });

  }

}