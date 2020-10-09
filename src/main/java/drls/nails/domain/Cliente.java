package drls.nails.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long>{
	
	@NotBlank(message = "Nome é obrigatório.")
	@Size(min = 2, max = 60, message = "O nome do cliente deve ter entre {min} e {max} caracteres.")
	private String nome;
	
	@OneToMany(mappedBy = "cliente")
	private List<Atendimento> atendimentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
}
