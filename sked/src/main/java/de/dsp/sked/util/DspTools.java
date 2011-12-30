package de.dsp.sked.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class DspTools {
	
	public static boolean provided(Object[] obj){
		return obj!=null && obj.length>0;
	}
	public static boolean provided(List obj){
		return obj!=null && obj.size()>0;
	}
	public static boolean provided(String obj){
		return obj!=null && obj.length()>0;
	}
	
	public static <T> List<T> toList(T[] array){
		List<T> list = new ArrayList<T>();
		if (provided(array)){
			for (T a : array) {
				list.add(a);
			}
		}
		return list;
	}

	public static void redirect(String page) throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext servletContext = (ServletContext) context.getContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(servletContext.getContextPath() + page);
	}
	
	public static String getClientId(UIComponent parent, String id) {
		UIComponent component = findComponent(parent, id);
		if (component!=null){
			return component.getClientId();
		}
		return null;
	}
	
	private static UIComponent findComponent(UIComponent parent, String id) {
        if(id.equals(parent.getId())) {
                return parent;
        }
        Iterator<UIComponent> kids = parent.getFacetsAndChildren();
        while(kids.hasNext()) {
                UIComponent kid = kids.next();
                UIComponent found = findComponent(kid, id);
                if(found != null) {
                        return found;
                }
        }
        return null;
    }
	
}
