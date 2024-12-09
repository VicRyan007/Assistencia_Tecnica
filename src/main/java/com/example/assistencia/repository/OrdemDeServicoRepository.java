// OrdemDeServicoRepository.java
package com.example.assistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assistencia.model.OrdemDeServico;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {
}
