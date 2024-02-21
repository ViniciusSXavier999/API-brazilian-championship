package br.com.brazilian.championship.api.dto;


public class FinalizarJogoDTO {
	
	private Integer golsTime1;
	private Integer golsTime2;
	private Integer publicoPagante;
	
	
	public FinalizarJogoDTO() {
		
	}
	
	public FinalizarJogoDTO(Integer golsTime1, Integer golsTime2, Integer publicoPagante) {
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;
		this.publicoPagante = publicoPagante;
	}

	public Integer getGolsTime1() {
		return golsTime1;
	}

	public void setGolsTime1(Integer golsTime1) {
		this.golsTime1 = golsTime1;
	}

	public Integer getGolsTime2() {
		return golsTime2;
	}

	public void setGolsTime2(Integer golsTime2) {
		this.golsTime2 = golsTime2;
	}

	public Integer getPublicoPagante() {
		return publicoPagante;
	}

	public void setPublicoPagante(Integer publicoPagante) {
		this.publicoPagante = publicoPagante;
	}
	
	
	


}
