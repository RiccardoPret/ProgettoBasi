package model;

import java.math.BigDecimal;
import java.sql.Date;

public class PrenotazioneDataBean {
	private int id,cliente;
	private Date data_inizio,data_fine, tipo_pagamento;
	private BigDecimal importo;
	
	public PrenotazioneDataBean(int id, int cliente, Date data_inizio,
			Date data_fine, Date tipo_pagamento, BigDecimal importo) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.tipo_pagamento = tipo_pagamento;
		this.importo = importo;
	}
	public PrenotazioneDataBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public Date getData_fine() {
		return data_fine;
	}
	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}
	public Date getTipo_pagamento() {
		return tipo_pagamento;
	}
	public void setTipo_pagamento(Date tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}
	public BigDecimal getImporto() {
		return importo;
	}
	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}
	@Override
	public String toString() {
		return "PrenotazioneDataBean [id=" + id + ", cliente=" + cliente
				+ ", data_inizio=" + data_inizio + ", data_fine=" + data_fine
				+ ", tipo_pagamento=" + tipo_pagamento + ", importo=" + importo
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cliente;
		result = prime * result
				+ ((data_fine == null) ? 0 : data_fine.hashCode());
		result = prime * result
				+ ((data_inizio == null) ? 0 : data_inizio.hashCode());
		result = prime * result + id;
		result = prime * result + ((importo == null) ? 0 : importo.hashCode());
		result = prime * result
				+ ((tipo_pagamento == null) ? 0 : tipo_pagamento.hashCode());
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
		PrenotazioneDataBean other = (PrenotazioneDataBean) obj;
		if (cliente != other.cliente)
			return false;
		if (data_fine == null) {
			if (other.data_fine != null)
				return false;
		} else if (!data_fine.equals(other.data_fine))
			return false;
		if (data_inizio == null) {
			if (other.data_inizio != null)
				return false;
		} else if (!data_inizio.equals(other.data_inizio))
			return false;
		if (id != other.id)
			return false;
		if (importo == null) {
			if (other.importo != null)
				return false;
		} else if (!importo.equals(other.importo))
			return false;
		if (tipo_pagamento == null) {
			if (other.tipo_pagamento != null)
				return false;
		} else if (!tipo_pagamento.equals(other.tipo_pagamento))
			return false;
		return true;
	}
}