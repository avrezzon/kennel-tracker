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
  petFilter: string = '';
  checkedOutPets: Pet[] = [];
  

  constructor(public kennelService: KennelService) {}
  
  
  ngOnInit(): void {
    this.petFilterMatch = [];
    this.checkedOutPets = MOCK_CHECKED_OUT_PETS;
  }

  search(value: string){
    console.log(value);
    this.petFilter = value;
    this.petFilterMatch = this.petFilter ? this.performFilter(this.petFilter) : [];
  }

  performFilter(petFilter: string){
    petFilter = petFilter.toLocaleLowerCase();
    return this.kennelService.pets
      .filter((pet: Pet) => pet.name.toLocaleLowerCase().includes(petFilter));
  }

  checkIn(pet: Pet){
    console.log(pet.name)
    console.log(new Date());
    this.checkedOutPets = [...this.checkedOutPets].filter(x => x.name.toLocaleLowerCase() !== pet.name.toLocaleLowerCase())
  }

  checkOut(pet: Pet){
    console.log(pet.name)
    console.log(new Date());
    this.checkedOutPets.push(pet);
  }

}
