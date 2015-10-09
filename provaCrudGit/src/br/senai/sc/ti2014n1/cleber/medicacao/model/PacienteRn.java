package br.senai.sc.ti2014n1.cleber.medicacao.model;

import java.util.List;

import br.senai.sc.ti2014n1.cleber.medicacao.dao.PacienteDao;
import br.senai.sc.ti2014n1.cleber.medicacao.model.dominio.Paciente;

public class PacienteRn {
	
	private PacienteDao dao;
	
	public PacienteRn() {
		dao = new PacienteDao();
	}

	public void salvar(Paciente paciente) throws Exception {
		if (paciente.getNome().trim().isEmpty()) {
			throw new Exception("O nome é obrigatório!");
		}

		if (paciente.getDosagem() > 0) {
			throw new Exception("A dosagem deve ser maior que 0 (zero)!");
		}
		
		if (paciente.getIntervalo() > 0) {
			throw new Exception("O intervalo deve ser maior que 0 (zero)!");
		}
		
		if (paciente.getDuracao() > 0) {
			throw new Exception("A duração deve ser maior que 0 (zero)!");
		}
		
		dao.salvar(paciente);
	}

	public List<Paciente> listar() {
		return dao.listarTodos();
	}

	public Paciente buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) throws Exception {
		dao.excluir(id);
	}

}
