/*
* Archivo: PersonaServiceImpl
* Fecha: 30/01/2021
* Todos los derechos de propiedad intelectual e industrial sobre esta
* aplicacion son de propiedad exclusiva del GRUPO ASD S.A.S.
* Su uso, alteracion, reproduccion o modificacion sin el debido
* consentimiento por escrito de GRUPO ASD S.A.S. quedan totalmente prohibidos.
* 
* Este programa se encuentra protegido por las disposiciones de la
* Ley 23 de 1982 y demas normas concordantes sobre derechos de autor y
* propiedad intelectual. Su uso no autorizado dara lugar a las sanciones
* previstas en la Ley.
 */
package co.com.grupoasd.activofijo.service.impl;

import co.com.grupoasd.activofijo.model.PersonaRs;
import co.com.grupoasd.activofijo.entity.Persona;
import co.com.grupoasd.activofijo.repository.PersonaRepository;
import co.com.grupoasd.activofijo.service.PersonaService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de PersonaService. 
 * @author adrian G
 */
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {
    
    /**
     * Repositorio personaRepository.
     */
    private final PersonaRepository personaRepository;
    
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    /**
     * Implementacion del metodo astacto de la interface.
     * @return  lista de personas
     */
    @Override
    public PersonaRs getPersona() {
         PersonaRs areaRs = new PersonaRs();
        List<Persona> personas = personaRepository.findAll();
        if (!personas.isEmpty()) {
            areaRs.setPersonas(personas);
            areaRs.setDescripcion(TipoRespuesta.MESSAGE_OK);
            
            return areaRs;
        }
        areaRs.setDescripcion(TipoRespuesta.MESSAGE_NOT_FOUND);
        return areaRs;
    }
    
}
