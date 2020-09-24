package drls.nails.dao;

import java.util.List;

import drls.nails.domain.Atendimento;

public interface AtendimentoDao {
	void save(Atendimento atendimento);
	
	void update(Atendimento atendimento);
	
	void delete(Long id);
	
	Atendimento findById(Long id);
	
	List<Atendimento> findAll();
}
