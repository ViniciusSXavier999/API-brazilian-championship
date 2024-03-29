package br.com.brazilian.championship.api.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "tb_jogo")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer golsTime1;
	private Integer golsTime2;
	private Integer publicoPagante;
	private LocalDateTime data;
	private Integer rodada;
	private Boolean encerrado;
	/*Temos dois atributos que é uma chave estrangeira para outra tabela*/
	
	// Relação ManytoOne pois eu tenho muitos jogos para um time
	@ManyToOne
	@JoinColumn(name = "time1")
	private Time time1;
	
	@ManyToOne
	@JoinColumn(name = "time2")
	private Time time2;
	
	public Jogo() {
		
	}



	public Jogo(Long id, Integer golsTime1, Integer golsTime2, Integer publicoPagante, LocalDateTime data,
			Integer rodada, Boolean encerrado , Time time1, Time time2) {
		this.id = id;
		this.golsTime1 = golsTime1;
		this.golsTime2 = golsTime2;
		this.publicoPagante = publicoPagante;
		this.data = data;
		this.rodada = rodada;
		this.time1 = time1;
		this.time2 = time2;
		this.encerrado = encerrado;
	}







	public Time getTime1() {
		return time1;
	}




	public void setTime1(Time time1) {
		this.time1 = time1;
	}




	public Time getTime2() {
		return time2;
	}




	public void setTime2(Time time2) {
		this.time2 = time2;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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




	public LocalDateTime getData() {
		return data;
	}




	public void setData(LocalDateTime data) {
		this.data = data;
	}




	public Integer getRodada() {
		return rodada;
	}




	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}


	public Boolean getEncerrado() {
		return encerrado;
	}


	public void setEncerrado(Boolean encerrado) {
		this.encerrado = encerrado;
	}
	
	
	
}
	