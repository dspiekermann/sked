package de.dsp.sked.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kunden")
public class Kunden {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="VORNAME")
	private String vorname;
	
	@Column(name="NACHNAME")
	private String nachname;
	
	@Column(name="STRASSE")
	private String strasse;
	
	@Column(name="PLZ")
	private String plz;
	
	@Column(name="STADT")
	private String stadt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
}