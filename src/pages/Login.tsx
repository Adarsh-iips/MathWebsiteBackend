import { useState }
from "react";

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

 const handleSubmit =
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

  <form
   onSubmit={
    handleSubmit
   }
   className="
   max-w-md
   mx-auto
   mt-10
   space-y-4
   "
  >

   <input
    placeholder="Username"
    className="border p-2 w-full"
    onChange={
     e =>
      setUsername(
       e.target.value
      )
    }
   />

   <input
    type="password"
    placeholder="Password"
    className="border p-2 w-full"
    onChange={
     e =>
      setPassword(
       e.target.value
      )
    }
   />

   <button
    className="
    bg-red-600
    text-white
    px-4
    py-2
    "
   >
    Login
   </button>

  </form>
 );
}