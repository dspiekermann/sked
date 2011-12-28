package de.dsp.sked.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.dsp.sked.persistence.dao.KundenDAO;
import de.dsp.sked.persistence.model.Kunden;

@Service
public class KundenServiceImpl implements KundenService {

	@Autowired
	private KundenDAO kundenDAO;

	@Transactional
	public void addKunde(Kunden kunde) {
		kundenDAO.addKunde(kunde);
	}
	
	@Transactional
	public void updateKunde(Kunden kunde) {
		kundenDAO.updateKunde(kunde);
	}

	@Transactional
	public List<Kunden> listKunde() {
		return kundenDAO.listKunde();
	}

	@Transactional
	public void deleteKunde(int id) {
		kundenDAO.deleteKunde(id);
	}
	
	@Transactional
	public Kunden getKunde(int id) {
		return kundenDAO.getKunde(id);
	}

}