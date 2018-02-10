package br.com.brunogiannella.icase.itaucasetwitter.model;

import org.springframework.data.annotation.Id;

public class TweetsHashTag {

	@Id
	public Long id;
	public String hashTag;
	public String pais;
	public Long total;

	public TweetsHashTag() {
	}

	public TweetsHashTag(Long id, String hashTag, String pais, Long total) {
		super();
		this.id = id;
		this.hashTag = hashTag;
		this.pais = pais;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
