import { Link } from "react-router-dom";

export default function Home() {

  return (

    <main
      className="
      min-h-screen
      flex
      items-center
      "
    >

      <div
        className="
        max-w-6xl
        mx-auto
        px-6
        "
      >

        <div
          className="
          text-center
          "
        >

          <div
            className="
            inline-block
            px-4
            py-2
            rounded-full
            border
            border-zinc-700
            text-zinc-400
            mb-6
            "
          >
            CBSE • ICSE • JEE Foundation
          </div>

          <h1
            className="
            text-6xl
            font-black
            leading-tight
            "
          >
            Master Mathematics
            <br />
            One Question At A Time
          </h1>

          <p
            className="
            text-zinc-400
            text-xl
            max-w-2xl
            mx-auto
            mt-6
            "
          >
            Thousands of chapter-wise
            questions, solutions,
            hints and PYQs curated
            for Classes 9–12.
          </p>

          <div
            className="
            mt-10
            flex
            justify-center
            gap-4
            flex-wrap
            "
          >

            <Link
              to="/questions"
              className="
              bg-red-500
              px-8
              py-4
              rounded-2xl
              font-semibold
              hover:bg-red-600
              transition
              "
            >
              Start Practicing
            </Link>

            <Link
              to="/register"
              className="
              border
              border-zinc-700
              px-8
              py-4
              rounded-2xl
              hover:border-zinc-500
              transition
              "
            >
              Create Account
            </Link>

          </div>

        </div>

      </div>

    </main>
  );
}