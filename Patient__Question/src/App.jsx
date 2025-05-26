// App.js

import React, { useState } from 'react';
import PatientRegistrationForm from './components/PatientRegistrationForm';
import { PatientInformation } from './components/PatientInformation';

function App() {
  const [lastRegisteredID, setLastRegisteredID] = useState(null);

  // Handles registering a patient and sets the last registered ID
  const handleRegister = async () => {
    const { getPatients } = await import('./services/PatientService');
    const patients = await getPatients();
    const lastPatient = patients[patients.length - 1];
    if (lastPatient) {
      setLastRegisteredID(lastPatient.patientID);
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Patient Management</h1>
      <PatientRegistrationForm onRegister={handleRegister} />
      {lastRegisteredID && <PatientInformation patientID={lastRegisteredID} />}
    </div>
  );
}

export default App;
