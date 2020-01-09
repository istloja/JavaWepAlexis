/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Utilidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexisO
 */
@Stateless
@Path("utilidades.persona")
public class PersonaFacadeREST extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "ProgramacionWepAlexisPU")
    private EntityManager em;

    public PersonaFacadeREST() {
        super(Persona.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Persona entity) {
        super.create(entity);
    }

    //metodo post para traer objetos
    @POST
    @Path("obtenerPersona")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})

    public Persona obtenerIdPersona(@FormParam("idUsuario") Integer idU) {

        return super.find(idU);
    }

    //metodo para Crear Usuarios
    @POST
    @Path("crearUsuario")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String MetodoCrearPersona(@FormParam("idUsuario") Integer idUsuario, @FormParam("cedula") Integer cedula, @FormParam("nombres") String nombres, @FormParam("apellidos") String apellidos, @FormParam("contrasenia") String contrasena, @FormParam("tipoUsuario") Integer tipoUsuario) {

        Persona per = new Persona();
        per.setIdUsuario(idUsuario);
        per.setCedula(cedula);
        per.setNombres(nombres);
        per.setApellidos(apellidos);
        per.setContrasenia(contrasena);
        per.setTipoUsuario(tipoUsuario);

        super.create(per);

        return "Usuario Creado";
    }
    //metodo para Editar Usuarios
    @POST
    @Path("EditarUsuario")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String MetodoEditarPersona(@FormParam("idUsuario") Integer idUsuario, @FormParam("cedula") Integer cedula, @FormParam("nombres") String nombres, @FormParam("apellidos") String apellidos, @FormParam("contrasenia") String contrasena, @FormParam("tipoUsuario") Integer tipoUsuario){
       
        Persona per ;
        
        per= super.find(idUsuario);
        per.setIdUsuario(idUsuario);
        per.setCedula(cedula);
        per.setNombres(nombres);
        per.setApellidos(apellidos);
        per.setContrasenia(contrasena);
        per.setTipoUsuario(tipoUsuario);
        
        
        super.edit(per);
    
    return "Datos Editados";
    }
    
    

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Persona entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
        System.out.println("enviar");
        return super.findAll();
    }

    @POST
    @Path("post")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Persona> findAllPost() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
