package drls.nails.service;

import java.util.List;


import drls.nails.domain.Cliente;
import drls.nails.util.PaginacaoUtil;

public interface ClienteService {
	
	void salvar(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void excluir(Long id);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();

	boolean clienteTemAtendimento(Long id);

	List<Cliente> buscarPorNome(String nome);
	
	PaginacaoUtil<Cliente> buscaPorPagina(int pagina);

}