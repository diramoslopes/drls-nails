package drls.nails.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import drls.nails.dao.AtendimentoDao;
import drls.nails.domain.Atendimento;
import drls.nails.util.PaginacaoUtil;

@Service @Transactional(readOnly = false)
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

	@Override @Transactional(readOnly = true)
	public Atendimento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Atendimento> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Atendimento> buscarPorCliente(Long id) {
		return dao.findByClienteId(id);
	}

	@Override
	public List<Atendimento> buscarPorData(LocalDate data) {
		return dao.findByData(data);
	}

	@Override
	public PaginacaoUtil<Atendimento> buscaPorPaginaAtendimento(int pagina) {
		return dao.buscaPaginadaAtendimento(pagina);
	}
}