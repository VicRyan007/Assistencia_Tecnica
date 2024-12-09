import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import AparelhosLista from "./components/aparelhos/AparelhosLista";
import AparelhosFormulario from "./components/aparelhos/AparelhosFormulario";
import OrdensLista from "./components/ordens/OrdensLista";
import OrdensFormulario from "./components/ordens/OrdensFormulario";

function App() {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/aparelhos" element={<AparelhosLista />} />
          <Route path="/aparelhos/novo" element={<AparelhosFormulario />} />
          <Route path="/aparelhos/:id" element={<AparelhosFormulario />} />
          <Route path="/ordens" element={<OrdensLista />} />
          <Route path="/ordens/novo" element={<OrdensFormulario />} />
          <Route path="/ordens/:id" element={<OrdensFormulario />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
