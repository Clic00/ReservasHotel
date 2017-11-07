package modelo;

public enum TipoDeQuarto {
	DUPLO("Duplo"), MASTER("Master"), MEGA_ULTRA("Mega Ultra")
	, PRESIDENCIAL("Presidencial"),STANDARD("Padrão");
	
	private String nome;

	private TipoDeQuarto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	

}
