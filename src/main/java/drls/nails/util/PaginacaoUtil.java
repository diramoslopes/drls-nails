package drls.nails.util;

import java.util.List;

public class PaginacaoUtil<T> {

	private int tamanho; //armazena o numero de linhas que teremos nas paginas
	private int pagina; //armazena o numero da pagina atual selecionada pelo cliente
	private long totalDePaginas; //armazena o total de paginas que agnt tem no sistema de paginacao
	private List<T> registros; //essa variavel recebe o resultado da consulta do banco de dados
	
	public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, List<T> registros) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas;
		this.registros = registros;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getPagina() {
		return pagina;
	}

	public long getTotalDePaginas() {
		return totalDePaginas;
	}

	public List<T> getRegistros() {
		return registros;
	}
	
}
