package civilizacoes;

public class Civilizacao {
	protected String pais;
	protected String lingua;
	
	public Civilizacao(String pais, String lingua) {
		this.pais = pais;
		this.lingua = lingua;
	}
	
	@Override
	public String toString() {
		return pais + " - L�ngua: " + lingua;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	
	
	
}
