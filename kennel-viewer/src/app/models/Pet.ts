import { TimeRecord } from "./TimeRecord";
import { EmergencyContact } from "./EmergencyContact";
import { Client } from "./Client";

export interface Pet{
    id: number; //Find some way to generate the value
    name: string;
    type: string; // Potential enum, default to dog normally
    breed: string; 
    age: number;
    owners: Client[];
    emergencyContacts: EmergencyContact[];
    checkIns: TimeRecord[];
    violations: number;
}