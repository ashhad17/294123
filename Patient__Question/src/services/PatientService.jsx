// services/PatientService.js

// A mock in-memory database for patients
let mockPatients = [];

// Adds a new patient to the mock database
export const addPatient = async (patient) => {
  // Create a unique patientID like P001, P002, etc.
  const id = `P${(mockPatients.length + 1).toString().padStart(3, '0')}`;
  mockPatients.push({ ...patient, patientID: id });
};

// Retrieves all patients from the mock database
export const getPatients = async () => {
  // Returns a copy of the patient list
  return [...mockPatients];
};
