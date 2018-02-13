package br.com.brunogiannella.icase.itaucasetwitter.model;

/**
 * 
 * @author Bruno Giannella
 * 
 * Model para gravar os indicadores de HashTags por idioma
 */
public class TweetsHashTag {

	private String hashTag;
	private String pais;
	private Long total;

	public TweetsHashTag() {
	}

	public TweetsHashTag(String hashTag, String pais, Long total) {
		super();
		this.hashTag = hashTag;
		this.pais = pais;
		this.total = total;
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
