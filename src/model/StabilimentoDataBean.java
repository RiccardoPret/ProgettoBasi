package model;

import java.sql.Date;
import java.sql.Time;

public class StabilimentoDataBean extends DataBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9093044109155664671L;
	private String nome, localita,via,civico,citta,responsabile,telefono;
	private Date data_apertura,data_chiusura;
	private boolean ha_salagiochi,ha_volley,ha_bocce,ha_ristorante;
	private Time h_apertura,h_chiusura;
	private String specialita;
	
	public StabilimentoDataBean(String nome, String localita, String via,
			String civico, String citta, String responsabile, String telefono,
			Date data_apertura, Date data_chiusura, boolean ha_salagiochi,
			boolean ha_volley, boolean ha_bocce, boolean ha_ristorante,
			Time h_apertura, Time h_chiusura, String specialita) {
		super();
		this.nome = nome;
		this.localita = localita;
		this.via = via;
		this.civico = civico;
		this.citta = citta;
		this.responsabile = responsabile;
		this.telefono = telefono;
		this.data_apertura = data_apertura;
		this.data_chiusura = data_chiusura;
		this.ha_salagiochi = ha_salagiochi;
		this.ha_volley = ha_volley;
		this.ha_bocce = ha_bocce;
		this.ha_ristorante = ha_ristorante;
		this.h_apertura = h_apertura;
		this.h_chiusura = h_chiusura;
		this.specialita = specialita;
	}
	public StabilimentoDataBean() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getResponsabile() {
		return responsabile;
	}
	public void setResponsabile(String responsabile) {
		this.responsabile = responsabile;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getData_apertura() {
		return data_apertura;
	}
	public void setData_apertura(Date data_apertura) {
		this.data_apertura = data_apertura;
	}
	public Date getData_chiusura() {
		return data_chiusura;
	}
	public void setData_chiusura(Date data_chiusura) {
		this.data_chiusura = data_chiusura;
	}
	public boolean isHa_salagiochi() {
		return ha_salagiochi;
	}
	public void setHa_salagiochi(boolean ha_salagiochi) {
		this.ha_salagiochi = ha_salagiochi;
	}
	public boolean isHa_volley() {
		return ha_volley;
	}
	public void setHa_volley(boolean ha_volley) {
		this.ha_volley = ha_volley;
	}
	public boolean isHa_bocce() {
		return ha_bocce;
	}
	public void setHa_bocce(boolean ha_bocce) {
		this.ha_bocce = ha_bocce;
	}
	public boolean isHa_ristorante() {
		return ha_ristorante;
	}
	public void setHa_ristorante(boolean ha_ristorante) {
		this.ha_ristorante = ha_ristorante;
	}
	public Time getH_apertura() {
		return h_apertura;
	}
	public void setH_apertura(Time h_apertura) {
		this.h_apertura = h_apertura;
	}
	public Time getH_chiusura() {
		return h_chiusura;
	}
	public void setH_chiusura(Time h_chiusura) {
		this.h_chiusura = h_chiusura;
	}
	public String getSpecialita() {
		return specialita;
	}
	public void setSpecialita(String specialita) {
		this.specialita = specialita;
	}
	@Override
	public String toString() {
		return "StabilimentoDataBean [nome=" + nome + ", localita=" + localita
				+ ", via=" + via + ", civico=" + civico + ", citta=" + citta
				+ ", responsabile=" + responsabile + ", telefono=" + telefono
				+ ", data_apertura=" + data_apertura + ", data_chiusura="
				+ data_chiusura + ", ha_salagiochi=" + ha_salagiochi
				+ ", ha_volley=" + ha_volley + ", ha_bocce=" + ha_bocce
				+ ", ha_ristorante=" + ha_ristorante + ", h_apertura="
				+ h_apertura + ", h_chiusura=" + h_chiusura + ", specialita="
				+ specialita + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((civico == null) ? 0 : civico.hashCode());
		result = prime * result
				+ ((data_apertura == null) ? 0 : data_apertura.hashCode());
		result = prime * result
				+ ((data_chiusura == null) ? 0 : data_chiusura.hashCode());
		result = prime * result
				+ ((h_apertura == null) ? 0 : h_apertura.hashCode());
		result = prime * result
				+ ((h_chiusura == null) ? 0 : h_chiusura.hashCode());
		result = prime * result + (ha_bocce ? 1231 : 1237);
		result = prime * result + (ha_ristorante ? 1231 : 1237);
		result = prime * result + (ha_salagiochi ? 1231 : 1237);
		result = prime * result + (ha_volley ? 1231 : 1237);
		result = prime * result
				+ ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((responsabile == null) ? 0 : responsabile.hashCode());
		result = prime * result
				+ ((specialita == null) ? 0 : specialita.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
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
		StabilimentoDataBean other = (StabilimentoDataBean) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (civico == null) {
			if (other.civico != null)
				return false;
		} else if (!civico.equals(other.civico))
			return false;
		if (data_apertura == null) {
			if (other.data_apertura != null)
				return false;
		} else if (!data_apertura.equals(other.data_apertura))
			return false;
		if (data_chiusura == null) {
			if (other.data_chiusura != null)
				return false;
		} else if (!data_chiusura.equals(other.data_chiusura))
			return false;
		if (h_apertura == null) {
			if (other.h_apertura != null)
				return false;
		} else if (!h_apertura.equals(other.h_apertura))
			return false;
		if (h_chiusura == null) {
			if (other.h_chiusura != null)
				return false;
		} else if (!h_chiusura.equals(other.h_chiusura))
			return false;
		if (ha_bocce != other.ha_bocce)
			return false;
		if (ha_ristorante != other.ha_ristorante)
			return false;
		if (ha_salagiochi != other.ha_salagiochi)
			return false;
		if (ha_volley != other.ha_volley)
			return false;
		if (localita == null) {
			if (other.localita != null)
				return false;
		} else if (!localita.equals(other.localita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsabile == null) {
			if (other.responsabile != null)
				return false;
		} else if (!responsabile.equals(other.responsabile))
			return false;
		if (specialita == null) {
			if (other.specialita != null)
				return false;
		} else if (!specialita.equals(other.specialita))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}
	
	
}