import {
  useEffect,
  useState
} from "react";

import {
  getQuestionsPage,
  searchQuestions,
  getQuestionsByDifficulty,
  getQuestionsByChapter
} from "../api/questionApi";

import QuestionCard
from "../components/QuestionCard";

import SearchBar
from "../components/SearchBar";

import DifficultyFilter
from "../components/DifficultyFilter";

import ChapterFilter
from "../components/ChapterFilter";

import Pagination
from "../components/Pagination";

import {
  type Question
} from "../types/Question";

export default function Questions() {

  const [questions,
    setQuestions]
      = useState<Question[]>([]);

  const [keyword,
    setKeyword]
      = useState("");

  const [currentPage,
    setCurrentPage]
      = useState(0);

  const [totalPages,
    setTotalPages]
      = useState(0);

  useEffect(() => {

    loadQuestionsPage(0);

  }, []);

  const loadQuestionsPage =
    async (
      page: number
    ) => {

      const data =
        await getQuestionsPage(
          page,
          10
        );

      setQuestions(
        data.content
      );

      setCurrentPage(
        data.number
      );

      setTotalPages(
        data.totalPages
      );

    };

  const handleSearch =
    async () => {

      if (!keyword.trim()) {

        loadQuestionsPage(0);

        return;
      }

      const data =
        await searchQuestions(
          keyword
        );

      setQuestions(data);

      setTotalPages(0);

    };

  const handleDifficulty =
    async (
      difficulty: string
    ) => {

      if (!difficulty) {

        loadQuestionsPage(0);

        return;
      }

      const data =
        await getQuestionsByDifficulty(
          difficulty
        );

      setQuestions(data);

      setTotalPages(0);

    };

  const handleChapter =
    async (
      chapter: string
    ) => {

      if (!chapter) {

        loadQuestionsPage(0);

        return;
      }

      const data =
        await getQuestionsByChapter(
          chapter
        );

      setQuestions(data);

      setTotalPages(0);

    };

  return (

    <div
      className="
      p-6
      "
    >

      <SearchBar
        keyword={keyword}
        setKeyword={setKeyword}
        onSearch={handleSearch}
      />

      <div
        className="
        flex
        gap-4
        mb-6
        "
      >

        <DifficultyFilter
          onChange={
            handleDifficulty
          }
        />

        <ChapterFilter
          onChange={
            handleChapter
          }
        />

      </div>

      <div
        className="
        grid
        md:grid-cols-2
        lg:grid-cols-3
        gap-4
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


      {totalPages > 0 && (

        <Pagination

          currentPage={
            currentPage
          }

          totalPages={
            totalPages
          }

          onPageChange={
            loadQuestionsPage
          }

        />

      )}

    </div>

  );
}