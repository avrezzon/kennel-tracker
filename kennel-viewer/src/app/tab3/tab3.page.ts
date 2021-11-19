import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit {

  debug: boolean = false;

  petForm = this.fb.group({
    // TODO find a way to generate new id, maybe have that as a token from the server
    name: ['', Validators.required, Validators.minLength(2), Validators.maxLength(20)],
    type: ['', Validators.required],
    breed: ['', Validators.required],
    age: ['', Validators.required],
    owners: this.fb.array([
      this.fb.group({
        clientId: ['', Validators.required],
        firstName: ['', Validators.required, Validators.minLength(3), Validators.maxLength(20)],
        lastName: ['', Validators.required, Validators.minLength(2), Validators.maxLength(20)],
        phone: ['', Validators.required],
        shelterType: [''],
        bedNumber: ['']
      })
    ]),
    emergencyContacts: this.fb.array([
      this.fb.group({
        id: ['', Validators.required],
        firstName: ['', Validators.required, Validators.minLength(3), Validators.maxLength(20)],
        lastName: ['', Validators.required, Validators.minLength(2), Validators.maxLength(20)],
        phone: ['', Validators.required],
      })
    ]),
  });

  constructor(private fb: FormBuilder) { }

  ngOnInit() {

  }

  onSubmit() {
    console.log(this.petForm);
  }

  get owners() {
    return this.petForm.get('owners') as FormArray;
  }

  addOwner() {
    this.owners.push(this.newOwner());
  }

  removeOwner(index){
    this.owners.removeAt(index);
  }

  newOwner() {
    return this.fb.group({
      clientId: ['', Validators.required],
      firstName: ['', Validators.required, Validators.minLength(3), Validators.maxLength(20)],
      lastName: ['', Validators.required, Validators.minLength(2), Validators.maxLength(20)],
      phone: ['', Validators.required],
      shelterType: [''],
      bedNumber: ['']
    });
  }

  get emergencyContacts() {
    return this.petForm.get('emergencyContacts') as FormArray;
  }

  addEmergencyContact() {
    this.emergencyContacts.push(this.newOwner());
  }

  removeEmergencyContact(index){
    this.emergencyContacts.removeAt(index);
  }

  newEmergencyContact() {
    return this.fb.group({
      id: ['', Validators.required],
      firstName: ['', Validators.required, Validators.minLength(3), Validators.maxLength(20)],
      lastName: ['', Validators.required, Validators.minLength(2), Validators.maxLength(20)],
      phone: ['', Validators.required],
    });
  }

  


}
