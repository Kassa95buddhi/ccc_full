// RegistrationDropdown.js
import React, { useState } from 'react';

function RegistrationDropdown() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="relative inline-block text-left">
      <div>
        <button onClick={toggleDropdown} className="bg-green-500 text-white font-semibold py-2 px-4 rounded-full text-center text-sm transition duration-300 ease-in-out">
          Register
        </button>
      </div>

      {isOpen && (
        <div className="origin-top-right absolute right-0 mt-2 w-40 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 focus:outline-none">
          <div className="py-1" role="menu" aria-orientation="vertical" aria-labelledby="options-menu">
            <a href="/consultant-registration" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" role="menuitem">
              Consultant Registration
            </a>
            <a href="/job-seeker-registration" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" role="menuitem">
              Job Seeker Registration
            </a>
          </div>
        </div>
      )}
    </div>
  );
}

export default RegistrationDropdown;
