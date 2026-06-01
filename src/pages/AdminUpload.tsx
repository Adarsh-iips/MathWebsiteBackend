import axios
from "axios";

import {
 getToken
}
from "../utils/auth";

export default function AdminUpload() {

 const upload =
 async (
  e:any
 ) => {

  const file =
   e.target.files[0];

  const formData =
   new FormData();

  formData.append(
   "file",
   file
  );

  await axios.post(

   "http://localhost:8080/api/admin/upload/questions",

   formData,

   {

    headers: {

     Authorization:
      `Bearer ${getToken()}`

    }

   }

  );

  alert(
   "Uploaded"
  );
 };

 return (

  <div
   className="
   p-10
   "
  >

   <input
    type="file"
    onChange={upload}
   />

  </div>
 );
}