import { Kennel } from "./contracts/kennel"
import { Pet } from "./contracts/pet"

export const KENNELS: Kennel[] = [
    { id: 1, pet: {
        id: 1,
        name: 'fluffy',
        petType: 'Dog'
    }},
    { id: 2, pet: {
        id: 2,
        name: 'yoshi',
        petType: 'Dog'
    }},
    { id: 3, pet: {
        id: 12,
        name: 'Doge',
        petType: 'Dog'
    }}
]