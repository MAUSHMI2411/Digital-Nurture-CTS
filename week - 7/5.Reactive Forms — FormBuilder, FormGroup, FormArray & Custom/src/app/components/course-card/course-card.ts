import {
Component,
Input,
Output,
EventEmitter,
OnInit,
OnChanges,
OnDestroy,
SimpleChanges
}
from '@angular/core';

import { CommonModule } from '@angular/common';

import { Course } from '../../models/course';

import { GradeStatusPipe } from '../../pipes/grade-status-pipe';

import { HighlightDirective } from '../../directives/highlight';

import { CardHoverDirective } from '../../directives/card-hover';

@Component({

selector:'app-course-card',

standalone:true,

imports:[CommonModule,GradeStatusPipe,HighlightDirective,CardHoverDirective],

templateUrl:'./course-card.html',

styleUrl:'./course-card.css'

})

export class CourseCard implements OnInit,OnChanges,OnDestroy{

@Input()

course!:Course;

@Output()

enrollRequested=new EventEmitter<number>();

imageUrl="https://angular.dev/assets/images/press-kit/angular_icon_gradient.gif";

ngOnInit(){

console.log("Card Initialized");

}

ngOnChanges(changes:SimpleChanges){

console.log(changes);

}

ngOnDestroy(){

console.log("Destroyed");

}

enroll(){

this.enrollRequested.emit(this.course.id);

}

}