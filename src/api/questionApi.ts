import axios from "axios";

const API =
  "http://localhost:8080/api";

export const getQuestions =
  async () => {

    const response =
      await axios.get(
        `${API}/questions`
      );

    return response.data;
  };

export const getQuestionDetails =
  async (
    questionId: string
  ) => {

    const response =
      await axios.get(
        `${API}/questions/${questionId}`
      );

    return response.data;
  };

export const searchQuestions =
  async (
    keyword: string
  ) => {

    const response =
      await axios.get(
        `${API}/questions/search`,
        {
          params: {
            keyword
          }
        }
      );

    return response.data;
  };

export const getQuestionsByDifficulty =
  async (
    difficulty: string
  ) => {

    const response =
      await axios.get(
        `${API}/questions/difficulty/${difficulty}`
      );

    return response.data;
  };

export const getQuestionsByChapter =
  async (
    chapter: string
  ) => {

    const response =
      await axios.get(
        `${API}/questions/chapter/${chapter}`
      );

    return response.data;
  };

export const getQuestionsPage =
  async (
    page: number,
    size: number
  ) => {

    const response =
      await axios.get(
        `${API}/questions/page`,
        {
          params: {
            page,
            size
          }
        }
      );

    return response.data;
  };