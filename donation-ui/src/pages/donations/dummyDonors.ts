export interface Donor {
    id: string;
    name: string;
    email: string;
    mobile: string;
    bloodType?: string;
    organDonor?: boolean;
    donationDate?: string;
}

export const dummyDonors: Donor[] = [
    {
        id: "1",
        name: "Alice Johnson",
        email: "alice@example.com",
        mobile: "1234567890",
        bloodType: "A+",
        organDonor: true,
        donationDate: "2025-09-01"
    },
    {

        id: "2",
        name: "Bob Smith",
        email: "bob@example.com",
        mobile: "9876543210",
        bloodType: "O-",
        organDonor: false,
        donationDate: "2025-08-20"
    },
    {
        id: "3",
        name: "Carol Lee",
        email: "carol@example.com",
        mobile: "5551234567",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2025-07-15"
    },
    {
        id: "4",
        name: "David Kim",
        email: "david.kim@example.com",
        mobile: "4445556666",
        bloodType: "AB-",
        organDonor: false,
        donationDate: "2025-06-10"
    },
    {

        id: "5",
        name: "Eva Green",
        email: "eva.green@example.com",
        mobile: "3332221111",
        bloodType: "O+",
        organDonor: true,
        donationDate: "2025-05-22"
    },
    {
        id: "6",
        name: "Frank Miller",
        email: "frank.miller@example.com",
        mobile: "2223334444",
        bloodType: "A-",
        organDonor: false,
        donationDate: "2025-04-18"
    },
    {
        id: "7",
        name: "Grace Lee",
        email: "grace.lee@example.com",
        mobile: "1112223333",
        bloodType: "B-",
        organDonor: true,
        donationDate: "2025-03-30"
    },
    {
        id: "8",
        name: "Henry Ford",
        email: "henry.ford@example.com",
        mobile: "9998887777",
        bloodType: "AB+",
        organDonor: false,
        donationDate: "2025-02-14"
    },
    {
        id: "9",
        name: "Ivy Chen",
        email: "ivy.chen@example.com",
        mobile: "8887776666",
        bloodType: "O-",
        organDonor: true,
        donationDate: "2025-01-05"
    },
    {
        id: "10",
        name: "Jack Brown",
        email: "jack.brown@example.com",
        mobile: "7776665555",
        bloodType: "A+",
        organDonor: false,
        donationDate: "2024-12-25"
    },
    {
        id: "11",
        name: "Kathy White",
        email: "kathy.white@example.com",
        mobile: "6665554444",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2024-11-11"
    },
    {
        id: "12",
        name: "Leo Black",
        email: "leo.black@example.com",
        mobile: "5554443333",
        bloodType: "O+",
        organDonor: false,
        donationDate: "2024-10-02"
    },
    {
        id: "13",
        name: "Alice Johnson",
        email: "alice@example.com",
        mobile: "1234567890",
        bloodType: "A+",
        organDonor: true,
        donationDate: "2025-09-01"
    },
    {
        id: "14",
        name: "Bob Smith",
        email: "bob@example.com",
        mobile: "9876543210",
        bloodType: "O-",
        organDonor: false,
        donationDate: "2025-08-20"
    },
    {
        id: "15",
        name: "Carol Lee",
        email: "carol@example.com",
        mobile: "5551234567",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2025-07-15"
    },
    {
        id: "16",
        name: "David Kim",
        email: "david.kim@example.com",
        mobile: "4445556666",
        bloodType: "AB-",
        organDonor: false,
        donationDate: "2025-06-10"
    },
    {
        id: "17",
        name: "Eva Green",
        email: "eva.green@example.com",
        mobile: "3332221111",
        bloodType: "O+",
        organDonor: true,
        donationDate: "2025-05-22"
    },
    {
        id: "18",
        name: "Frank Miller",
        email: "frank.miller@example.com",
        mobile: "2223334444",
        bloodType: "A-",
        organDonor: false,
        donationDate: "2025-04-18"
    },
    {
        id: "19",
        name: "Grace Lee",
        email: "grace.lee@example.com",
        mobile: "1112223333",
        bloodType: "B-",
        organDonor: true,
        donationDate: "2025-03-30"
    },
    {
        id: "20",
        name: "Henry Ford",
        email: "henry.ford@example.com",
        mobile: "9998887777",
        bloodType: "AB+",
        organDonor: false,
        donationDate: "2025-02-14"
    },
    {
        id: "21",
        name: "Ivy Chen",
        email: "ivy.chen@example.com",
        mobile: "8887776666",
        bloodType: "O-",
        organDonor: true,
        donationDate: "2025-01-05"
    },
    {
        id: "22",
        name: "Jack Brown",
        email: "jack.brown@example.com",
        mobile: "7776665555",
        bloodType: "A+",
        organDonor: false,
        donationDate: "2024-12-25"
    },
    {
        id: "23",
        name: "Kathy White",
        email: "kathy.white@example.com",
        mobile: "6665554444",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2024-11-11"
    },
    {
        id: "24",
        name: "Leo Black",
        email: "leo.black@example.com",
        mobile: "5554443333",
        bloodType: "O+",
        organDonor: false,
        donationDate: "2024-10-02"
    },
    {
        id: "1",
        name: "Alice Johnson",
        email: "alice@example.com",
        mobile: "1234567890",
        bloodType: "A+",
        organDonor: true,
        donationDate: "2025-09-01"
    },
    {
        id: "2",
        name: "Bob Smith",
        email: "bob@example.com",
        mobile: "9876543210",
        bloodType: "O-",
        organDonor: false,
        donationDate: "2025-08-20"
    },
    {
        id: "3",
        name: "Carol Lee",
        email: "carol@example.com",
        mobile: "5551234567",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2025-07-15"
    },
    {
        id: "4",
        name: "David Kim",
        email: "david.kim@example.com",
        mobile: "4445556666",
        bloodType: "AB-",
        organDonor: false,
        donationDate: "2025-06-10"
    },
    {
        id: "5",
        name: "Eva Green",
        email: "eva.green@example.com",
        mobile: "3332221111",
        bloodType: "O+",
        organDonor: true,
        donationDate: "2025-05-22"
    },
    {
        id: "6",
        name: "Frank Miller",
        email: "frank.miller@example.com",
        mobile: "2223334444",
        bloodType: "A-",
        organDonor: false,
        donationDate: "2025-04-18"
    },
    {
        id: "7",
        name: "Grace Lee",
        email: "grace.lee@example.com",
        mobile: "1112223333",
        bloodType: "B-",
        organDonor: true,
        donationDate: "2025-03-30"
    },
    {
        id: "8",
        name: "Henry Ford",
        email: "henry.ford@example.com",
        mobile: "9998887777",
        bloodType: "AB+",
        organDonor: false,
        donationDate: "2025-02-14"
    },
    {
        id: "9",
        name: "Ivy Chen",
        email: "ivy.chen@example.com",
        mobile: "8887776666",
        bloodType: "O-",
        organDonor: true,
        donationDate: "2025-01-05"
    },
    {
        id: "10",
        name: "Jack Brown",
        email: "jack.brown@example.com",
        mobile: "7776665555",
        bloodType: "A+",
        organDonor: false,
        donationDate: "2024-12-25"
    },
    {
        id: "11",
        name: "Kathy White",
        email: "kathy.white@example.com",
        mobile: "6665554444",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2024-11-11"
    },
    {
        id: "12",
        name: "Leo Black",
        email: "leo.black@example.com",
        mobile: "5554443333",
        bloodType: "O+",
        organDonor: false,
        donationDate: "2024-10-02"
    }, {
        id: "1",
        name: "Alice Johnson",
        email: "alice@example.com",
        mobile: "1234567890",
        bloodType: "A+",
        organDonor: true,
        donationDate: "2025-09-01"
    },
    {
        id: "2",
        name: "Bob Smith",
        email: "bob@example.com",
        mobile: "9876543210",
        bloodType: "O-",
        organDonor: false,
        donationDate: "2025-08-20"
    },
    {
        id: "3",
        name: "Carol Lee",
        email: "carol@example.com",
        mobile: "5551234567",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2025-07-15"
    },
    {
        id: "4",
        name: "David Kim",
        email: "david.kim@example.com",
        mobile: "4445556666",
        bloodType: "AB-",
        organDonor: false,
        donationDate: "2025-06-10"
    },
    {
        id: "5",
        name: "Eva Green",
        email: "eva.green@example.com",
        mobile: "3332221111",
        bloodType: "O+",
        organDonor: true,
        donationDate: "2025-05-22"
    },
    {
        id: "6",
        name: "Frank Miller",
        email: "frank.miller@example.com",
        mobile: "2223334444",
        bloodType: "A-",
        organDonor: false,
        donationDate: "2025-04-18"
    },
    {
        id: "7",
        name: "Grace Lee",
        email: "grace.lee@example.com",
        mobile: "1112223333",
        bloodType: "B-",
        organDonor: true,
        donationDate: "2025-03-30"
    },
    {
        id: "8",
        name: "Henry Ford",
        email: "henry.ford@example.com",
        mobile: "9998887777",
        bloodType: "AB+",
        organDonor: false,
        donationDate: "2025-02-14"
    },
    {
        id: "9",
        name: "Ivy Chen",
        email: "ivy.chen@example.com",
        mobile: "8887776666",
        bloodType: "O-",
        organDonor: true,
        donationDate: "2025-01-05"
    },
    {
        id: "10",
        name: "Jack Brown",
        email: "jack.brown@example.com",
        mobile: "7776665555",
        bloodType: "A+",
        organDonor: false,
        donationDate: "2024-12-25"
    },
    {
        id: "11",
        name: "Kathy White",
        email: "kathy.white@example.com",
        mobile: "6665554444",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2024-11-11"
    },
    {
        id: "12",
        name: "Leo Black",
        email: "leo.black@example.com",
        mobile: "5554443333",
        bloodType: "O+",
        organDonor: false,
        donationDate: "2024-10-02"
    }, {
        id: "1",
        name: "Alice Johnson",
        email: "alice@example.com",
        mobile: "1234567890",
        bloodType: "A+",
        organDonor: true,
        donationDate: "2025-09-01"
    },
    {
        id: "2",
        name: "Bob Smith",
        email: "bob@example.com",
        mobile: "9876543210",
        bloodType: "O-",
        organDonor: false,
        donationDate: "2025-08-20"
    },
    {
        id: "3",
        name: "Carol Lee",
        email: "carol@example.com",
        mobile: "5551234567",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2025-07-15"
    },
    {
        id: "4",
        name: "David Kim",
        email: "david.kim@example.com",
        mobile: "4445556666",
        bloodType: "AB-",
        organDonor: false,
        donationDate: "2025-06-10"
    },
    {
        id: "5",
        name: "Eva Green",
        email: "eva.green@example.com",
        mobile: "3332221111",
        bloodType: "O+",
        organDonor: true,
        donationDate: "2025-05-22"
    },
    {
        id: "6",
        name: "Frank Miller",
        email: "frank.miller@example.com",
        mobile: "2223334444",
        bloodType: "A-",
        organDonor: false,
        donationDate: "2025-04-18"
    },
    {
        id: "7",
        name: "Grace Lee",
        email: "grace.lee@example.com",
        mobile: "1112223333",
        bloodType: "B-",
        organDonor: true,
        donationDate: "2025-03-30"
    },
    {
        id: "8",
        name: "Henry Ford",
        email: "henry.ford@example.com",
        mobile: "9998887777",
        bloodType: "AB+",
        organDonor: false,
        donationDate: "2025-02-14"
    },
    {
        id: "9",
        name: "Ivy Chen",
        email: "ivy.chen@example.com",
        mobile: "8887776666",
        bloodType: "O-",
        organDonor: true,
        donationDate: "2025-01-05"
    },
    {
        id: "10",
        name: "Jack Brown",
        email: "jack.brown@example.com",
        mobile: "7776665555",
        bloodType: "A+",
        organDonor: false,
        donationDate: "2024-12-25"
    },
    {
        id: "11",
        name: "Kathy White",
        email: "kathy.white@example.com",
        mobile: "6665554444",
        bloodType: "B+",
        organDonor: true,
        donationDate: "2024-11-11"
    },
    {
        id: "12",
        name: "Leo Black",
        email: "leo.black@example.com",
        mobile: "5554443333",
        bloodType: "O+",
        organDonor: false,
        donationDate: "2024-10-02"
    }
];
