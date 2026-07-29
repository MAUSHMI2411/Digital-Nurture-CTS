import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-details',
  standalone: true,
  templateUrl: './course-details.html',
  styleUrl: './course-details.css'
})
export class CourseDetails implements OnInit {

  courseId = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {

    this.courseId = this.route.snapshot.paramMap.get('id')!;

  }

}