import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';

import { CourseDetails } from './course-details';

describe('CourseDetails', () => {

  let component: CourseDetails;
  let fixture: ComponentFixture<CourseDetails>;

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [CourseDetails],

      providers: [

        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              paramMap: {
                get: () => '1'
              }
            }
          }
        }

      ]

    }).compileComponents();

    fixture = TestBed.createComponent(CourseDetails);

    component = fixture.componentInstance;

    fixture.detectChanges();

  });

  it('should create', () => {

    expect(component).toBeTruthy();

  });

});