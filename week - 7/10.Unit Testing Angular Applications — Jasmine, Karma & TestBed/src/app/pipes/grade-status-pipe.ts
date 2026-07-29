import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gradeStatus',
  standalone: true
})
export class GradeStatusPipe implements PipeTransform {

  transform(value: string): string {

    if (value === 'Available') {

      return '🟢 Available';

    }

    return '🔴 Closed';

  }

}