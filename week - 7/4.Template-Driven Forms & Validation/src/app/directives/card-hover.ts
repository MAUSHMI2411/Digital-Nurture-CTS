import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCardHover]',
  standalone: true
})
export class CardHoverDirective {

  constructor(private el: ElementRef) {}

  @HostListener('mouseenter')
  onEnter() {
    this.el.nativeElement.style.transform = 'scale(1.05)';
    this.el.nativeElement.style.transition = '0.3s';
  }

  @HostListener('mouseleave')
  onLeave() {
    this.el.nativeElement.style.transform = 'scale(1)';
  }

}