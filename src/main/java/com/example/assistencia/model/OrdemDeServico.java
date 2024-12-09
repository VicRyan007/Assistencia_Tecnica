// OrdemDeServico.java
package com.example.assistencia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class OrdemDeServico {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull(message = "A data é obrigatória.")
	    @PastOrPresent(message = "A data não pode ser no futuro.")
	    private LocalDate data;

	    @NotNull(message = "O aparelho é obrigatório.")
	    @ManyToOne
	    private Aparelho aparelho;

	    @NotBlank(message = "A descrição do problema é obrigatória.")
	    @Size(max = 255, message = "A descrição do problema deve ter no máximo 255 caracteres.")
	    private String descricaoProblema;

	    @NotNull(message = "O tipo de serviço é obrigatório.")
	    @Enumerated(EnumType.STRING)
	    private TipoServico tipoServico;

	    @NotNull(message = "O status é obrigatório.")
	    @Enumerated(EnumType.STRING)
	    private Status status;


	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Aparelho getAparelho() {
		return aparelho;
	}
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	public String getDescricaoProblema() {
		return descricaoProblema;
	}
	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}
	public TipoServico getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	
    
    
}
