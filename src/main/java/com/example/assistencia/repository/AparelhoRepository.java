package com.example.assistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assistencia.model.Aparelho;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
