import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { KennelService } from '../kennel.service';
import { MOCK_CHECKED_OUT_PETS, MOCK_SEARCHED_PETS } from '../mock-kennel';
import { Pet } from '../models/Pet';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  petFilterMatch: Pet[] = [];
  checkedOutPets: Pet[] = [];

  _petFilter: string = '';

  get petFilter(){
    return this._petFilter;
  }

  set petFilter(value: string){
    this._petFilter = value
  }

  constructor(public kennelService: KennelService) {}
  
  
  ngOnInit(): void {
    this.petFilterMatch = MOCK_SEARCHED_PETS;
    this.checkedOutPets = MOCK_CHECKED_OUT_PETS;
  }

  search(name: string){
    console.log(name);
  }

}
