import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate
import AdminPage from "./AdminPage"; // Import your admin page component
import Consultant from "./Consultant"; // Import your consultant page component
import JobSeeker from "./JobSeeker"; // Import your job seeker page component
import AuthService from "../services/AuthService";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loggedInUser, setLoggedInUser] = useState(null);
  const navigate = useNavigate(); // Initialize useNavigate

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleLogin = () => {
    const loginRequest = {
      email:username,
      password:password
    }
    AuthService.loginRequest(loginRequest).then((response)=>{
      console.log(response.data.data.role)
      if (response?.data?.data?.role === "RECEPTION") {
        setLoggedInUser("admin");
        navigate("/admin"); // Redirect to the admin page
      } else if (response?.data?.data?.role === "CONSULTANT") {
        setLoggedInUser("CONSULTANT");
        navigate("/consultant"); // Redirect to the consultant page
      } else if (response?.data?.data?.role === "JOBSEEKER") {
        setLoggedInUser("JOBSEEKER");
        navigate("/jobseeker"); // Redirect to the job seeker page
      } else {
        // Handle incorrect username or other cases
        // console.log("Invalid username");
      }
    })
    
    
  };

  // Render nothing if a user is logged in
  if (loggedInUser) {
    return null;
  }

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="max-w-md p-8 bg-white rounded-lg shadow-lg">
        <h1 className="mb-4 text-3xl font-semibold text-gray-800">Login</h1>
        <div className="mb-4">
          <label className="block mb-2 font-bold text-gray-600" htmlFor="username">
            Username
          </label>
          <input
            type="text"
            id="username"
            className="w-full px-3 py-2 border rounded-lg"
            placeholder="Enter your username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div className="mb-4">
          <label className="block mb-2 font-bold text-gray-600" htmlFor="password">
            Password
          </label>
          <input
            type="password"
            id="password"
            className="w-full px-3 py-2 border rounded-lg"
            placeholder="Enter your password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <button
          className="px-4 py-2 text-sm text-center text-white transition duration-300 ease-in-out bg-blue-500 rounded-full hover:bg-blue-600"
          onClick={handleLogin}
        >
          Login
        </button>
      </div>
    </div>
  );
}

export default Login;
