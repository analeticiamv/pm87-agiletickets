package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal CalculaPreco(Sessao sessao, Integer quantidade) {
			BigDecimal preco = null;
			if ((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) {
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			return preco.multiply(BigDecimal.valueOf(quantidade));
		}
	}, SHOW {
		@Override
		public BigDecimal CalculaPreco(Sessao sessao, Integer quantidade) {
			BigDecimal preco = null;
			if ((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) {
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
			return preco.multiply(BigDecimal.valueOf(quantidade));
		}
	}, TEATRO {
		@Override
		public BigDecimal CalculaPreco(Sessao sessao, Integer quantidade) {
			return sessao.getPreco().multiply(BigDecimal.valueOf(quantidade));
		}
	}, BALLET {
		@Override
		public BigDecimal CalculaPreco(Sessao sessao, Integer quantidade) {
			BigDecimal preco = null;
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		}
	}, ORQUESTRA {
		@Override
		public BigDecimal CalculaPreco(Sessao sessao, Integer quantidade) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
public abstract BigDecimal CalculaPreco(Sessao sessao, Integer quantidade);

}
