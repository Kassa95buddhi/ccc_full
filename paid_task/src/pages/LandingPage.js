import React, { useState } from "react";
import { Link } from "react-router-dom";

function LandingPage() {
  const [showOptions, setShowOptions] = useState(false);

  const toggleOptions = () => {
    setShowOptions(!showOptions);
  };

  return (
    <div className="bg-gray-100 min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg max-w-md">
        <h1 className="text-3xl font-semibold text-gray-800 mb-4">
          Colombo Consultant Center (CCC)
        </h1>
        <p className="text-gray-600 mb-6">
          Welcome to CCC. Please log in or register to access our services.
        </p>
        <div className="flex justify-between">
          <Link
            to="/login"
            className="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
          >
            Login
          </Link>
          <div className="relative inline-block text-left">
            <button
              onClick={toggleOptions}
              className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out"
            >
              Register
            </button>
            {showOptions && (
              <div className="origin-top-right absolute right-0 mt-2 w-40 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 focus:outline-none">
                <div
                  className="py-1"
                  role="menu"
                  aria-orientation="vertical"
                  aria-labelledby="options-menu"
                >
                  <Link
                    to="/consultant-registration"
                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                    role="menuitem"
                  >
                    Consultant Registration
                  </Link>
                  <Link
                    to="/job-seeker-registration"
                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900"
                    role="menuitem"
                  >
                    Job Seeker Registration
                  </Link>
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default LandingPage;
