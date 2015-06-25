package model;

import java.sql.Date;

public class NoleggioGiornalieroDataBean extends DataBean{
	private Date data;
	private int posto_spiaggia_numero, prenotazione;
	private String posto_spiaggia_stabilimento;
	
	public NoleggioGiornalieroDataBean(Date data, int posto_spiaggia_numero,
			int prenotazione, String posto_spiaggia_stabilimento) {
		super();
		this.data = data;
		this.posto_spiaggia_numero = posto_spiaggia_numero;
		this.prenotazione = prenotazione;
		this.posto_spiaggia_stabilimento = posto_spiaggia_stabilimento;
	}

	public NoleggioGiornalieroDataBean() {
		super();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPosto_spiaggia_numero() {
		return posto_spiaggia_numero;
	}

	public void setPosto_spiaggia_numero(int posto_spiaggia_numero) {
		this.posto_spiaggia_numero = posto_spiaggia_numero;
	}

	public int getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}

	public String getPosto_spiaggia_stabilimento() {
		return posto_spiaggia_stabilimento;
	}

	public void setPosto_spiaggia_stabilimento(String posto_spiaggia_stabilimento) {
		this.posto_spiaggia_stabilimento = posto_spiaggia_stabilimento;
	}

	@Override
	public String toString() {
		return "NoleggioGiornalieroDataBean [data=" + data
				+ ", posto_spiaggia_numero=" + posto_spiaggia_numero
				+ ", prenotazione=" + prenotazione
				+ ", posto_spiaggia_stabilimento="
				+ posto_spiaggia_stabilimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + posto_spiaggia_numero;
		result = prime
				* result
				+ ((posto_spiaggia_stabilimento == null) ? 0
						: posto_spiaggia_stabilimento.hashCode());
		result = prime * result + prenotazione;
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
		NoleggioGiornalieroDataBean other = (NoleggioGiornalieroDataBean) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (posto_spiaggia_numero != other.posto_spiaggia_numero)
			return false;
		if (posto_spiaggia_stabilimento == null) {
			if (other.posto_spiaggia_stabilimento != null)
				return false;
		} else if (!posto_spiaggia_stabilimento
				.equals(other.posto_spiaggia_stabilimento))
			return false;
		if (prenotazione != other.prenotazione)
			return false;
		return true;
	}
	
	
}