import { Contact } from "./Contact";

export interface Client extends Contact{

    shelterType: string;
    bedNumber: number;
    clientId: number;

};