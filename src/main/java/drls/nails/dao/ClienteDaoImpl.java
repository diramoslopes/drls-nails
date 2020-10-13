package drls.nails.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import drls.nails.domain.Cliente;
import drls.nails.util.PaginacaoUtil;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente,Long> implements ClienteDao{

	@Override
	public List<Cliente> findByNome(String nome) {
		return createQuery("select c from Cliente c where c.nome like concat('%',?1,'%')", nome);
	}
	
	public PaginacaoUtil<Cliente> buscaPaginada(int pagina){
		
		int tamanho = 10;
		int inicio = (pagina - 1) * tamanho; // 1-1=0; 0*5=0 inicio ok / 2-1=1; 1*5=5inicio ok / 3-1=2; 2*5=10inicio ok
		
		List<Cliente> clientes = getEntityManager()
				.createQuery("select c from Cliente c order by c.nome asc", Cliente.class)
				.setFirstResult(inicio) // esse metodo indica qual a primeira posicao da sequencia de registros que queremos
				.setMaxResults(tamanho) //esse metodo informa quantos registros por paginas nos queremos receber
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, clientes);
	}
	
	public long count() { //esse metodo devolve o total de registros da tabela cliente
		return getEntityManager()
				.createQuery("select count(*) from Cliente", Long.class)
				.getSingleResult();
	}

}
