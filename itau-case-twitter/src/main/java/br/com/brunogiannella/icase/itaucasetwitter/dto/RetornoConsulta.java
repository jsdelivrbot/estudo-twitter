package br.com.brunogiannella.icase.itaucasetwitter.dto;

import java.io.Serializable;

public class RetornoConsulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3238928680426648159L;
	
	private Object data;
	
	public RetornoConsulta(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
