// components/PatientInformation.js

import React, { useEffect, useState } from 'react';
import { getPatients } from '../services/PatientService';

export const PatientInformation = ({ patientID }) => {
  const [patient, setPatient] = useState(null);

  useEffect(() => {
    const fetchPatient = async () => {
      const patients = await getPatients();
      const found = patients.find((p) => p.patientID === patientID);
      if (found) setPatient(found);
    };

    fetchPatient();
  }, [patientID]); // Rerun if patientID changes

  if (!patient) return <div>Loading...</div>;

  return (
    <div style={{ border: '1px solid #ccc', padding: 10, marginTop: 20 }}>
      <h3>Patient Information</h3>
      <p><strong>ID:</strong> {patient.patientID}</p>
      <p><strong>Name:</strong> {patient.name}</p>
      <p><strong>Age:</strong> {patient.age}</p>
      <p><strong>Gender:</strong> {patient.gender}</p>
      <p><strong>Condition:</strong> {patient.condition}</p>
      <p><strong>Last Visit:</strong> {patient.lastVisit}</p>
    </div>
  );
};
