package drls.nails.domain;

import java.math.BigDecimal;

public enum Prestacao {
	
      MÃO ("Mão", new BigDecimal("15")),
      PÉ ("Pé", new BigDecimal("18")),
      MÃO_PÉ ("Mão e Pé", new BigDecimal("30")),
      SOMBRANCELHA ("Sombrancelha", new BigDecimal("15")),
      MÃO_PÉ_SOMBRANCELHA ("Mão, Pé e Sombrancelha", new BigDecimal("45")),
      MÃO_SOMBRANCELHA ("Mão e Sombrancelha", new BigDecimal("30")),
      PÉ_SOMBRANCELHA ("Pé e Sombrancelha", new BigDecimal("33"));
      
      private String descricao;
      private BigDecimal valor;
      
      Prestacao(String descricao, BigDecimal valor){
    	  this.descricao = descricao;
    	  this.valor = valor;
      }
      
      public String getDescricao() {
    	  return this.descricao;
      }
      
      public BigDecimal getValor() {
    	  return valor;
      }
}