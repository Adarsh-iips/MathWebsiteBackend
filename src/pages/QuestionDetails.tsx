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

  if (!data)
    return <p>Loading...</p>;

  return (

    <div
      className="
      max-w-4xl
      mx-auto
      p-6
      "
    >

      <h1
        className="
        text-3xl
        font-bold
        "
      >
        Question
      </h1>

      <div
        className="
        mt-6
        bg-white
        p-6
        rounded
        shadow
        "
      >

        <p
          className="
          text-lg
          "
        >
          {data.question.questionText}
        </p>

        <div
          className="
          mt-4
          flex
          gap-4
          "
        >

          <span>
            Chapter:
            {data.question.chapter}
          </span>

          <span>
            Difficulty:
            {data.question.difficulty}
          </span>

          <span>
            Marks:
            {data.question.marks}
          </span>

        </div>

      </div>

      <h2
        className="
        text-2xl
        font-bold
        mt-10
        "
      >
        Solution
      </h2>

      <div
        className="
        bg-green-50
        p-6
        rounded
        mt-4
        "
      >

        <p>
          {data.solution.solutionText}
        </p>

      </div>

      <div
        className="
        bg-yellow-100
        p-4
        rounded
        mt-4
        "
      >

        <strong>
          Hint:
        </strong>

        <p>
          {data.solution.hint1}
        </p>

      </div>

      <div
        className="
        bg-red-100
        p-4
        rounded
        mt-4
        "
      >

        <strong>
          Common Mistake:
        </strong>

        <p>
          {data.solution.commonMistake}
        </p>

      </div>

    </div>
  );
}