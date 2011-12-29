package de.dsp.sked.bean;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class LoginBean {

    // This is the action method called when the user clicks the "login" button
    public String doLogin() throws IOException, ServletException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.dispatch("/j_spring_security_check");
        facesContext.responseComplete();
        return null;
    }	

    public String doLogout() throws IOException, ServletException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.dispatch("/j_spring_security_logout");
        facesContext.responseComplete();
        return null;
    }	
}
