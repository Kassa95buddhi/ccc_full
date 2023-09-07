import React, { useState, useEffect } from "react";

function JobSeekerRegistration() {
  const [step, setStep] = useState(1);
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    address: "",
    phoneNumber: "",
    selectedCountries: [],
    academicQualification: "",
  });

  const [formErrors, setFormErrors] = useState({});
  const [isSuccess, setIsSuccess] = useState(false);
  const [redirectToJobSeeker, setRedirectToJobSeeker] = useState(false);

  const countryOptions = [
    "USA",
    "Canada",
    "UK",
    "Australia",
    "Germany",
    "France",
    "India",
    // Add more countries here
  ];

  useEffect(() => {
    if (redirectToJobSeeker) {
      // Redirect to the job seeker page upon successful submission
      window.location.href = "/jobseeker";
    }
  }, [redirectToJobSeeker]);

  const validateForm = () => {
    const errors = {};

    if (step === 1) {
      if (!formData.firstName) {
        errors.firstName = "First Name is required";
      }
      if (!formData.lastName) {
        errors.lastName = "Last Name is required";
      }
      if (!formData.address) {
        errors.address = "Address is required";
      }
      if (!formData.phoneNumber) {
        errors.phoneNumber = "Phone Number is required";
      }
    } else if (step === 2) {
      if (formData.selectedCountries.length === 0) {
        errors.selectedCountries = "Please select at least one country";
      }
      if (!formData.academicQualification) {
        errors.academicQualification = "Academic Qualification is required";
      }
    }

    setFormErrors(errors);

    return Object.keys(errors).length === 0;
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleCountrySelect = (e) => {
    const selectedCountries = Array.from(
      e.target.selectedOptions,
      (option) => option.value
    );
    setFormData({
      ...formData,
      selectedCountries: selectedCountries,
    });
  };

  const handleNextStep = () => {
    if (validateForm()) {
      setStep(step + 1);
    }
  };

  const handlePreviousStep = () => {
    setStep(step - 1);
  };

  const handleSubmit = () => {
    if (validateForm()) {
      // Simulate form submission, you can replace this with your actual API call.
      setTimeout(() => {
        setIsSuccess(true);
        setFormData({
          firstName: "",
          lastName: "",
          address: "",
          phoneNumber: "",
          selectedCountries: [],
          academicQualification: "",
        });
        setFormErrors({});
        setStep(1);
        setRedirectToJobSeeker(true);
      }, 1000); // Simulate a 1-second delay for the success message
    }
  };

  return (
    <div className="bg-gray-100 min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg max-w-md">
        <h1 className="text-3xl font-semibold text-gray-800 mb-4">
          Job Seeker Registration - Step {step}
        </h1>
        {isSuccess ? (
          <div className="text-green-600 font-bold mb-4">Registration Successful!</div>
        ) : (
          <>
            {step === 1 && (
              <div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="firstName">
                    First Name
                  </label>
                  <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    className="w-full border rounded-lg py-2 px-3"
                    placeholder="Enter your first name"
                    value={formData.firstName}
                    onChange={handleInputChange}
                  />
                  {formErrors.firstName && (
                    <p className="text-red-600">{formErrors.firstName}</p>
                  )}
                </div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="lastName">
                    Last Name
                  </label>
                  <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    className="w-full border rounded-lg py-2 px-3"
                    placeholder="Enter your last name"
                    value={formData.lastName}
                    onChange={handleInputChange}
                  />
                  {formErrors.lastName && (
                    <p className="text-red-600">{formErrors.lastName}</p>
                  )}
                </div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="address">
                    Address
                  </label>
                  <input
                    type="text"
                    id="address"
                    name="address"
                    className="w-full border rounded-lg py-2 px-3"
                    placeholder="Enter your address"
                    value={formData.address}
                    onChange={handleInputChange}
                  />
                  {formErrors.address && (
                    <p className="text-red-600">{formErrors.address}</p>
                  )}
                </div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="phoneNumber">
                    Phone Number
                  </label>
                  <input
                    type="text"
                    id="phoneNumber"
                    name="phoneNumber"
                    className="w-full border rounded-lg py-2 px-3"
                    placeholder="Enter your phone number"
                    value={formData.phoneNumber}
                    onChange={handleInputChange}
                  />
                  {formErrors.phoneNumber && (
                    <p className="text-red-600">{formErrors.phoneNumber}</p>
                  )}
                </div>
              </div>
            )}
            {step === 2 && (
              <div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="countries">
                    Choose Expertise (Select multiple countries)
                  </label>
                  <select
                    multiple
                    id="countries"
                    name="countries"
                    className="w-full border rounded-lg py-2 px-3"
                    value={formData.selectedCountries}
                    onChange={handleCountrySelect}
                  >
                    {countryOptions.map((country) => (
                      <option key={country} value={country}>
                        {country}
                      </option>
                    ))}
                  </select>
                  {formErrors.selectedCountries && (
                    <p className="text-red-600">{formErrors.selectedCountries}</p>
                  )}
                </div>
                <div className="mb-4">
                  <label className="block text-gray-600 font-bold mb-2" htmlFor="academicQualification">
                    Academic Qualification
                  </label>
                  <input
                    type="text"
                    id="academicQualification"
                    name="academicQualification"
                    className="w-full border rounded-lg py-2 px-3"
                    placeholder="Enter your academic qualification"
                    value={formData.academicQualification}
                    onChange={handleInputChange}
                  />
                  {formErrors.academicQualification && (
                    <p className="text-red-600">{formErrors.academicQualification}</p>
                  )}
                </div>
              </div>
            )}
            <div className="mb-4">
              <label className="block text-gray-600 font-bold mb-2">
                Selected Countries:
              </label>
              <input
                type="text"
                className="w-full border rounded-lg py-2 px-3"
                readOnly
                value={formData.selectedCountries.join(", ")}
              />
            </div>
            <div className="flex justify-between">
              {step > 1 && (
                <button
                  className="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
                  onClick={handlePreviousStep}
                >
                  Previous
                </button>
              )}
              {step < 2 ? (
                <button
                  className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
                  onClick={handleNextStep}
                >
                  Next
                </button>
              ) : (
                <button
                  className="bg-green-500 hover.bg-green-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
                  onClick={handleSubmit}
                >
                  Submit
                </button>
              )}
            </div>
          </>
        )}
      </div>
    </div>
  );
}

export default JobSeekerRegistration;
