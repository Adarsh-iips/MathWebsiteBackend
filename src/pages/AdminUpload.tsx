import axios from "axios";

import {
  getToken
} from "../utils/auth";

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
        "Questions Uploaded Successfully"
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
        "Solutions Uploaded Successfully"
      );
    };

  return (

    <div
      className="
      max-w-5xl
      mx-auto
      px-6
      py-12
      "
    >

      <h1
        className="
        text-4xl
        font-bold
        mb-3
        "
      >
        Admin Dashboard
      </h1>

      <p
        className="
        text-zinc-400
        mb-10
        "
      >
        Manage questions and solutions
        for the platform.
      </p>

      <div
        className="
        grid
        md:grid-cols-2
        gap-8
        "
      >

        {/* QUESTIONS */}

        <div
          className="
          bg-zinc-900
          border
          border-zinc-800
          rounded-3xl
          p-8
          "
        >

          <h2
            className="
            text-2xl
            font-semibold
            mb-3
            "
          >
            Upload Questions
          </h2>

          <p
            className="
            text-zinc-400
            mb-6
            "
          >
            Import questions from CSV.
          </p>

          <input
            type="file"
            accept=".csv"
            onChange={
              uploadQuestions
            }
            className="
            block
            w-full
            text-sm
            text-zinc-300
            "
          />

        </div>

        {/* SOLUTIONS */}

        <div
          className="
          bg-zinc-900
          border
          border-zinc-800
          rounded-3xl
          p-8
          "
        >

          <h2
            className="
            text-2xl
            font-semibold
            mb-3
            "
          >
            Upload Solutions
          </h2>

          <p
            className="
            text-zinc-400
            mb-6
            "
          >
            Import solutions linked to
            question IDs.
          </p>

          <input
            type="file"
            accept=".csv"
            onChange={
              uploadSolutions
            }
            className="
            block
            w-full
            text-sm
            text-zinc-300
            "
          />

        </div>

      </div>

    </div>

  );
}