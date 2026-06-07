import { Link } from
"react-router-dom";

import {
  getToken,
  logout
}
from "../utils/auth";

export default function Navbar() {

  const token =
    getToken();

  return (

    <nav
      className="
      bg-red-600
      text-white
      p-4
      flex
      justify-between
      "
    >

      <Link to="/">
        Math Platform
      </Link>

      <div
        className="
        flex
        gap-4
        "
      >

        <Link to="/questions">
          Questions
        </Link>

        <Link to="/admin/login">
          Admin
        </Link>

        {!token && (

          <>
            <Link to="/login">
              Login
            </Link>

            <Link to="/register">
              Register
            </Link>
          </>

        )}

        {token && (

          <button
            onClick={() => {

              logout();

              window.location.reload();

            }}
          >
            Logout
          </button>

        )}

      </div>

    </nav>

  );
}