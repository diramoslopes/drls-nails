package drls.nails.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "ATENDIMENTOS")
public class Atendimento extends AbstractEntity<Long> {
	
	@NotNull(message = "Selecione o cliente relativo ao atendimento")
	@ManyToOne
	@JoinColumn(name = "cliente_id_fk")
	private Cliente cliente;
	
	@NotNull(message = "Selecione uma prestação")
	@Enumerated(EnumType.STRING)
	private Prestacao prestacao;
	
	@NotNull(message = "Data é obrigatória")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	@NotNull (message = "Valor é obrigatório")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00" )
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valor;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prestacao getPrestacao() {
		return prestacao;
	}

	public void setPrestacao(Prestacao prestacao) {
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