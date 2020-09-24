package drls.nails.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ATENDIMENTOS")
public class Atendimento extends AbstractEntity<Long> {
	
	private Cliente cliente;
	
	private String prestacao;
	
	private LocalDate data;
	
	private BigDecimal valor;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getPrestacao() {
		return prestacao;
	}

	public void setPrestacao(String prestacao) {
		this.prestacao = prestacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
