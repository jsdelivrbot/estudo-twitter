package br.com.brunogiannella.icase.itaucasetwitter.dto;

import java.io.Serializable;

public class RetornoConsulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3238928680426648159L;

	private Object retorno;

	public RetornoConsulta(Object data) {
		super();
		this.retorno = data;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}

}
