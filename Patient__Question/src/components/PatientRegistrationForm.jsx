// components/PatientRegistrationForm.js

import React, { useState } from 'react';
import { addPatient } from '../services/PatientService';

const PatientRegistrationForm = ({ onRegister }) => {
  const [formData, setFormData] = useState({
    name: '',
    age: '',
    gender: '',
    condition: '',
    lastVisit: '',
  });

  const [errors, setErrors] = useState({});

  // Form validation function
  const validate = () => {
    const newErrors = {};
    if (!formData.name) newErrors.name = 'Name is required';
    if (!formData.age) newErrors.age = 'Age is required';
    if (!formData.gender) newErrors.gender = 'Gender is required';
    if (!formData.condition) newErrors.condition = 'Condition is required';
    if (!formData.lastVisit) newErrors.lastVisit = 'Last Visit is required';
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  // Handles input changes and updates form state
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Submits the form and adds a patient
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validate()) return;

    await addPatient(formData);
    if (onRegister) onRegister(formData); // notify parent
    setFormData({ name: '', age: '', gender: '', condition: '', lastVisit: '' });
    setErrors({});
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Name" name="name" value={formData.name} onChange={handleChange} />
      {errors.name && <div style={{ color: 'red' }}>{errors.name}</div>}

      <input placeholder="Age" name="age" value={formData.age} onChange={handleChange} />
      {errors.age && <div style={{ color: 'red' }}>{errors.age}</div>}

      <select name="gender" value={formData.gender} onChange={handleChange}>
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
      </select>
      {errors.gender && <div style={{ color: 'red' }}>{errors.gender}</div>}

      <input placeholder="Condition" name="condition" value={formData.condition} onChange={handleChange} />
      {errors.condition && <div style={{ color: 'red' }}>{errors.condition}</div>}

      <input placeholder="Last Visit (YYYY-MM-DD)" name="lastVisit" value={formData.lastVisit} onChange={handleChange} />
      {errors.lastVisit && <div style={{ color: 'red' }}>{errors.lastVisit}</div>}

      <button type="submit">Register Patient</button>
    </form>
  );
};

export default PatientRegistrationForm;
