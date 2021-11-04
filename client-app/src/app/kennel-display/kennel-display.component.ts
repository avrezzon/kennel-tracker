import { Component, OnInit } from '@angular/core';
import { Kennel } from '../contracts/kennel';
import { KENNELS } from '../mock-kennel';

@Component({
  selector: 'app-kennel-display',
  templateUrl: './kennel-display.component.html',
  styleUrls: ['./kennel-display.component.css']
})
export class KennelDisplayComponent implements OnInit {

  kennelLayout: Kennel[] = KENNELS;
  display: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  toggelDisplay(): void{
    this.display = !this.display;
  }

}
