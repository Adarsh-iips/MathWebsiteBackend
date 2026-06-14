import { Link } from "react-router-dom";

import {
  getToken,
  logout
} from "../utils/auth";

export default function Navbar() {

  const token = getToken();

  return (

    <header
      className="
      sticky
      top-0
      z-50
      backdrop-blur-xl
      border-b
      border-zinc-800
      bg-black/70
      "
    >

      <div
        className="
        max-w-7xl
        mx-auto
        px-6
        py-4
        flex
        justify-between
        items-center
        "
      >

        <Link
          to="/"
          className="
          text-xl
          font-bold
          tracking-tight
          "
        >
          MathVerse
        </Link>

        <nav
          className="
          flex
          items-center
          gap-6
          text-zinc-300
          "
        >

          <Link
            to="/questions"
            className="hover:text-white"
          >
            Questions
          </Link>

          <Link
            to="/admin/login"
            className="hover:text-white"
          >
            Admin
          </Link>

          {!token && (
            <>
              <Link
                to="/login"
                className="hover:text-white"
              >
                Login
              </Link>

              <Link
                to="/register"
                className="
                bg-red-500
                px-4
                py-2
                rounded-xl
                hover:bg-red-600
                transition
                "
              >
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
              className="
              bg-red-500
              px-4
              py-2
              rounded-xl
              hover:bg-red-600
              transition
              "
            >
              Logout
            </button>

          )}

        </nav>

      </div>

    </header>
  );
}