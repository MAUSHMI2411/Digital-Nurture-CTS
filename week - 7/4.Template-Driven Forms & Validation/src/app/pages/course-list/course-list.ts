import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseCard } from '../../components/course-card/course-card';
import { Course } from '../../models/course';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList {

  selectedCourse = "";

  courses: Course[] = [

    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      fee: 500,
      startDate: new Date('2026-08-01'),
      gradeStatus: 'Available',
      available: true,
      category: 'Frontend'
    },

    {
      id: 2,
      name: 'Java',
      code: 'JAVA201',
      credits: 5,
      fee: 650,
      startDate: new Date('2026-08-10'),
      gradeStatus: 'Available',
      available: true,
      category: 'Backend'
    },

    {
      id: 3,
      name: 'Spring Boot',
      code: 'SPR301',
      credits: 4,
      fee: 700,
      startDate: new Date('2026-08-15'),
      gradeStatus: 'Closed',
      available: false,
      category: 'Backend'
    }

  ];

  onEnroll(id: number) {

    const course = this.courses.find(c => c.id === id);

    if (course) {

      this.selectedCourse = course.name;

      alert("Successfully enrolled in " + course.name);

    }

  }

}