import LandingPage from "./pages/LandingPage";
import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import CounsultantRegistration from "./pages/ConsultantRegistration";
import JobSeekerRegistration from "./pages/JobSeekerRegistration";
import Login from "./pages/Login";
import JobSeeker from "./pages/JobSeeker";
import Consultant from "./pages/Consultant";
import AdminPage from "./pages/AdminPage";
import { RouteNames } from "./constant/RouteNames";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path={RouteNames.Login}
          caseSensitive={false}
          element={<Login />}
        />
        <Route
          path={RouteNames.JobSeekerRegistration}
          caseSensitive={false}
          element={<JobSeekerRegistration />}
        />
        <Route
          path={RouteNames.ConsultantRegistration}
          caseSensitive={false}
          element={<CounsultantRegistration />}
        />

        <Route
          path={RouteNames.AdminPage}
          caseSensitive={false}
          element={<AdminPage />}
        />

        <Route
          path={RouteNames.Consultant}
          caseSensitive={false}
          element={<Consultant />}
        />

        <Route
          path={RouteNames.JobSeeker}
          caseSensitive={false}
          element={<JobSeeker />}
        />

        <Route
          path={RouteNames.Consultant}
          caseSensitive={false}
          element={<Consultant />}
        />

        <Route
          path={RouteNames.LandingPage}
          caseSensitive={false}
          element={<LandingPage />}
        />
      </Routes>
    </BrowserRouter>
  );
}
