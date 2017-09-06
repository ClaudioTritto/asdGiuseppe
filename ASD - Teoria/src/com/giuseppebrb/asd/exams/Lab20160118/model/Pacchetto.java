package Lab20160118.model;

public class Pacchetto {
	
	private String utente;
	private String destinatario;
	private int identificativo;
	private String dati;
	private boolean ultimo;
	public Pacchetto(String utente, String  destinatario, int identificativo, String dati, boolean ultimo) {
		this.utente = utente;
		this.destinatario = destinatario;
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}
	public String getUtente() {
		return utente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public int getIdentificativo() {
		return identificativo;
	}
	public String getDati() {
		return dati;
	}
	public boolean isUltimo() {
		return ultimo;
	}
	

}
