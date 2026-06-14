import { useEffect, useState } from "react";

import axios from "axios";

import QuestionCard
from "../components/QuestionCard";

import { type Question }
from "../types/Question";

export default function Questions() {

  const [questions,
    setQuestions] =
    useState<Question[]>([]);

  const [page,
    setPage] =
    useState(0);

  const [totalPages,
    setTotalPages] =
    useState(0);

  useEffect(() => {

    axios

      .get(
        `http://localhost:8080/api/questions/page?page=${page}&size=12`
      )

      .then(res => {

        setQuestions(
          res.data.content
        );

        setTotalPages(
          res.data.totalPages
        );

      });

  }, [page]);

  return (

    <main
      className="
      max-w-7xl
      mx-auto
      px-6
      py-12
      "
    >

      <div
        className="
        mb-10
        "
      >

        <h1
          className="
          text-5xl
          font-black
          "
        >
          Question Bank
        </h1>

        <p
          className="
          text-zinc-400
          mt-3
          "
        >
          Explore chapter-wise
          questions with solutions.
        </p>

      </div>

      <div
        className="
        grid
        md:grid-cols-2
        lg:grid-cols-3
        gap-6
        "
      >

        {questions.map(
          question => (

            <QuestionCard
              key={question.id}
              question={question}
            />

          )
        )}

      </div>

      <div
        className="
        flex
        justify-center
        gap-4
        mt-12
        "
      >

        <button

          disabled={page === 0}

          onClick={() =>
            setPage(
              page - 1
            )
          }

          className="
          px-5
          py-2
          rounded-xl
          bg-zinc-800
          disabled:opacity-40
          "
        >
          Previous
        </button>

        <div
          className="
          flex
          items-center
          text-zinc-400
          "
        >
          Page {page + 1}
        </div>

        <button

          disabled={
            page + 1 >= totalPages
          }

          onClick={() =>
            setPage(
              page + 1
            )
          }

          className="
          px-5
          py-2
          rounded-xl
          bg-red-500
          "
        >
          Next
        </button>

      </div>

    </main>

  );
}