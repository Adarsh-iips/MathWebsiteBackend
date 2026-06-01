import {
 Navigate
}
from "react-router-dom";

import {
 getToken
}
from "../utils/auth";
import type { JSX } from "react";

export default function ProtectedRoute(
 {
  children
 }:
 {
  children:
   JSX.Element
 }
) {

 return getToken()

  ? children

  : <Navigate
      to="/login"
    />;
}