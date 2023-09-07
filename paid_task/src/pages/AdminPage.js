import React, { useState } from "react";

const dummyConsultantData = [
  { id: 1, name: "John Doe", status: "Pending" },
  { id: 2, name: "Jane Smith", status: "Approved" },
  // Add more consultant data as needed
];

const dummyJobSeekerData = [
  { id: 1, name: "Alice Johnson", status: "Pending" },
  { id: 2, name: "Bob Wilson", status: "Approved" },
  // Add more job seeker data as needed
];

function AdminPage() {
  const [message, setMessage] = useState(""); // State for displaying messages

  // Function to delete a consultant profile
  const deleteConsultantProfile = (id) => {
    // Implement your delete logic here
    // Assuming a successful delete action
    setMessage(`Deleted consultant profile with ID ${id}`);
  };

  // Function to approve a consultant request
  const approveConsultantRequest = (id) => {
    // Implement your approval logic here
    // Assuming a successful approval action
    setMessage(`Approved consultant request with ID ${id}`);
  };

  // Function to delete a job seeker profile
  const deleteJobSeekerProfile = (id) => {
    // Implement your delete logic here
    // Assuming a successful delete action
    setMessage(`Deleted job seeker profile with ID ${id}`);
  };

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-semibold mb-4">Admin Page</h1>

      {/* Display message */}
      {message && (
        <div className="bg-blue-100 border border-blue-400 text-blue-700 px-4 py-3 rounded relative mb-4">
          <span className="block sm:inline">{message}</span>
          <span className="absolute top-0 bottom-0 right-0 px-4 py-3">
            <svg
              className="fill-current h-6 w-6 text-blue-500"
              role="button"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 20 20"
              onClick={() => setMessage("")}
            >
              <title>Close</title>
              <path
                d="M14.293 5.293a1 1 0 011.414 0l.293.293V7a1 1 0 01-2 0V5.586l.293-.293a1 1 0 111.414 1.414L14 7.414l1.293-1.293a1 1 0 111.414 1.414L15.414 9l1.293 1.293a1 1 0 01-1.414 1.414L14 10.414l-1.293 1.293a1 1 0 01-1.414-1.414L12.586 9 11.293 7.707a1 1 0 010-1.414z"
              />
            </svg>
          </span>
        </div>
      )}

      <div className="mb-8">
        <h2 className="text-2xl font-semibold mb-4">Pending Consultant Requests</h2>
        {dummyConsultantData.map((consultant) => (
          consultant.status === "Pending" && (
            <div
              className="bg-white rounded-lg shadow-md p-4 mb-4 flex justify-between items-center"
              key={consultant.id}
            >
              <h3 className="text-xl">{consultant.name}</h3>
              <div className="space-x-2">
                <button
                  className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded-full text-sm transition duration-300 ease-in-out"
                  onClick={() => approveConsultantRequest(consultant.id)}
                >
                  Approve
                </button>
                <button
                  className="bg-red-500 hover:bg-red-600 text-white py-2 px-4 rounded-full text-sm transition duration-300 ease-in-out"
                  onClick={() => deleteConsultantProfile(consultant.id)}
                >
                  Delete
                </button>
              </div>
            </div>
          )
        ))}
      </div>

      <div>
        <h2 className="text-2xl font-semibold mb-4">Job Seeker</h2>
        {dummyJobSeekerData.map((jobSeeker) => (
          jobSeeker.status === "Pending" && (
            <div
              className="bg-white rounded-lg shadow-md p-4 mb-4 flex justify-between items-center"
              key={jobSeeker.id}
            >
              <h3 className="text-xl">{jobSeeker.name}</h3>
              <button
                className="bg-red-500 hover:bg-red-600 text-white py-2 px-4 rounded-full text-sm transition duration-300 ease-in-out"
                onClick={() => deleteJobSeekerProfile(jobSeeker.id)}
              >
                Delete
              </button>
            </div>
          )
        ))}
      </div>
    </div>
  );
}

export default AdminPage;
