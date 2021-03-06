package drls.nails.dao;

import java.util.List;

import drls.nails.domain.Cliente;
import drls.nails.util.PaginacaoUtil;

public interface ClienteDao {
		
	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
	
	Cliente findById(Long id);
	
	List<Cliente> findAll();

	List<Cliente> findByNome(String nome);
	
	PaginacaoUtil<Cliente> buscaPaginada(int pagina);

}
