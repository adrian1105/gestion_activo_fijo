/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
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
