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

  courses: Course[] = [

    {
      id:1,
      name:'Angular',
      code:'ANG101',
      credits:4,
      gradeStatus:'Available'
    },

    {
      id:2,
      name:'Java',
      code:'JAVA201',
      credits:5,
      gradeStatus:'Available'
    },

    {
      id:3,
      name:'Spring Boot',
      code:'SPR301',
      credits:4,
      gradeStatus:'Available'
    }

  ];
  selectedCourse = "";

onEnroll(id: number) {

  const course = this.courses.find(c => c.id === id);

  if (course) {
    this.selectedCourse = course.name;
    alert("You enrolled in " + course.name);
  }

}
}