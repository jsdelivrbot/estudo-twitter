package br.com.brunogiannella.icase.itaucasetwitter.dto;

import java.io.Serializable;
import java.util.List;

public class EntradaProcessarTwitter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891678213031169394L;

	private List<String> hashtags;

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

}
