package br.com.brazilian.championship.api.dto;

import java.util.ArrayList;
import java.util.List;

public class ClassificacaoDTO {
	
	// atributo que é a lista de classificação dos times
	private List<ClassificacaoTimeDTO> times = new ArrayList<>();
	
	public ClassificacaoDTO () {
		
	}

	public ClassificacaoDTO(List<ClassificacaoTimeDTO> times) {
		this.times = times;
	}

	public List<ClassificacaoTimeDTO> getTimes() {
		return times;
	}

	public void setTimes(List<ClassificacaoTimeDTO> times) {
		this.times = times;
	}


	

}
