package com.example.assistencia.service;

import org.springframework.stereotype.Service;
import com.example.assistencia.model.OrdemDeServico;
import com.example.assistencia.repository.OrdemDeServicoRepository;

import java.util.List;

@Service
public class OrdemDeServicoService {

    private final OrdemDeServicoRepository repository;

    public OrdemDeServicoService(OrdemDeServicoRepository repository) {
        this.repository = repository;
    }

    public List<OrdemDeServico> listarTodos() {
        return repository.findAll();
    }

    public OrdemDeServico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OrdemDeServico salvar(OrdemDeServico ordem) {
        if (ordem.getId() != null) {
            OrdemDeServico existente = repository.findById(ordem.getId()).orElse(null);
            if (existente != null) {
                // Atualiza os dados existentes
                existente.setData(ordem.getData());
                existente.setAparelho(ordem.getAparelho());
                existente.setDescricaoProblema(ordem.getDescricaoProblema());
                existente.setTipoServico(ordem.getTipoServico());
                existente.setStatus(ordem.getStatus());
                return repository.save(existente);
            }
        }
        // Cadastra novo
        return repository.save(ordem);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
