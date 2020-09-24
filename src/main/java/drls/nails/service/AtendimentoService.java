package drls.nails.service;

import java.util.List;

import drls.nails.domain.Atendimento;

public interface AtendimentoService {
	
	void salvar(Atendimento atendimento);
	
	void editar(Atendimento	atendimento);
	
	void excluir(Long id);
	
	Atendimento buscarPorId(Long id);
	
	List<Atendimento> buscarTodos();

}