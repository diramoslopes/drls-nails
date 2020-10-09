package drls.nails.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import drls.nails.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente,Long> implements ClienteDao{

	@Override
	public List<Cliente> findByNome(String nome) {
		return createQuery("select c from Cliente c where c.nome like concat('%',?1,'%')", nome);
	}

}
