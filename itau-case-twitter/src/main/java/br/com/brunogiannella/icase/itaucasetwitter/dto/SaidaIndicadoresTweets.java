package br.com.brunogiannella.icase.itaucasetwitter.dto;

import java.io.Serializable;
import java.util.List;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHashTag;
import br.com.brunogiannella.icase.itaucasetwitter.model.TweetsHorasDia;

public class SaidaIndicadoresTweets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4474166716491696363L;

	private List<TopUsers> topUsers;
	private List<TweetsHashTag> hashTagsPorPais;
	private List<TweetsHorasDia> resumoTweetsPorHora;

	public List<TopUsers> getTopUsers() {
		return topUsers;
	}

	public void setTopUsers(List<TopUsers> topUsers) {
		this.topUsers = topUsers;
	}

	public List<TweetsHashTag> getHashTagsPorPais() {
		return hashTagsPorPais;
	}

	public void setHashTagsPorPais(List<TweetsHashTag> hashTagsPorPais) {
		this.hashTagsPorPais = hashTagsPorPais;
	}

	public List<TweetsHorasDia> getResumoTweetsPorHora() {
		return resumoTweetsPorHora;
	}

	public void setResumoTweetsPorHora(List<TweetsHorasDia> resumoTweetsPorHora) {
		this.resumoTweetsPorHora = resumoTweetsPorHora;
	}

}
