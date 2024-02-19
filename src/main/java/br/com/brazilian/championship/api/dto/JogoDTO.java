package br.com.brazilian.championship.api.dto;

import java.time.LocalDateTime;

public class JogoDTO {
	
	private Long id;
	private LocalDateTime data;
	private Integer golsTime1;
	private Integer golsTime2;
	private Integer publicoPagante;
	private Boolean encerrado;
	private Integer rodada;
	private TimeDTO time1;
	private TimeDTO time2;
	
	public JogoDTO() {
		
	}

	public JogoDTO(Long id, LocalDateTime data, Integer golsTime1, Integer golsTime2, Integer publicoPagante,
			Boolean encerrado, Integer rodada, TimeDTO time1, TimeDTO time2) {
		this.id = id;
		this.data = data;
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;
		this.publicoPagante = publicoPagante;
		this.encerrado = encerrado;
		this.rodada = rodada;
		this.time1 = time1;
		this.time2 = time2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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

	public Boolean getEncerrado() {
		return encerrado;
	}

	public void setEncerrado(Boolean encerrado) {
		this.encerrado = encerrado;
	}

	public Integer getRodada() {
		return rodada;
	}

	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}

	public TimeDTO getTime1() {
		return time1;
	}

	public void setTime1(TimeDTO time1) {
		this.time1 = time1;
	}

	public TimeDTO getTime2() {
		return time2;
	}

	public void setTime2(TimeDTO time2) {
		this.time2 = time2;
	}
	
	
	
	
}
