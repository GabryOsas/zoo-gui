package me.gabryosas;

public class Animali {
	private String nome;
	private String specie;
	private String verso;
	private int eta;
	private int zampe;
	
	public Animali(String nome, String specie, String verso, int eta, int zampe) {
		super();
		this.nome = nome;
		this.specie = specie;
		this.verso = verso;
		this.eta = eta;
		this.zampe = zampe;
	}
	public void descrivi() {
		System.out.println("Nome:" + this.nome);
		System.out.println("Specie:" + this.specie);
		System.out.println("Età:" + this.eta);
		System.out.println("Verso:" + this.verso);
	}
	public void compleanno() {
		this.eta++;
		System.out.println("Età: " + this.eta);
	}
	public void verso() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Verso:" + this.verso);
		}
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getVerso() {
		return verso;
	}

	public void setVerso(String verso) {
		this.verso = verso;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getZampe() {
		return zampe;
	}

	public void setZampe(int zampe) {
		this.zampe = zampe;
	}

}
