import { Link } from "react-router-dom";
import { type Question } from "../types/Question";
import MathRenderer from "./MathRenderer";

interface Props {
  question: Question;
}

export default function QuestionCard({
  question,
}: Props) {

  return (

    <Link
      to={`/questions/${question.id}`}
    >

      <div
        className="
        bg-white
        shadow-md
        rounded-lg
        p-5
        border
        hover:shadow-lg
        cursor-pointer
        "
      >

        <h2
          className="
          text-xl
          font-bold
          "
        >
          {question.chapter}
        </h2>

        <MathRenderer
          text={
          question.questionText
          }
        />

        <div
          className="
          mt-3
          flex
          gap-3
          "
        >
          <span>
            {question.difficulty}
          </span>

          <span>
            {question.marks} Marks
          </span>
        </div>

      </div>

    </Link>

  );
}