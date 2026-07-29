import { Component } from '@angular/core';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile {

  name="Raghu";

  department="Computer Science";

  cgpa=8.9;

}