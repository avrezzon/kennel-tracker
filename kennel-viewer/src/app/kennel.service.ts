import { Injectable } from '@angular/core';
import { MOCK_KENNEL_LAYOUT } from './mock-kennel';
import { Client } from './models/Client';
import { Kennel } from './models/Kennel';
import { Pet } from './models/Pet';

@Injectable({
  providedIn: 'root'
})
export class KennelService {

  availableKennels: number;
  kennelLayout: Kennel[] =  MOCK_KENNEL_LAYOUT;;
  pets: Pet[];
  owners: Client[];
  checkOutDuration: number = 30;
  maxTimeInKennel: number = 180;
    
  checkedOutPets: Set<Pet>;
  petsApproachingTimeWindow: Set<Pet>;

  nextPetId: number;
  nextEmergencyId: number;

  constructor() {
    this.getKennel();
   }

  getKennel(){
    this.kennelLayout = MOCK_KENNEL_LAYOUT;
    this.pets = MOCK_KENNEL_LAYOUT.map(x => x.pet);
    console.log(this.pets);
    //this.owners = MOCK_KENNEL_LAYOUT.map(x => x.pet)
  }

  registerPet(petRegistration: any){
    
  }
}

