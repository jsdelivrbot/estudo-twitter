package br.com.brunogiannella.icase.itaucasetwitter.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author Bruno Giannella
 * 
 * Model para gravar os tweets
 */
public class Tweet {

	@Id
	private String id;
	private String texto;
	private String usuario;
	private String idUsuario;
	private String quantidadeSeguidores;
	private String pais;
	private String idioma;
	private Date data;
	private String hashtag;

	public Tweet() {
	}

	public Tweet(String id, String texto, String usuario, String idUsuario, String quantidadeSeguidores, String pais,
			String idioma, Date data, String hashtag) {
		super();
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.idUsuario = idUsuario;
		this.quantidadeSeguidores = quantidadeSeguidores;
		this.pais = pais;
		this.idioma = idioma;
		this.data = data;
		this.hashtag = hashtag;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getQuantidadeSeguidores() {
		return quantidadeSeguidores;
	}

	public void setQuantidadeSeguidores(String quantidadeSeguidores) {
		this.quantidadeSeguidores = quantidadeSeguidores;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
