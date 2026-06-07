import axios
from "axios";

import {
  getToken
}
from "../utils/auth";

export default function AdminUpload() {

  const uploadQuestions =
    async (
      e: any
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
        "Questions Uploaded"
      );

    };

  const uploadSolutions =
    async (
      e: any
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

        "http://localhost:8080/api/admin/upload/solutions",

        formData,

        {
          headers: {

            Authorization:
              `Bearer ${getToken()}`

          }
        }

      );

      alert(
        "Solutions Uploaded"
      );

    };

  return (

    <div
      className="
      max-w-4xl
      mx-auto
      p-10
      "
    >

      <h1
        className="
        text-4xl
        font-bold
        mb-10
        "
      >
        Admin Dashboard
      </h1>

      <div
        className="
        bg-white
        shadow
        p-6
        rounded
        mb-8
        "
      >

        <h2
          className="
          text-2xl
          mb-4
          "
        >
          Upload Questions CSV
        </h2>

        <input
          type="file"
          onChange={
            uploadQuestions
          }
        />

      </div>

      <div
        className="
        bg-white
        shadow
        p-6
        rounded
        "
      >

        <h2
          className="
          text-2xl
          mb-4
          "
        >
          Upload Solutions CSV
        </h2>

        <input
          type="file"
          onChange={
            uploadSolutions
          }
        />

      </div>

    </div>

  );

}