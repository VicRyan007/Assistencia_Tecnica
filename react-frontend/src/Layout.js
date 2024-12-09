import React from "react";
import { Link } from "react-router-dom";

function Layout({ children }) {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Assistência Técnica
          </Link>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link" to="/aparelhos">
                  Aparelhos
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/ordens">
                  Ordens de Serviço
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div className="container mt-4">{children}</div>
    </div>
  );
}

export default Layout;
