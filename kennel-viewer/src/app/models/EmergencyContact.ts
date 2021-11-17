import { Contact } from "./Contact";

//Emergency contact cannot be a client
export interface EmergencyContact extends Contact{
    id: number;
};