import { Course } from '../../models/course';

export interface CourseState {

  courses: Course[];

}

export const initialState: CourseState = {

  courses: []

};