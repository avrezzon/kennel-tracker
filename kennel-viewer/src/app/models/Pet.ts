import { CheckIn } from "./CheckIn";
import { EmergencyContact } from "./EmergencyContact";
import { Client } from "./Client";

export interface Pet{
    id: number;
    name: string;
    type: string; // Potential enum, default to dog normally
    breed: string; 
    age: number;
    owners: Client[];
    emergencyContacts: EmergencyContact[];
    checkIns: CheckIn[];
    violations: number;
}