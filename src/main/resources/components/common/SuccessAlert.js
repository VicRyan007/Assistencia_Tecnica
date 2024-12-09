import React from "react";
import { Alert } from "react-bootstrap";

const SuccessAlert = ({ message }) => {
  if (!message) return null;

  return <Alert variant="success">{message}</Alert>;
};

export default SuccessAlert;
