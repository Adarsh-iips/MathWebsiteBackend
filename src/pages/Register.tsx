import { useState } from "react";

import {
  studentRegister
} from "../api/authApi";

export default function Register() {

  const [username, setUsername] =
    useState("");

  const [email, setEmail] =
    useState("");

  const [password, setPassword] =
    useState("");

  const handleSubmit =
    async (
      e: React.FormEvent
    ) => {

      e.preventDefault();

      await studentRegister(
        username,
        email,
        password
      );

      alert(
        "Registered Successfully"
      );

      window.location.href =
        "/login";
    };

  return (

    <div
      className="
      min-h-screen
      flex
      items-center
      justify-center
      px-6
      "
    >

      <div
        className="
        w-full
        max-w-md
        bg-zinc-900
        border
        border-zinc-800
        rounded-3xl
        p-8
        shadow-2xl
        "
      >

        <h1
          className="
          text-3xl
          font-bold
          mb-2
          "
        >
          Create Account
        </h1>

        <p
          className="
          text-zinc-400
          mb-8
          "
        >
          Join thousands of students
          practicing mathematics daily.
        </p>

        <form
          onSubmit={handleSubmit}
          className="
          space-y-5
          "
        >

          <input
            placeholder="Username"
            value={username}
            onChange={
              e =>
                setUsername(
                  e.target.value
                )
            }
            className="
            w-full
            bg-zinc-950
            border
            border-zinc-800
            rounded-xl
            px-4
            py-3
            focus:outline-none
            focus:border-red-500
            "
          />

          <input
            placeholder="Email"
            value={email}
            onChange={
              e =>
                setEmail(
                  e.target.value
                )
            }
            className="
            w-full
            bg-zinc-950
            border
            border-zinc-800
            rounded-xl
            px-4
            py-3
            focus:outline-none
            focus:border-red-500
            "
          />

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={
              e =>
                setPassword(
                  e.target.value
                )
            }
            className="
            w-full
            bg-zinc-950
            border
            border-zinc-800
            rounded-xl
            px-4
            py-3
            focus:outline-none
            focus:border-red-500
            "
          />

          <button
            type="submit"
            className="
            w-full
            bg-red-600
            hover:bg-red-500
            transition
            rounded-xl
            py-3
            font-semibold
            "
          >
            Create Account
          </button>

        </form>

      </div>

    </div>

  );
}