import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';

import {
  provideHttpClient,
  withInterceptors
} from '@angular/common/http';

import { loggingInterceptor } from './interceptors/logging-interceptor';

import { provideStore } from '@ngrx/store';

import { courseReducer } from './store/reducers/course.reducer';

export const appConfig: ApplicationConfig = {
  providers: [

provideBrowserGlobalErrorListeners(),

provideRouter(routes),

provideHttpClient(
withInterceptors([
loggingInterceptor
])
),

provideStore({

courses: courseReducer

})

]
};