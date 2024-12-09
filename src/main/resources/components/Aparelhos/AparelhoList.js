import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Table, Button } from "react-bootstrap";
import axios from "axios";

const AparelhosList = () => {
  const [aparelhos, setAparelhos] = useState([]);

  useEffect(() => {
    axios.get("/api/aparelhos").then((response) => setAparelhos(response.data));
  }, []);

  const handleDelete = (id) => {
    axios.delete(`/api/aparelhos/${id}`).then(() => {
      setAparelhos(aparelhos.filter((aparelho) => aparelho.id !== id));
    });
  };

  return (
    <div>
      <h2>Lista de Aparelhos</h2>
      <Link to="/aparelhos/novo" className="btn btn-primary mb-3">Novo Aparelho</Link>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Marca</th>
            <th>Tipo</th>
            <th>Ano</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {aparelhos.map((aparelho) => (
            <tr key={aparelho.id}>
              <td>{aparelho.nome}</td>
              <td>{aparelho.marca}</td>
              <td>{aparelho.tipo}</td>
              <td>{aparelho.ano}</td>
              <td>
                <Link to={`/aparelhos/${aparelho.id}`} className="btn btn-warning btn-sm me-2">Editar</Link>
                <Button variant="danger" size="sm" onClick={() => handleDelete(aparelho.id)}>Excluir</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default AparelhosList;
