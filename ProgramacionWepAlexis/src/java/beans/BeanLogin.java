/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author AlexisO
 */
@Named(value = "beanLogin")
@RequestScoped
public class BeanLogin implements Serializable  {

    
    private String usuario, contrasenia;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
    public String comprobar() {
        String url= null;
        FacesMessage mensaje;
        if (usuario.equals("alexis") && contrasenia.equals("123456")) {
            System.out.println("Datos Correctos");
            mensaje= new FacesMessage(FacesMessage.SEVERITY_INFO,"Datos correctos"," ");
            url= "/sga/Pagina1.xhtml?faces-redirect=true";
        } else {
            System.out.println("Datos Incorrectos");
            mensaje= new FacesMessage(FacesMessage.SEVERITY_INFO,"Datos Incorrectos","");
        }
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        return url;
    }

    }

    
    
    

