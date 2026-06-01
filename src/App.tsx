import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";

import Home from "./pages/Home";
import Questions from "./pages/Questions";
import Login from "./pages/Login";
import Register from "./pages/Register";
import AdminUpload from "./pages/AdminUpload";

import Navbar from "./components/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import QuestionDetailsPage
from "./pages/QuestionDetails";

export default function App() {

  return (

    <BrowserRouter>

      <Navbar />

      <Routes>

        <Route
          path="/"
          element={<Home />}
        />

        <Route
          path="/questions"
          element={<Questions />}
        />

        <Route
          path="/login"
          element={<Login />}
        />

        <Route
          path="/register"
          element={<Register />}
        />

        <Route
          path="/admin/upload"
          element={
            <ProtectedRoute>
              <AdminUpload />
            </ProtectedRoute>
          }
        />

        <Route
          path="/questions/:id"
          element={<QuestionDetailsPage />}
        />

      </Routes>

    </BrowserRouter>

  );
}
