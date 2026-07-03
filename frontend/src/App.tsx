import { useState } from "react";
import { calculate } from "./services/calculatorService";
import "./App.css";

function App() {

  const [num1, setNum1] = useState("");
  const [num2, setNum2] = useState("");

  const [result, setResult] = useState<number | null>(null);
  const [error, setError] = useState("");

  const isValidNumber = (value: string) =>
   /^-?\d+(\.\d+)?$/.test(value);

  const performOperation = async (
  operation: string
) => {

  setResult(null);
  setError("");

  // Validate first number
  if (!isValidNumber(num1)) {
    setError("Please enter a valid first number");
    return;
  }

  // Validate second number for operations that need it
  if (
    operation !== "sqrt" &&
    !isValidNumber(num2)
  ) {
    setError("Please enter a valid second number");
    return;
  }

  try {

    const response = await calculate(
      operation,
      Number(num1),
      Number(num2)
    );

   setResult(Number(response.result.toFixed(4)));

  } catch (err: any) {

    setError(
      err.response?.data?.error ||
      "Something went wrong"
    );
  }
};

  return (
    <div>

      <h1>Calculator</h1>

      <input
  type="text"
  placeholder="Enter first number"
  value={num1}
  onChange={(e) => setNum1(e.target.value)}
 
/>

      <br /><br />

     <input
  type="text"
  placeholder="Enter second number"
  value={num2}
   onChange={(e) => setNum2(e.target.value)}
/>

      <br /><br />

      <button onClick={() => performOperation("add")}>
        Add
      </button>

      <button onClick={() => performOperation("subtract")}>
        Subtract
      </button>

      <button onClick={() => performOperation("multiply")}>
        Multiply
      </button>

      <button onClick={() => performOperation("divide")}>
        Divide
      </button>

      <button onClick={() => performOperation("power")}>
        Power
      </button>

      <button onClick={() => performOperation("percentage")}>
        Percentage
      </button>

      <br /><br />

      <button onClick={() => performOperation("sqrt")}>
        Square Root
      </button>

      <br /><br />

      {result !== null && (
  <h2 className = "result-message">
  Result: {result}</h2>
)}
      {error && <h2 className = "error-message">Error: {error}</h2>}

    </div>
  );
}

export default App;