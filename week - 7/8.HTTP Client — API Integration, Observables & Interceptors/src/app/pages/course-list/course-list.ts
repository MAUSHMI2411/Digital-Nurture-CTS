import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OnInit } from '@angular/core';

import { CourseCard } from '../../components/course-card/course-card';
import { Course } from '../../models/course';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit{
  constructor(private courseService: CourseService) {}

  selectedCourse = "";

  courses: Course[] = [];
  ngOnInit() {
    this.courses = this.courseService.getCourses();
  }

  onEnroll(id: number) {

    const course = this.courses.find(c => c.id === id);

    if (course) {

      this.selectedCourse = course.name;

      alert("Successfully enrolled in " + course.name);

    }

  }

  addNewCourse() {

  this.courseService.addCourse({

    id: 4,
    name: 'React',

    code: 'REA401',

    credits: 4,

    fee: 800,

    startDate: new Date(),

    gradeStatus: 'Available',

    available: true,

    category: 'Frontend'

  });

  this.courses = this.courseService.getCourses();

}

}