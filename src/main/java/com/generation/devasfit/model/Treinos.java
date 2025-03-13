package com.generation.devasfit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_treinos")
public class Treinos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do treino é obrigatório!")
	@Size(min = 5, max = 250, message = "O nome do treino tem que ser maior que 5 e menor que 100!")
	private String nomeTreino;
	
	@Size(max = 5000, message = "O Link do Treino não pode ser maior que 5000 caracteres")
	private String link;
	
	@ManyToOne
	@JsonIgnoreProperties("Treinos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("Treinos")
	private Usuario usuario;

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTreino() {
		return nomeTreino;
	}

	public void setNomeTreino(String nomeTreino) {
		this.nomeTreino = nomeTreino;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
