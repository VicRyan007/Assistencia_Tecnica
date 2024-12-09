import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Form, Button } from "react-bootstrap";
import axios from "axios";
import { useMessage } from "../../context/MessageContext";

const AparelhosForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { setErrors, setSuccessMessage } = useMessage();

  const [aparelho, setAparelho] = useState({
    nome: "",
    marca: "",
    tipo: "",
    ano: "",
  });

  useEffect(() => {
    if (id) {
      axios.get(`/api/aparelhos/${id}`).then((response) => setAparelho(response.data));
    }
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAparelho({ ...aparelho, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const request = id ? axios.put(`/api/aparelhos/${id}`, aparelho) : axios.post("/api/aparelhos", aparelho);

    request
      .then(() => {
        setSuccessMessage("Aparelho salvo com sucesso!");
        setErrors([]);
        navigate("/aparelhos");
      })
      .catch((error) => {
        setErrors([error.response?.data?.message || "Erro ao salvar aparelho."]);
      });
  };

  return (
    <div>
      <h2>{id ? "Editar Aparelho" : "Novo Aparelho"}</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3">
          <Form.Label>Nome</Form.Label>
          <Form.Control
            type="text"
            name="nome"
            value={aparelho.nome}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Marca</Form.Label>
          <Form.Control
            type="text"
            name="marca"
            value={aparelho.marca}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Tipo</Form.Label>
          <Form.Control
            type="text"
            name="tipo"
            value={aparelho.tipo}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Ano</Form.Label>
          <Form.Control
            type="number"
            name="ano"
            value={aparelho.ano}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Button type="submit">Salvar</Button>
      </Form>
    </div>
  );
};

export default AparelhosForm;
