import axios from "axios";
const API =
  "http://localhost:8080/api";

export const studentRegister =
  async (
    username: string,
    email: string,
    password: string
  ) => {

    const response =
      await axios.post(
        `${API}/student/register`,
        {
          username,
          email,
          password
        }
      );

    return response.data;
  };

export const studentLogin =
  async (
    username: string,
    password: string
  ) => {

    const response =
      await axios.post(
        `${API}/student/login`,
        {
          username,
          password
        }
      );

    return response.data;
  };

export const adminLogin =
  async (
    username: string,
    password: string
  ) => {

    const response =
      await axios.post(
        `${API}/admin/login`,
        {
          username,
          password
        }
      );

    return response.data;
  };