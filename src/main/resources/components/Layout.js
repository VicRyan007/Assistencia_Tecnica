import React from "react";
import { Container, Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import ErrorAlert from "./common/ErrorAlert";
import SuccessAlert from "./common/SuccessAlert";
import { useMessage } from "../context/MessageContext";

const Layout = ({ children }) => {
  const { errors, successMessage } = useMessage();

  return (
    <>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand as={Link} to="/">Assistência Técnica</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/aparelhos">Aparelhos</Nav.Link>
            <Nav.Link as={Link} to="/ordens">Ordens de Serviço</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Container className="mt-4">
        <ErrorAlert errors={errors} />
        <SuccessAlert message={successMessage} />
        {children}
      </Container>
      <footer className="text-center mt-4">
        <p>&copy; 2024 Assistência Técnica</p>
      </footer>
    </>
  );
};

export default Layout;
