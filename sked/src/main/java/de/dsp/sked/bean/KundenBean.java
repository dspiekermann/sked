package de.dsp.sked.bean;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import de.dsp.sked.persistence.model.Kunden;
import de.dsp.sked.persistence.service.KundenService;

@Controller
@Scope("request")
public class KundenBean {

	@Inject
	public KundenService kundenService;
 
	public String name;
	public String address;
	//getter and setter methods
	
	public void setKundenService(KundenService kundenService) {
		this.kundenService = kundenService;
	}
	
 
	public KundenService getKundenService() {
		return kundenService;
	}

	//get all customer data from database
	public List<Kunden> getKundenList(){
		return kundenService.listKunde();
	}
 
	//add a new customer data into database
	public String addKunde(){
 
		Kunden kunde = new Kunden();
		kunde.setNachname(getName());
		kunde.setStrasse(getAddress());
 
		kundenService.addKunde(kunde);
 
		clearForm();
 
		return "";
	}
 
	//clear form values
	private void clearForm(){
		setName("");
		setAddress("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
	
}
