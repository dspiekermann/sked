package de.dsp.sked.persistence.service;

import java.util.List;

import de.dsp.sked.persistence.model.Kunden;

public interface KundenService {

	public void addKunde(Kunden kunde);
	public void updateKunde(Kunden kunde);
	public List<Kunden> listKunde();
	public void deleteKunde(int id);
	public Kunden getKunde(int id);
	
}