package drls.nails.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import drls.nails.domain.Atendimento;

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
	
}