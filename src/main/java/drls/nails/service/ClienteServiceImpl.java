package drls.nails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import drls.nails.dao.ClienteDao;
import drls.nails.domain.Cliente;

@Service @Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao dao;

	@Override
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		dao.update(cliente);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean clienteTemAtendimento(Long id) {
		if(buscarPorId(id).getAtendimentos().isEmpty()) {
			return false;
		}
		return true;
	}

}