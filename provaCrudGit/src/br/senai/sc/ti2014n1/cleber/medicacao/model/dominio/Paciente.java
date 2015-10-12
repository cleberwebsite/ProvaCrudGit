package br.senai.sc.ti2014n1.cleber.medicacao.model.dominio;

public class Paciente {
	private Long id;
	private String nome;
	private Double dosagem;
	private String intervalo;
	private String duracao;
	
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
	public String getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
	
}
