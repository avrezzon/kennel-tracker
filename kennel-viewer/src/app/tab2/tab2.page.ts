import { Component, OnInit } from '@angular/core';
import { KennelService } from '../kennel.service';
import { MOCK_KENNEL_LAYOUT } from '../mock-kennel';
import { Kennel } from '../models/Kennel';
import { Pet } from '../models/Pet';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit{

  kennelLayout ?: Kennel[];
  kennelFilterMatch: Kennel[];
  petFilter?: string;

  constructor(
    public kennelService: KennelService
  ) {}

  ngOnInit(): void {
    this.kennelFilterMatch = MOCK_KENNEL_LAYOUT;
  }

  search(value: string) {
    console.log(value);
    this.petFilter = value;
    this.kennelFilterMatch = this.petFilter ? this.performFilter(this.petFilter) : this.kennelService.kennelLayout;
  }

  performFilter(petFilter: string) {
    petFilter = petFilter.toLocaleLowerCase();
    return this.kennelService.kennelLayout
      .filter((kennel: Kennel) => kennel.pet.name.toLocaleLowerCase().includes(petFilter));
  }

}
