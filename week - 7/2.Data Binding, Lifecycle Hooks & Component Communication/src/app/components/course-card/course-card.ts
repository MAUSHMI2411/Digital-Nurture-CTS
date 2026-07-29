import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnInit,
  OnChanges,
  OnDestroy,
  SimpleChanges
} from '@angular/core';

import { Course } from '../../models/course';

@Component({
  selector: 'app-course-card',
  standalone: true,
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnInit, OnChanges, OnDestroy {

  @Input()
  course!: Course;

  @Output()
  enrollRequested = new EventEmitter<number>();

  imageUrl = "https://angular.dev/assets/images/press-kit/angular_icon_gradient.gif";

  ngOnInit() {
    console.log("CourseCard Initialized");
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log("Course Changed", changes);
  }

  ngOnDestroy() {
    console.log("CourseCard Destroyed");
  }

  enroll() {
    this.enrollRequested.emit(this.course.id);
  }

}