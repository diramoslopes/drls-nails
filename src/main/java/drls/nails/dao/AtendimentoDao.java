package drls.nails.dao;

import java.time.LocalDate;
import java.util.List;

import drls.nails.domain.Atendimento;
import drls.nails.util.PaginacaoUtil;

public interface AtendimentoDao {
	
	void save(Atendimento atendimento);
	
	void update(Atendimento atendimento);
	
	void delete(Long id);
	
	Atendimento findById(Long id);
	
	List<Atendimento> findAll();

	List<Atendimento> findByClienteId(Long id);

	List<Atendimento> findByData(LocalDate data);
	
	PaginacaoUtil<Atendimento> buscaPaginadaAtendimento(int pagina);

}
