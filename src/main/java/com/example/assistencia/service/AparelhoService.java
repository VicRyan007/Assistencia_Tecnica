package com.example.assistencia.service;

import org.springframework.stereotype.Service;
import com.example.assistencia.model.Aparelho;
import com.example.assistencia.repository.AparelhoRepository;

import java.util.List;

@Service
public class AparelhoService {

    private final AparelhoRepository repository;

    public AparelhoService(AparelhoRepository repository) {
        this.repository = repository;
    }

    public List<Aparelho> listarTodos() {
        return repository.findAll();
    }

    public Aparelho buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Aparelho salvar(Aparelho aparelho) {
        return repository.save(aparelho); // JPA lida com criação ou atualização.
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
