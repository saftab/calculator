import axios from "axios";

const API_URL = "http://localhost:8080/api/calculator";

export const calculate = async (
  operation: string,
  num1: number,
  num2?: number
) => {

  const payload =
    operation === "sqrt"
      ? { number: num1 }
      : { num1, num2 };

  const response = await axios.post(
    `${API_URL}/${operation}`,
    payload
  );

  return response.data;
};