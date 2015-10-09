package br.senai.sc.ti2014n1.cleber.medicacao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sc.ti2014n1.cleber.medicacao.model.dominio.Paciente;

public class PacienteDao extends Dao {

	private final String INSERT = "INSERT INTO paciente (nome, dosagem, intervalo, duracao) values (?,?,?,?)";
	private final String UPDATE = "UPDATE paciente SET nome = ?,  dosagem = ?, intervalo = ?, duracao = ? WHERE id = ?";
	private final String DELETE = "DELETE FROM paciente WHERE id = ?";
	private final String SELECT = "SELECT * FROM paciente";
	private final String SELECT_ID = "SELECT * FROM paciente WHERE id = ?";

	public void salvar(Paciente paciente) throws Exception {
		if (paciente.getId() == 0) {
			inserir(paciente);
		} else {
			alterar(paciente);
		}
	}

	private void inserir(Paciente paciente) throws Exception {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, paciente.getNome());
			ps.setDouble(2, paciente.getDosagem());
			ps.setDouble(3, paciente.getIntervalo());
			ps.setDouble(4, paciente.getDuracao());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar salvar o paciente");
		}
	}

	public void alterar(Paciente paciente) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, paciente.getNome());
			ps.setDouble(2, paciente.getDosagem());
			ps.setDouble(3, paciente.getIntervalo());
			ps.setDouble(4, paciente.getDuracao());
			ps.setLong(5, paciente.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o update: " + e);
		}

	}

	public void excluir(Long id) throws Exception {
		try {
			PreparedStatement ps = getConnection().prepareStatement(DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro a executar o delete: " + e);
			throw new Exception("Erro ao tentar excluir");
		}
	}

	public List<Paciente> listarTodos() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setNome(rs.getString("nome"));
				paciente.setDosagem(rs.getDouble("dosagem"));
				paciente.setIntervalo(rs.getDouble("intervalo"));
				paciente.setDuracao(rs.getDouble("duracao"));
				paciente.setId(rs.getLong("id"));
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de paciente: " + e);
		}
		return pacientes;
	}

	public Paciente buscarPorId(Long id) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setNome(rs.getString("nome"));
				paciente.setDosagem(rs.getDouble("dosagem"));
				paciente.setIntervalo(rs.getDouble("intervalo"));
				paciente.setDuracao(rs.getDouble("duracao"));
				paciente.setId(rs.getLong("id"));
				return paciente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de paciente: " + e);
		}
		return null;
	}

}
