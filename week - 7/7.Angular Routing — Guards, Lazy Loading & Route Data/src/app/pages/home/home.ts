import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports:[FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  studentName="";

  portalName="Student Course Portal";

  isPortalOpen=true;

  message="";

  enrollNow(){

      this.message="Enrollment Started Successfully";

  }

}