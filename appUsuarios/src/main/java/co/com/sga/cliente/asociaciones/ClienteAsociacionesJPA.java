package co.com.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import co.com.sga.domain.Persona;
import co.com.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //cerramos la conexion
        em.close();
        
        //Imprimir los objetos de tipo persona
        for(Persona persona : personas){
            log.debug("Persona:" + persona);
            //recuperamos los usuarios de cada persona
            for(Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario:" + usuario);
            }
        }
    }
}
