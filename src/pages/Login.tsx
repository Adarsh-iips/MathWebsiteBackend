import { useState } from "react";

import {
  studentLogin
}
from "../api/authApi";

import {
  saveToken
}
from "../utils/auth";

export default function Login() {

  const [username,
    setUsername] =
    useState("");

  const [password,
    setPassword] =
    useState("");

  const submit =
    async (
      e: React.FormEvent
    ) => {

      e.preventDefault();

      const response =
        await studentLogin(
          username,
          password
        );

      saveToken(
        response.token
      );

      window.location.href =
        "/";
    };

  return (

    <div
      className="
      min-h-screen
      flex
      items-center
      justify-center
      "
    >

      <form
        onSubmit={submit}
        className="
        w-full
        max-w-md
        bg-zinc-900
        border
        border-zinc-800
        p-8
        rounded-3xl
        "
      >

        <h1
          className="
          text-3xl
          font-bold
          mb-8
          "
        >
          Welcome Back
        </h1>

        <input
          placeholder="Username"
          className="
          w-full
          p-3
          rounded-xl
          bg-zinc-800
          mb-4
          "
          onChange={e =>
            setUsername(
              e.target.value
            )
          }
        />

        <input
          type="password"
          placeholder="Password"
          className="
          w-full
          p-3
          rounded-xl
          bg-zinc-800
          mb-6
          "
          onChange={e =>
            setPassword(
              e.target.value
            )
          }
        />

        <button
          className="
          w-full
          bg-red-500
          py-3
          rounded-xl
          "
        >
          Login
        </button>

      </form>

    </div>

  );
}