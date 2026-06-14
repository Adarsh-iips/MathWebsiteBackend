import { type Question } from "../types/Question";
import { Link } from "react-router-dom";

interface Props {
  question: Question;
}

export default function QuestionCard(
  { question }: Props
) {

  return (

    <Link
      to={`/questions/${question.questionId}`}
      className="
      block
      "
    >

      <div
        className="
        bg-zinc-900
        border
        border-zinc-800
        rounded-2xl
        p-6
        transition-all
        duration-300
        hover:border-red-500
        hover:-translate-y-1
        hover:shadow-[0_10px_40px_rgba(239,68,68,0.15)]
        "
      >

        <div
          className="
          flex
          justify-between
          items-start
          "
        >

          <h2
            className="
            text-xl
            font-semibold
            "
          >
            {question.chapter}
          </h2>

          <span
            className="
            text-xs
            px-3
            py-1
            rounded-full
            bg-red-500/20
            text-red-400
            "
          >
            {question.difficulty}
          </span>

        </div>

        <p
          className="
          mt-4
          text-zinc-400
          line-clamp-3
          "
        >
          {question.questionText}
        </p>

        <div
          className="
          mt-6
          flex
          justify-between
          text-sm
          text-zinc-500
          "
        >

          <span>
            {question.marks} Marks
          </span>

          <span>
            {question.topic}
          </span>

        </div>

      </div>

    </Link>

  );
}