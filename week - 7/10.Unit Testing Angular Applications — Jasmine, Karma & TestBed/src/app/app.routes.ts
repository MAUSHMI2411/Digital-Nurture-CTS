import { Routes } from '@angular/router';

import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollmentForm } from './pages/reactive-enrollment-form/reactive-enrollment-form';
import { authGuard } from './guards/auth-guard';
import { CourseDetails } from './pages/course-details/course-details';
import { UserList } from './pages/user-list/user-list';

export const routes: Routes = [

{
path:'',

component:Home

},

{
path:'courses',

component:CourseList

},

{
path: 'enroll',
component: EnrollmentForm
},

{
path: 'enroll-reactive',
component: ReactiveEnrollmentForm
},

{
path: 'profile',
component: StudentProfile,
canActivate: [authGuard]
},

{
path: 'courses/:id',
component: CourseDetails
},

{
    path:'admin',

    loadComponent:()=>import('./pages/admin/admin')
        .then(m=>m.Admin)
},

{
path:'users',
component:UserList
},

{
path:'**',

redirectTo:''

}

];