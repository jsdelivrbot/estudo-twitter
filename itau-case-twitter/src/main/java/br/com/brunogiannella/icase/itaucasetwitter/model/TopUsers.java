package br.com.brunogiannella.icase.itaucasetwitter.model;

import org.springframework.data.annotation.Id;

public class TopUsers {

	@Id
	private Long id;
	private String nome;
	private String apelido;
	private Long quantidadeSeguidores;

	public TopUsers() {}
	
	public TopUsers(Long id, String nome, String apelido, Long quantidadeSeguidores) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.quantidadeSeguidores = quantidadeSeguidores;
	}

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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Long getQuantidadeSeguidores() {
		return quantidadeSeguidores;
	}

	public void setQuantidadeSeguidores(Long quantidadeSeguidores) {
		this.quantidadeSeguidores = quantidadeSeguidores;
	}

}
