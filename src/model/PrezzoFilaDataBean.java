package model;

import java.math.BigDecimal;

public class PrezzoFilaDataBean extends DataBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6701970490431967098L;
	private String periodo_nome;
	private int fila;
	private BigDecimal prezzo;
	private int minPosto,maxPosto;
	public PrezzoFilaDataBean(String periodo_nome, int fila, BigDecimal prezzo,
			int minPosto, int maxPosto) {
		super();
		this.periodo_nome = periodo_nome;
		this.fila = fila;
		this.prezzo = prezzo;
		this.minPosto = minPosto;
		this.maxPosto = maxPosto;
	}
	public PrezzoFilaDataBean() {
		super();
	}
	public String getPeriodo_nome() {
		return periodo_nome;
	}
	public void setPeriodo_nome(String periodo_nome) {
		this.periodo_nome = periodo_nome;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public int getMinPosto() {
		return minPosto;
	}
	public void setMinPosto(int minPosto) {
		this.minPosto = minPosto;
	}
	public int getMaxPosto() {
		return maxPosto;
	}
	public void setMaxPosto(int maxPosto) {
		this.maxPosto = maxPosto;
	}
	@Override
	public String toString() {
		return "PrezzoFilaDataBean [periodo_nome=" + periodo_nome + ", fila="
				+ fila + ", prezzo=" + prezzo + ", minPosto=" + minPosto
				+ ", maxPosto=" + maxPosto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fila;
		result = prime * result + maxPosto;
		result = prime * result + minPosto;
		result = prime * result
				+ ((periodo_nome == null) ? 0 : periodo_nome.hashCode());
		result = prime * result + ((prezzo == null) ? 0 : prezzo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrezzoFilaDataBean other = (PrezzoFilaDataBean) obj;
		if (fila != other.fila)
			return false;
		if (maxPosto != other.maxPosto)
			return false;
		if (minPosto != other.minPosto)
			return false;
		if (periodo_nome == null) {
			if (other.periodo_nome != null)
				return false;
		} else if (!periodo_nome.equals(other.periodo_nome))
			return false;
		if (prezzo == null) {
			if (other.prezzo != null)
				return false;
		} else if (!prezzo.equals(other.prezzo))
			return false;
		return true;
	}
	
	
	
	
}