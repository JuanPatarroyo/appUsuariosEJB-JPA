package co.com.sga.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.com.sga.domain.Persona;
import co.com.sga.servicio.PersonaService;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

@Named("personaBean")
@RequestScoped
public class PersonaBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private PersonaService personaService;

    private Persona personaSeleccionada;

    List<Persona> personas;

    List<Persona> personasFilter;

    public PersonaBean() {
        log.debug("Iniciando el objeto PersonaBean");
    }

    @PostConstruct
    public void inicializar() {
        this.personas = personaService.listarPersonas();
        this.personaSeleccionada = new Persona();
    }

    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.modificarPersona(persona);
    }

    public void agregarPersona() {
        this.personaService.registrarPersona(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void eliminarPersona() {
        this.personaService.eliminarPersona(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void reiniciarPersonaSeleccionada() {
        this.personaSeleccionada = new Persona();
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonasFilter() {
        return personasFilter;
    }

    public void setPersonasFilter(List<Persona> personasFilter) {
        this.personasFilter = personasFilter;
    }
}
