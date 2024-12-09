import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router } from "react-router-dom";
import App from "./App";
import { MessageProvider } from "./context/MessageContext";
import "bootstrap/dist/css/bootstrap.min.css";

ReactDOM.render(
  <MessageProvider>
    <Router>
      <App />
    </Router>
  </MessageProvider>,
  document.getElementById("root")
);
