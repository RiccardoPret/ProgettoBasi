package model;

public class PostoSpiaggiaDataBean extends DataBean{
	private int numero,fila,numero_sdraio;
	private String stabilimento;
	
	public PostoSpiaggiaDataBean(int numero, int fila, int numero_sdraio,
			String stabilimento) {
		super();
		this.numero = numero;
		this.fila = fila;
		this.numero_sdraio = numero_sdraio;
		this.stabilimento = stabilimento;
	}
	public PostoSpiaggiaDataBean() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getNumero_sdraio() {
		return numero_sdraio;
	}
	public void setNumero_sdraio(int numero_sdraio) {
		this.numero_sdraio = numero_sdraio;
	}
	public String getStabilimento() {
		return stabilimento;
	}
	public void setStabilimento(String stabilimento) {
		this.stabilimento = stabilimento;
	}
	@Override
	public String toString() {
		return "PostoSpiaggiaDataBean [numero=" + numero + ", fila=" + fila
				+ ", numero_sdraio=" + numero_sdraio + ", stabilimento="
				+ stabilimento + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fila;
		result = prime * result + numero;
		result = prime * result + numero_sdraio;
		result = prime * result
				+ ((stabilimento == null) ? 0 : stabilimento.hashCode());
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
		PostoSpiaggiaDataBean other = (PostoSpiaggiaDataBean) obj;
		if (fila != other.fila)
			return false;
		if (numero != other.numero)
			return false;
		if (numero_sdraio != other.numero_sdraio)
			return false;
		if (stabilimento == null) {
			if (other.stabilimento != null)
				return false;
		} else if (!stabilimento.equals(other.stabilimento))
			return false;
		return true;
	}
}