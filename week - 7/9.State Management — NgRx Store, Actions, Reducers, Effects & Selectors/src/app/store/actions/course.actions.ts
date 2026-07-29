import { createAction, props } from '@ngrx/store';
import { Course } from '../../models/course';

export const addCourse = createAction(

  '[Course] Add Course',

  props<{ course: Course }>()

);