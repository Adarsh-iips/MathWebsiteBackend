import { useState }
from "react";

import {
 studentRegister
}
from "../api/authApi";

export default function Register() {

 const [username,
  setUsername] =
  useState("");

 const [email,
  setEmail] =
  useState("");

 const [password,
  setPassword] =
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
    placeholder="Email"
    className="border p-2 w-full"
    onChange={
     e =>
      setEmail(
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
    Register
   </button>

  </form>
 );
}