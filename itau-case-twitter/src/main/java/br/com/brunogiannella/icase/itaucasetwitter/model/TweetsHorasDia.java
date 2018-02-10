package br.com.brunogiannella.icase.itaucasetwitter.model;

import org.springframework.data.annotation.Id;

public class TweetsHorasDia {

	@Id
	private Long id;
	private String hora;
	private Long total;

	public TweetsHorasDia() {
	}

	public TweetsHorasDia(Long id, String hora, Long total) {
		super();
		this.id = id;
		this.hora = hora;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
