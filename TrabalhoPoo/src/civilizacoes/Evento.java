package civilizacoes;

public class Evento extends Civilizacao  {
	protected int ano;
	protected String nome;
	protected String descricao;
	
	public Evento(String pais, String lingua, int ano, String nome, String descricao) {
		super(pais, lingua);
		this.ano = ano;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String Nome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Evento: "+ nome + ".\nOcorreu em:" + ano + "\nDescricao: " + descricao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
