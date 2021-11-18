import { Component, OnInit } from '@angular/core';
import { KennelService } from '../kennel.service';
import { MOCK_KENNEL_LAYOUT } from '../mock-kennel';
import { Kennel } from '../models/Kennel';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit{

  kennelLayout ?: Kennel[];

  constructor(
    public kennelService: KennelService
  ) {}

  ngOnInit(): void {
    this.kennelLayout = MOCK_KENNEL_LAYOUT;
  }

}
