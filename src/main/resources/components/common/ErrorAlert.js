import React from "react";
import { Alert } from "react-bootstrap";

const ErrorAlert = ({ errors }) => {
  if (!errors || errors.length === 0) return null;

  return (
    <Alert variant="danger">
      <ul className="mb-0">
        {errors.map((error, index) => (
          <li key={index}>{error}</li>
        ))}
      </ul>
    </Alert>
  );
};

export default ErrorAlert;
