package drls.nails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import drls.nails.dao.AtendimentoDao;
import drls.nails.domain.Atendimento;

public class AtendimentoServiceImpl implements AtendimentoService{
	
	@Autowired
	private AtendimentoDao dao;
	
	@Override
	public void salvar(Atendimento atendimento) {
		dao.save(atendimento);
	}

	@Override
	public void editar(Atendimento atendimento) {
		dao.update(atendimento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Atendimento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Atendimento> buscarTodos() {
		return dao.findAll();
	}
}