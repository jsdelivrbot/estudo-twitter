package br.com.brunogiannella.icase.itaucasetwitter.dto;

import java.io.Serializable;

import br.com.brunogiannella.icase.itaucasetwitter.model.TopUsers;

public class SaidaIndicadoresTweets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4474166716491696363L;

	private TopUsers topUsers;

	public TopUsers getTopUsers() {
		return topUsers;
	}

	public void setTopUsers(TopUsers topUsers) {
		this.topUsers = topUsers;
	}

}
