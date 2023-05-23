package civilizacoes;

public class EventosEmComum extends Evento {
    private Civilizacao civilizacao1;
    private Civilizacao civilizacao2;

    public EventosEmComum(Civilizacao civilizacao1, Civilizacao civilizacao2, int ano, String nome, String descricao) {
        super("", "", ano, nome, descricao);
        this.civilizacao1 = civilizacao1;
        this.civilizacao2 = civilizacao2;
    }

    @Override
    public String toString() {
        return "EVENTO EM COMUM: " + nome +
                ". Este evento ocorreu entre os países: " + civilizacao1 +
                " e " + civilizacao2 +
                ", no ano de " + ano + "." +
                "\nSeu objetivo era: " + descricao;
    }

	public Civilizacao getCivilizacao1() {
		return civilizacao1;
	}

	public void setCivilizacao1(Civilizacao civilizacao1) {
		this.civilizacao1 = civilizacao1;
	}

	public Civilizacao getCivilizacao2() {
		return civilizacao2;
	}

	public void setCivilizacao2(Civilizacao civilizacao2) {
		this.civilizacao2 = civilizacao2;
	}
    
    
}
