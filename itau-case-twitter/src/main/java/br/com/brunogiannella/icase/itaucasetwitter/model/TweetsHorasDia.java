package br.com.brunogiannella.icase.itaucasetwitter.model;

/**
 * 
 * @author Bruno Giannella
 * 
 * Model para gravar os indicadores de Posts por hora do dia
 */
public class TweetsHorasDia {

	private Integer hora;
	private Long total;

	public TweetsHorasDia() {
	}

	public TweetsHorasDia(Integer hora, Long total) {
		super();
		this.hora = hora;
		this.total = total;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
