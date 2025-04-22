package com.generation.devasfit.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull(message = "O Atributo Nome é obrigatório")
	private String nomeUsuario; 
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O Atributo email é Obrigatório")
	@Email(message = "O Atributo email tem que ser válido")
	private String email;
	
	@Size(max = 5000, message = "O Link da foto não pode ser maior que 5000 caracteres")
	private String foto; 
	
	@NotBlank(message = "O Atributo Senha é obrigatório")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@NotNull(message = "O Atributo peso é Obrigatório")
	private float peso;
	
	@NotNull(message = "O Atributo altura é Obrigatório")
	private float altura;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Treinos> treinos;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public List<Treinos> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treinos> treinos) {
		this.treinos = treinos;
	}
	
	
}
