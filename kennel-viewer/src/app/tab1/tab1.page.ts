import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { AlertController } from '@ionic/angular';
import { timer } from 'rxjs';
import { KennelService } from '../kennel.service';
import { MOCK_CHECKED_OUT_PETS, MOCK_SEARCHED_PETS } from '../mock-kennel';
import { Pet } from '../models/Pet';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  petFilterMatch: Pet[];
  petFilter: string = '';
  checkedOutPets: Set<Pet>;
  petsApproachingTimeWindow: Set<Pet>;
  maxTimeInKennel: number;
  checkOutDuration: number;
  timeWindow: number;

  constructor(public kennelService: KennelService,
    public alertCtrl: AlertController) { }


  ngOnInit(): void {
    this.petFilterMatch = [];
    this.checkedOutPets = new Set();
    this.petsApproachingTimeWindow = new Set();
    this.maxTimeInKennel = 180;
    this.checkOutDuration = .1;
    this.timeWindow = 5;
  }

  search(value: string) {
    console.log(value);
    this.petFilter = value;
    this.petFilterMatch = this.petFilter ? this.performFilter(this.petFilter) : [];
  }

  performFilter(petFilter: string) {
    petFilter = petFilter.toLocaleLowerCase();
    return this.kennelService.pets
      .filter((pet: Pet) => pet.name.toLocaleLowerCase().includes(petFilter));
  }

  async checkIn(pet: Pet) {
    console.log('Checking in pet')

    const currentTime = new Date();
    const history = pet.checkIns;

    //get the last checkout time
    //is the new checkin time in the 30 minute window?
    //Yes error
    //No
    //set the check in time to curr time
    //update a new checkout window 3 hours from now

    let lastRecord = history.pop();
    const earliestCheckIn = this.getTimeOffset(this.checkOutDuration, lastRecord.actualCheckOut || lastRecord.checkOut);


    if (currentTime.getTime() < earliestCheckIn.getTime()) {
      await this.generateAlert('Pet must be out of kennel for at least ' + this.checkOutDuration + ' minutes before check in',
        'Check In');
      history.push(lastRecord);
    } else {
      lastRecord.checkIn = currentTime;
      history.push(lastRecord);

      let nextCheckoutTime = this.getTimeOffset(this.maxTimeInKennel, lastRecord.actualCheckOut || lastRecord.checkOut);
      history.push({
        checkOut: nextCheckoutTime
      });

      this.checkedOutPets.delete(pet);
      console.log(pet);
    }
    this.petFilter = '';

  }

  checkOut(pet: Pet) {
    if (!this.checkedOutPets.has(pet)) {
      console.log('Checking out pet')

      const history = pet.checkIns;

      let lastRecord = history.pop();
      lastRecord.actualCheckOut = new Date();

      history.push(lastRecord);

      console.log(pet);
      this.checkedOutPets.add(pet);
    }
    this.petFilter = '';
  }


  petsCloseToCheckout(){
    //This is something that will be delegated to a hearbeat event from the timesheet-service
  }


  getTimeOffset(minutes: number, from: Date): Date {
    return new Date(from.getTime() + minutes * 60000);
  }

  async generateAlert(message: string, operation: string) {
    const alert = await this.alertCtrl.create({
      header: 'Alert: Cannot Perform ' + operation,
      message: message,
      buttons: ['OK']
    });
    await alert.present();
    const result = await alert.onDidDismiss();
    console.log(result);
  }

}
