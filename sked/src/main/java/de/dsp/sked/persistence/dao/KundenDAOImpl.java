package de.dsp.sked.persistence.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dsp.sked.persistence.model.Kunden;

@Repository
public class KundenDAOImpl implements KundenDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Fügt einen neuen Kunden hinzu
	 */
	
	public void addKunde(Kunden kunde) {
		sessionFactory.getCurrentSession().save(kunde);
	}

	/**
	 * Holt alle Kunden aus der Datenbank
	 */
	
	public List<Kunden> listKunde() {
		return sessionFactory.getCurrentSession().createQuery("from Kunden").list();
	}

	/**
	 * Löscht einen Kunden aus der Datenbank
	 */
	
	public void deleteKunde(int id) {
		Kunden kunde = (Kunden) sessionFactory.getCurrentSession().load(
				Kunden.class, id);
        if (kunde != null) {
        	sessionFactory.getCurrentSession().delete(kunde);
        }
	}
	
	/**
	 * Lädt einen einzelnen Kunden aus der Datenbank
	 */

	public Kunden getKunde(int id) {
		Kunden kunde = (Kunden) sessionFactory.openSession().load(
				Kunden.class, id);
		return kunde;
	}

	public void updateKunde(Kunden kunde) {
		sessionFactory.getCurrentSession().update(kunde);		
	}

}