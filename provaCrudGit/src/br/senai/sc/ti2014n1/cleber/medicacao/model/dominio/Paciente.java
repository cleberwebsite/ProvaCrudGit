package br.senai.sc.ti2014n1.cleber.medicacao.model.dominio;

public class Paciente {
	private Long id;
	private String nome;
	private Double dosagem;
	private Double intervalo;
	private Double duracao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getDosagem() {
		return dosagem;
	}
	public void setDosagem(Double dosagem) {
		this.dosagem = dosagem;
	}
	public Double getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(Double intervalo) {
		this.intervalo = intervalo;
	}
	public Double getDuracao() {
		return duracao;
	}
	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}
	
	
	
}
