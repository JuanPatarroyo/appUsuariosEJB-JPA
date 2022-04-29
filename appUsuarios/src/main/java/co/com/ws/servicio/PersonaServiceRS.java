/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ws.servicio;

import co.com.sga.domain.Persona;
import co.com.sga.servicio.PersonaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author jpatarroyo
 */
@Path("/personas")
@Stateless
public class PersonaServiceRS {

    @Inject
    private PersonaService servicio;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas() {
        return servicio.listarPersonas();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Persona getPersonById(@PathParam("id") int idPersona) {
        return servicio.encontrarPersonaPorId(new Persona(idPersona));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addPerson(Persona persona) {
        try {
            servicio.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updatePerson(@PathParam("id") int id, Persona modifiedPerson) {
        try {
            Persona persona = servicio.encontrarPersonaPorId(new Persona(id));
            if (persona == null) {
                return Response.status(Status.NOT_FOUND).build();
            }
            servicio.modificarPersona(modifiedPerson);
            return Response.ok().entity(modifiedPerson).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePersonById(@PathParam("id") int id) {
        try {
            servicio.eliminarPersona(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
