package de.dsp.sked.bean;

import java.io.IOException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import de.dsp.sked.common.IDspForwardConstants;
import de.dsp.sked.persistence.model.User;
import de.dsp.sked.persistence.service.UserService;
import de.dsp.sked.util.DspTools;

@Controller
@Scope("request")
public class RegisterBean extends JsfBeanAbstract{
	
	@Inject
	public UserService userService;
	
	@NotNull
	private String username = null;
	@NotNull
	private String password = null;
	@NotNull
	private String repassword = null;
	private String name = null;
	private String surname = null;
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
	private String email = null;
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean validateUsername() {
		User user = userService.findUserByUsername(username);
		if (user!=null){
		    String text = DspTools.getMsg("error.user_already_exists");			
		    String textDetail = DspTools.getMsg("error.user_already_exists_details");			
//			FacesMessage message = MessageFactory.getMessage(context, "error.user_already_exists", FacesMessage.SEVERITY_ERROR, (Object[])null); 
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, text, textDetail);
			UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
			FacesContext.getCurrentInstance().addMessage(DspTools.getClientId(root, "username"), message);
			return false;
		}
		return true;
	}

	public boolean validateEmail() {
		User user = userService.findUserByEmail(email);
		if (user!=null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "A user with this e-mail already registered.", "E-mail already exists. Please choose another one or check login credentials.");
			UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
			FacesContext.getCurrentInstance().addMessage(DspTools.getClientId(root, "email"), message);
			return false;
		}
		return true;
	}
	
	public boolean validatePasswords() {
		if (password==null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password is mandatory.", "Password is mandatory.");
			UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
			FacesContext.getCurrentInstance().addMessage(DspTools.getClientId(root, "password"), message);
			return false;
		}
		if (!password.equals(repassword)){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords not identical.", "Passwords not identical. Please retype them.");
			UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
			FacesContext.getCurrentInstance().addMessage(DspTools.getClientId(root, "repassword"), message);
			return false;
		}
		return true;
	}

	public boolean validate() {
		boolean validEmail = validateEmail();
		boolean validPassword = validatePasswords();
		boolean validUsername = validateUsername();
		
		return validEmail && validPassword && validUsername;
	}
	
	public void register() throws IOException{
		if (validate()){
			try{
				createUser();
				DspTools.redirect(IDspForwardConstants.LOGIN);
			} catch (Exception e){
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "User could not be created.", "User could not be created: " + e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
	
	private User createUser(){
		User user = new User();
		user.setCreateDate(new Date());
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setSurname(surname);
		user.setUsername(username);
		user.setEnabled(true);
		//TODO Gruppenzugehörigkeit eintragen
//		user.setGroup(persistenceBo.findUserGroupByName(UserGroup.MEMBER));
		userService.addUser(user);
		return user;
	}
	
}
