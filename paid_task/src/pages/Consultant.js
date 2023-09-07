import React, { useState } from "react";

const dummyAppointmentData = [
  { id: 1, date: "2023-09-10", time: "10:00 AM", jobSeeker: "Alice Johnson" },
  { id: 2, date: "2023-09-12", time: "02:30 PM", jobSeeker: "Bob Wilson" },
  { id: 3, date: "2023-09-11", time: "09:15 AM", jobSeeker: "Carol Smith" },
  // Add more appointment data as needed
];

function ConsultantPage() {
  // Sort appointments by date in ascending order
  const sortedAppointments = [...dummyAppointmentData].sort((a, b) =>
    a.date.localeCompare(b.date)
  );

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-semibold mb-4">Consultant Page</h1>

      <h2 className="text-2xl font-semibold mb-4">Appointments</h2>
      <table className="min-w-full">
        <thead>
          <tr>
            <th className="text-left">Date</th>
            <th className="text-left">Time</th>
            <th className="text-left">Job Seeker</th>
          </tr>
        </thead>
        <tbody>
          {sortedAppointments.map((appointment) => (
            <tr key={appointment.id}>
              <td>{appointment.date}</td>
              <td>{appointment.time}</td>
              <td>{appointment.jobSeeker}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ConsultantPage;
