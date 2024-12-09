import React from "react";
import { Routes, Route } from "react-router-dom";
import Layout from "./components/Layout";
import AparelhosList from "./components/aparelhos/AparelhosList";
import AparelhosForm from "./components/aparelhos/AparelhosForm";
import OrdensList from "./components/ordens/OrdensList";
import OrdensForm from "./components/ordens/OrdensForm";

const App = () => (
  <Layout>
    <Routes>
      <Route path="/" element={<h2>Bem-vindo à Assistência Técnica</h2>} />
      <Route path="/aparelhos" element={<AparelhosList />} />
      <Route path="/aparelhos/novo" element={<AparelhosForm />} />
      <Route path="/aparelhos/:id" element={<AparelhosForm />} />
      <Route path="/ordens" element={<OrdensList />} />
      <Route path="/ordens/novo" element={<OrdensForm />} />
      <Route path="/ordens/:id" element={<OrdensForm />} />
    </Routes>
  </Layout>
);

export default App;
