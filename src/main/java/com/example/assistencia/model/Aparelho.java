package com.example.assistencia.model;

import java.time.Year;

import com.example.assistencia.validation.AnoValido;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Aparelho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do aparelho é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "A marca do aparelho é obrigatória")
    @Column(nullable = false)
    private String marca;

    @NotBlank(message = "O tipo do aparelho é obrigatório")
    @Column(nullable = false)
    private String tipo;
    
    @AnoValido
    @Min(value = 1900, message = "O ano deve ser maior que 1900.")
    @Max(value = Year.MAX_VALUE, message = "O ano não pode ser maior que o ano atual.")
    @NotNull(message = "O ano é obrigatório")
    private int ano;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
    
    
    
}
