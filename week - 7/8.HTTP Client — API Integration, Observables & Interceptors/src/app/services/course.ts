import { Injectable } from '@angular/core';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [

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
      fee: 700,
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
      fee: 650,
      startDate: new Date('2026-08-20'),
      gradeStatus: 'Closed',
      available: false,
      category: 'Backend'
    }

  ];

  getCourses(): Course[] {
    return this.courses;
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }

}