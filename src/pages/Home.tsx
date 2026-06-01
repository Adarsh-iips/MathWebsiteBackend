import {
  Link
} from "react-router-dom";

export default function Home() {

  return (

    <div
      className="
      flex
      flex-col
      items-center
      justify-center
      h-screen
      "
    >

      <h1
        className="
        text-5xl
        font-bold
        "
      >
        Math Practice Platform
      </h1>

      <Link
        to="/questions"
        className="
        mt-6
        bg-red-600
        text-white
        px-6
        py-3
        rounded
        "
      >
        Browse Questions
      </Link>

    </div>

  );
}