import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OnInit } from '@angular/core';

import { CourseCard } from '../../components/course-card/course-card';
import { Course } from '../../models/course';
import { CourseService } from '../../services/course';

import { Store } from '@ngrx/store';

import * as CourseActions from '../../store/actions/course.actions';

import { selectCourses } from '../../store/selectors/course.selectors';
@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit{
  constructor(private courseService: CourseService,private store: Store) {}

  selectedCourse = "";

  courses: Course[] = [];
  ngOnInit() {
    this.courses = this.courseService.getCourses();
    this.store.select(selectCourses)

    .subscribe(data=>{

    console.log(data);

    });
  }

  onEnroll(id: number) {

    const course = this.courses.find(c => c.id === id);

    if (course) {

      this.selectedCourse = course.name;

      alert("Successfully enrolled in " + course.name);

    }

  }

  addNewCourse(){

const course={

id:100,

name:'Angular Advanced',

code:'ANG500',

credits:5,

fee:900,

startDate:new Date(),

gradeStatus:'Available',

available:true,

category:'Frontend'

};

this.store.dispatch(

CourseActions.addCourse({

course

})

);

}

}