import { createFeatureSelector, createSelector } from '@ngrx/store';

import { CourseState } from '../state/course.state';

export const selectCourseState =

createFeatureSelector<CourseState>('courses');

export const selectCourses =

createSelector(

selectCourseState,

state => state.courses

);