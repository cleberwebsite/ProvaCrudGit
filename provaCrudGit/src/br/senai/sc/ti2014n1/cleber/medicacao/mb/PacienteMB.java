package br.senai.sc.ti2014n1.cleber.medicacao.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ti2014n1.cleber.medicacao.model.PacienteRn;
import br.senai.sc.ti2014n1.cleber.medicacao.model.dominio.Paciente;

@ManagedBean 
public class PacienteMB {
	private List<Paciente> usuarios;
	private Paciente paciente;
	private PacienteRn rn;
	
	@PostConstruct
	public void init(){
		rn = new PacienteRn();
		paciente = new Paciente();
	}

	public List<Paciente> getPacientes() {
		if(usuarios == null){
			usuarios = rn.listar();
 		}
		return usuarios;
	}

	public void setPasientes(List<Paciente> pacientes) {
		this.usuarios = pacientes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String salvar(){
		try {
			rn.salvar(paciente);
		} catch (Exception e) {
			return "";
		}
		return "pacientelist";
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		try {
			rn.excluir(id);
			usuarios = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.parseLong(idParam);
		paciente = rn.buscarPorId(id);
		return "pacienteform";
	}
	
}
