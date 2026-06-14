import {
  useEffect,
  useState
} from "react";

import {
  useParams
} from "react-router-dom";

import {
  getQuestionDetails
} from "../api/questionApi";

import {
  type QuestionDetails
} from "../types/QuestionDetails";

import MathRenderer
from "../components/MathRenderer";

export default function QuestionDetailsPage() {

  const { id } =
    useParams();

  const [data,
    setData] =
    useState<QuestionDetails>();

  useEffect(() => {

    if (id) {

      getQuestionDetails(id)
        .then(setData);

    }

  }, [id]);

  if (!data) {

    return (

      <div
        className="
        min-h-screen
        flex
        items-center
        justify-center
        text-zinc-400
        "
      >
        Loading...
      </div>

    );
  }

  return (

    <main
      className="
      max-w-5xl
      mx-auto
      px-6
      py-10
      "
    >

      {/* QUESTION */}

      <section
        className="
        bg-zinc-900
        border
        border-zinc-800
        rounded-3xl
        p-8
        "
      >

        <div
          className="
          flex
          flex-wrap
          gap-3
          mb-6
          "
        >

          <span
            className="
            px-3
            py-1
            rounded-full
            text-sm
            bg-red-500/20
            text-red-400
            "
          >
            {data.question.difficulty}
          </span>

          <span
            className="
            px-3
            py-1
            rounded-full
            text-sm
            bg-zinc-800
            text-zinc-300
            "
          >
            {data.question.chapter}
          </span>

          <span
            className="
            px-3
            py-1
            rounded-full
            text-sm
            bg-zinc-800
            text-zinc-300
            "
          >
            {data.question.marks} Marks
          </span>

        </div>

        <h1
          className="
          text-3xl
          font-bold
          mb-6
          "
        >
          Question
        </h1>

        <div
          className="
          text-lg
          leading-relaxed
          "
        >
          <MathRenderer
            text={
              data.question.questionText
            }
          />
        </div>

      </section>

      {/* SOLUTION */}

      <section
        className="
        mt-8
        bg-green-500/10
        border
        border-green-500/20
        rounded-3xl
        p-8
        "
      >

        <h2
          className="
          text-2xl
          font-bold
          mb-6
          text-green-400
          "
        >
          Solution
        </h2>

        <div
          className="
          leading-relaxed
          "
        >
          <MathRenderer
            text={
              data.solution.solutionText
            }
          />
        </div>

      </section>

      {/* HINT + MISTAKE */}

      <section
        className="
        mt-8
        grid
        md:grid-cols-2
        gap-6
        "
      >

        <div
          className="
          bg-yellow-500/10
          border
          border-yellow-500/20
          rounded-3xl
          p-6
          "
        >

          <h3
            className="
            text-xl
            font-semibold
            text-yellow-400
            mb-4
            "
          >
            Hint
          </h3>

          <MathRenderer
            text={
              data.solution.hint1
            }
          />

        </div>

        <div
          className="
          bg-red-500/10
          border
          border-red-500/20
          rounded-3xl
          p-6
          "
        >

          <h3
            className="
            text-xl
            font-semibold
            text-red-400
            mb-4
            "
          >
            Common Mistake
          </h3>

          <MathRenderer
            text={
              data.solution.commonMistake
            }
          />

        </div>

      </section>

    </main>

  );
}