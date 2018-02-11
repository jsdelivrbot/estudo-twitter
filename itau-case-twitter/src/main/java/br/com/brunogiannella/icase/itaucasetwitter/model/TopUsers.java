package br.com.brunogiannella.icase.itaucasetwitter.model;

import org.springframework.data.annotation.Id;

public class TopUsers {

	@Id
	private String apelido;
	private Long quantidadeSeguidores;

	public TopUsers() {}
	
	public TopUsers(String apelido, Long quantidadeSeguidores) {
		super();
		this.apelido = apelido;
		this.quantidadeSeguidores = quantidadeSeguidores;
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
