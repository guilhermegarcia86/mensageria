package br.com.messagin.jms.mensageria.model;

public class Mensagem {

	private String para;
	private String corpo;

	public Mensagem() {}

	public Mensagem(String para, String corpo) {
		this.para = para;
		this.corpo = corpo;
	}

	@Override
	public String toString() {
		return String.format("Mensagem [para=%s, corpo=%s]", this.getPara(), this.getCorpo());
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

}
