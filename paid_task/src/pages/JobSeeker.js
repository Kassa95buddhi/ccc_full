import React, { useState } from "react";

const dummyConsultants = [
  { id: 1, name: "Consultant 1" },
  { id: 2, name: "Consultant 2" },
  // Add more consultants here
];

const dummyAvailableSlots = [
  {
    consultantId: 1,
    date: "2023-09-10",
    timeslots: ["09:00 AM", "11:00 AM", "02:00 PM"],
  },
  {
    consultantId: 2,
    date: "2023-09-11",
    timeslots: ["10:00 AM", "01:00 PM", "03:00 PM"],
  },
  // Add more available slots here
];

function JobSeeker() {
  const [selectedConsultant, setSelectedConsultant] = useState("");
  const [selectedDate, setSelectedDate] = useState("");
  const [selectedTime, setSelectedTime] = useState("");
  const [isAppointmentMade, setIsAppointmentMade] = useState(false);

  const handleMakeAppointment = () => {
    // Simulate making an appointment (you can replace this with your logic)
    setIsAppointmentMade(true);
  };

  const renderConsultantOptions = () => {
    return dummyConsultants.map((consultant) => (
      <option key={consultant.id} value={consultant.id}>
        {consultant.name}
      </option>
    ));
  };

  const renderDateOptions = () => {
    // Filter available slots based on selected consultant
    const availableSlots = dummyAvailableSlots.filter(
      (slot) => slot.consultantId === parseInt(selectedConsultant)
    );

    // Extract unique dates from available slots
    const uniqueDates = Array.from(
      new Set(availableSlots.map((slot) => slot.date))
    );

    return uniqueDates.map((date) => (
      <option key={date} value={date}>
        {date}
      </option>
    ));
  };

  const renderTimeOptions = () => {
    // Filter available slots based on selected consultant and date
    const availableSlots = dummyAvailableSlots.find(
      (slot) =>
        slot.consultantId === parseInt(selectedConsultant) &&
        slot.date === selectedDate
    );

    if (availableSlots) {
      return availableSlots.timeslots.map((timeslot) => (
        <option key={timeslot} value={timeslot}>
          {timeslot}
        </option>
      ));
    } else {
      return [];
    }
  };

  return (
    <div className="bg-gray-100 min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg max-w-md">
        <h1 className="text-3xl font-semibold text-gray-800 mb-4">
          Job Seeker Page
        </h1>
        {isAppointmentMade ? (
          <div className="text-green-600 font-bold mb-4">
            Successfully made an appointment!
          </div>
        ) : (
          <>
            <div className="mb-4">
              <label className="block text-gray-600 font-bold mb-2" htmlFor="consultant">
                Select Consultant
              </label>
              <select
                id="consultant"
                name="consultant"
                className="w-full border rounded-lg py-2 px-3"
                value={selectedConsultant}
                onChange={(e) => setSelectedConsultant(e.target.value)}
              >
                <option value="">Select a consultant</option>
                {renderConsultantOptions()}
              </select>
            </div>
            <div className="mb-4">
              <label className="block text-gray-600 font-bold mb-2" htmlFor="date">
                Select Date
              </label>
              <select
                id="date"
                name="date"
                className="w-full border rounded-lg py-2 px-3"
                value={selectedDate}
                onChange={(e) => setSelectedDate(e.target.value)}
              >
                <option value="">Select a date</option>
                {renderDateOptions()}
              </select>
            </div>
            <div className="mb-4">
              <label className="block text-gray-600 font-bold mb-2" htmlFor="time">
                Select Time
              </label>
              <select
                id="time"
                name="time"
                className="w-full border rounded-lg py-2 px-3"
                value={selectedTime}
                onChange={(e) => setSelectedTime(e.target.value)}
              >
                <option value="">Select a time</option>
                {renderTimeOptions()}
              </select>
            </div>
            <button
              className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
              onClick={handleMakeAppointment}
            >
              Make Appointment
            </button>
          </>
        )}
      </div>
    </div>
  );
}

export default JobSeeker;
