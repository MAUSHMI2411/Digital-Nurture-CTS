import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseCard } from './course-card';

describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [CourseCard]

    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);

    component = fixture.componentInstance;

    component.course = {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      fee: 500,
      startDate: new Date(),
      gradeStatus: 'Available',
      available: true,
      category: 'Frontend'
    };

    fixture.detectChanges();

  });

  it('should create', () => {

    expect(component).toBeTruthy();

  });

});