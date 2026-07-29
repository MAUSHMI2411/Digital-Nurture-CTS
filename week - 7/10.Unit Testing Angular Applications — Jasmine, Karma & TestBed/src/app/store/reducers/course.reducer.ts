import { createReducer, on } from '@ngrx/store';

import { initialState } from '../state/course.state';

import * as CourseActions from '../actions/course.actions';

export const courseReducer = createReducer(

  initialState,

  on(CourseActions.addCourse, (state, action) => ({

    ...state,

    courses: [...state.courses, action.course]

  }))

);