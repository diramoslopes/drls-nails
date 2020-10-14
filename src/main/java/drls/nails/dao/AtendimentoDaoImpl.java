package drls.nails.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import drls.nails.domain.Atendimento;
import drls.nails.util.PaginacaoUtil;

@Repository
public class AtendimentoDaoImpl extends AbstractDao<Atendimento, Long> implements AtendimentoDao {

	@Override
	public List<Atendimento> findByClienteId(Long id) {
		return createQuery("select a from Atendimento a where a.cliente.id = ?1", id);
	}

	@Override
	public List<Atendimento> findByData(LocalDate data) {
		return createQuery("select a from Atendimento a where a.data = ?1", data);
	}
	
	public PaginacaoUtil<Atendimento> buscaPaginadaAtendimento(int pagina){
		
		int tamanho = 3;
		int inicio = (pagina - 1) * tamanho;
		
		List<Atendimento> atendimentos = getEntityManager()
				.createQuery("select a from Atendimento a order by a.data asc", Atendimento.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
				
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, atendimentos);
		
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Atendimento", Long.class)
				.getSingleResult();
	}
}