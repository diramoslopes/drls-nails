package drls.nails.service;

import java.util.List;

import drls.nails.domain.Cliente;

public interface ClienteService {
	
	void salvar(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void excluir(Long id);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();

}