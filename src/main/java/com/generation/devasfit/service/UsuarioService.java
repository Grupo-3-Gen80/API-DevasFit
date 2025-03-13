package com.generation.devasfit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.devasfit.model.Treinos;
import com.generation.devasfit.model.Usuario;
import com.generation.devasfit.repository.TreinosRepository;
import com.generation.devasfit.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private TreinosRepository treinoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//bucar por id
	public Optional<Treinos> buscarTreinoPorId(Long id) {
        return treinoRepository.findById(id);
    }
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()).isPresent())
            return Optional.empty();

        return Optional.of(usuarioRepository.save(usuario));

    }

    public Optional<Usuario> atualizarUsuario(Usuario usuario) {

        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

            return Optional.ofNullable(usuarioRepository.save(usuario));

        }

        return Optional.empty();

    }
	
	// Calcular IMC do usuário
    public String calcularIMC(Long id) {
        Optional<Usuario> buscaUsuario = usuarioRepository.findById(id);

        if (buscaUsuario.isPresent()) { // Verifica se o usuário foi encontrado
            Usuario usuario = buscaUsuario.get(); // Recupera o objeto usuário

            if (usuario.getPeso() == 0 || usuario.getAltura() == 0) {
                throw new RuntimeException("Dados insuficientes para calcular IMC");
            }

            float peso = usuario.getPeso(); // Supondo que o atributo peso exista
            float altura = usuario.getAltura(); // Supondo que o atributo altura exista

            if (altura > 0) {
                float imc = peso / (altura * altura); // Cálculo do IMC
                String classificacao = classificarIMC(imc); // Classificação do IMC
                return String.format("Seu IMC é: %.2f - %s", imc, classificacao); // Retorno final
            } else {
                throw new IllegalArgumentException("Altura deve ser maior que zero.");
            }
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }
    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso ideal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else if (imc < 34.9) {
            return "Obesidade Grau I";
        } else if (imc < 39.9) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III (Mórbida)";
        }
    }
}