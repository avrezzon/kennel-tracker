import { Kennel } from "./models/Kennel";
import { Pet } from "./models/Pet";

export const MOCK_KENNEL_LAYOUT: Kennel[] = [
    {
        cageNumber: 1,
        pet: {
            id: 1,
            name: 'Wolfy',
            type: 'Dog',
            breed: 'BestBoi',
            age: 12,
            owners: [
                {
                    firstName: 'Tom',
                    lastName: 'Doe',
                    phone: '7191112222',
                    clientId: 8000,
                    shelterType: 'Entry',
                    bedNumber: 1
                }
            ],
            emergencyContacts: [
                {
                    firstName: 'Some',
                    lastName: 'One',
                    phone: '7191112224',
                    id: 1
                }
            ],
            checkIns: [], //TODO
            violations: 0
        }
    },
    {
        cageNumber: 2,
        pet: {
            id: 2,
            name: 'Aspen',
            type: 'Dog',
            breed: 'German Shepard',
            age: 12,
            owners: [
                {
                    firstName: 'John',
                    lastName: 'Smith',
                    phone: '719333666',
                    clientId: 8001,
                    shelterType: 'Entry',
                    bedNumber: 2
                },
                {
                    firstName: 'Haley',
                    lastName: 'Smith',
                    phone: '7193237722',
                    clientId: 8003,
                    shelterType: 'Entry',
                    bedNumber: 3
                }
            ],
            emergencyContacts: [
                {
                    firstName: 'Some',
                    lastName: 'One',
                    phone: '7191112224',
                    id: 1
                }
            ],
            checkIns: [], //TODO
            violations: 0
        }
    },
    {
        cageNumber: 3,
        pet: {
            id: 3,
            name: 'Teddy P',
            type: 'Dog',
            breed: 'Log',
            age: 12,
            owners: [
                {
                    firstName: 'Anthony',
                    lastName: 'Smith',
                    phone: '719333666',
                    clientId: 8001,
                    shelterType: 'Entry',
                    bedNumber: 2
                },
                {
                    firstName: 'Haley',
                    lastName: 'Smith',
                    phone: '7193237722',
                    clientId: 8003,
                    shelterType: 'Entry',
                    bedNumber: 3
                }
            ],
            emergencyContacts: [
                {
                    firstName: 'Some',
                    lastName: 'One',
                    phone: '7191112224',
                    id: 1
                }
            ],
            checkIns: [], //TODO
            violations: 0
        }
    },
    {
        cageNumber: 4,
        pet: {
            id: 4,
            name: 'Dixe',
            type: 'Dog',
            breed: 'Lab',
            age: 12,
            owners: [
                {
                    firstName: 'Anthony',
                    lastName: 'Smith',
                    phone: '719333666',
                    clientId: 8001,
                    shelterType: 'Entry',
                    bedNumber: 2
                },
                {
                    firstName: 'Haley',
                    lastName: 'Smith',
                    phone: '7193237722',
                    clientId: 8003,
                    shelterType: 'Entry',
                    bedNumber: 3
                }
            ],
            emergencyContacts: [
                {
                    firstName: 'Some',
                    lastName: 'One',
                    phone: '7191112224',
                    id: 1
                }
            ],
            checkIns: [], //TODO
            violations: 0
        }
    },
    {
        cageNumber: 5,
        pet: {
            id: 5,
            name: 'MeMe',
            type: 'Dog',
            breed: 'Shiba',
            age: 5,
            owners: [
                {
                    firstName: 'Eli',
                    lastName: 'Will',
                    phone: '7193325686',
                    clientId: 8004,
                    shelterType: 'Entry',
                    bedNumber: 2
                }
            ],
            emergencyContacts: [
                {
                    firstName: 'Some',
                    lastName: 'One',
                    phone: '7191112224',
                    id: 1
                }
            ],
            checkIns: [], //TODO
            violations: 0
        }
    }
];


export const MOCK_SEARCHED_PETS: Pet[] = [
    {
        id: 1,
        name: 'Wolfy',
        type: 'Dog',
        breed: 'BestBoi',
        age: 12,
        owners: [
            {
                firstName: 'Tom',
                lastName: 'Doe',
                phone: '7191112222',
                clientId: 8000,
                shelterType: 'Entry',
                bedNumber: 1
            }
        ],
        emergencyContacts: [
            {
                firstName: 'Some',
                lastName: 'One',
                phone: '7191112224',
                id: 1
            }
        ],
        checkIns: [], //TODO
        violations: 0
    },
    {
        id: 5,
        name: 'MeMe',
        type: 'Dog',
        breed: 'Shiba',
        age: 5,
        owners: [
            {
                firstName: 'Eli',
                lastName: 'Will',
                phone: '7193325686',
                clientId: 8004,
                shelterType: 'Entry',
                bedNumber: 2
            }
        ],
        emergencyContacts: [
            {
                firstName: 'Some',
                lastName: 'One',
                phone: '7191112224',
                id: 1
            }
        ],
        checkIns: [], //TODO
        violations: 0
    }

];


export const MOCK_CHECKED_OUT_PETS: Pet[] = [
    {
        id: 1,
        name: 'Wolfy',
        type: 'Dog',
        breed: 'BestBoi',
        age: 12,
        owners: [
            {
                firstName: 'Tom',
                lastName: 'Doe',
                phone: '7191112222',
                clientId: 8000,
                shelterType: 'Entry',
                bedNumber: 1
            }
        ],
        emergencyContacts: [
            {
                firstName: 'Some',
                lastName: 'One',
                phone: '7191112224',
                id: 1
            }
        ],
        checkIns: [], //TODO
        violations: 0
    },
    {
        id: 5,
        name: 'MeMe',
        type: 'Dog',
        breed: 'Shiba',
        age: 5,
        owners: [
            {
                firstName: 'Eli',
                lastName: 'Will',
                phone: '7193325686',
                clientId: 8004,
                shelterType: 'Entry',
                bedNumber: 2
            }
        ],
        emergencyContacts: [
            {
                firstName: 'Some',
                lastName: 'One',
                phone: '7191112224',
                id: 1
            }
        ],
        checkIns: [], //TODO
        violations: 0
    }

];