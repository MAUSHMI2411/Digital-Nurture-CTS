import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'courseFilter',
})
export class CourseFilterPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }
}
