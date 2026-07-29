import { Component, OnInit } from '@angular/core';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
  FormArray,
  FormControl,
  AbstractControl,
  ValidationErrors
} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: ['', [Validators.required, Validators.minLength(3)]],

      studentEmail: ['', [Validators.required, Validators.email]],

      courseId: ['', [Validators.required, this.noCourseCode]],

      preferredSemester: ['Odd', Validators.required],

      agreeToTerms: [false, Validators.requiredTrue],

      additionalCourses: this.fb.array([])

    });

  }

  noCourseCode(control: AbstractControl): ValidationErrors | null {

    const value = control.value;

    if (value && value.toString().startsWith('XX')) {

      return { noCourseCode: true };

    }

    return null;

  }

  get additionalCourses(): FormArray<FormControl> {

    return this.enrollForm.get('additionalCourses') as FormArray<FormControl>;

  }

  addCourse() {

    this.additionalCourses.push(
      new FormControl<string>('', {
        nonNullable: true,
        validators: Validators.required
      })
    );

  }

  removeCourse(index: number) {

    this.additionalCourses.removeAt(index);

  }

  submit() {

    console.log(this.enrollForm.value);

    console.log(this.enrollForm.getRawValue());

  }

}