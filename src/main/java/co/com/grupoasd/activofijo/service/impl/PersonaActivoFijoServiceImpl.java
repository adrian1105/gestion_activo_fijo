/*
* Archivo: PersonaActivoFijoServiceImpl
* Fecha: 01/02/2021
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

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.entity.Estado;
import co.com.grupoasd.activofijo.entity.Persona;
import co.com.grupoasd.activofijo.entity.PersonaActivoFijo;
import co.com.grupoasd.activofijo.model.PersonaActivoFijoRq;
import co.com.grupoasd.activofijo.model.PersonaActivoFijoRs;
import co.com.grupoasd.activofijo.repository.ActivoFijoRepository;
import co.com.grupoasd.activofijo.repository.PersonaActivoFijoRepository;
import co.com.grupoasd.activofijo.repository.PersonaRepository;
import co.com.grupoasd.activofijo.service.PersonaActivoFijoService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Implementación de PersonaActivoFijoService.
 *
 * @author amgonzalez
 */
@Service
public class PersonaActivoFijoServiceImpl implements PersonaActivoFijoService {

    /**
     * Repositorio PersonaActivoFijoRepository.
     */
    private final PersonaActivoFijoRepository personaActivoFijoRepository;
    /**
     * Repositorio activoFijoRepository.
     */
    private final ActivoFijoRepository activoFijoRepository;
    /**
     * Repositorio PersonaRepository.
     */
    private final PersonaRepository PersonaRepository;

    public PersonaActivoFijoServiceImpl(PersonaActivoFijoRepository personaActivoFijoRepository,
            ActivoFijoRepository activoFijoRepository,
            PersonaRepository PersonaRepository) {
        this.personaActivoFijoRepository = personaActivoFijoRepository;
        this.activoFijoRepository = activoFijoRepository;
        this.PersonaRepository = PersonaRepository;
    }

    @Override
    public PersonaActivoFijoRs createPersonaActivo(PersonaActivoFijoRq personaActivoFijoRq) {
        PersonaActivoFijo personaActivoFijo = new PersonaActivoFijo();
        PersonaActivoFijoRs personaActivoFijoRs = new PersonaActivoFijoRs();

        ActivoFijo activoFijo = activoFijoRepository
                .findByActivoId(personaActivoFijoRq.getActivoId());
        if (activoFijo == null) {
            personaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_FIJO_NOT_FOUND);
            return personaActivoFijoRs;
        }

        if (activoFijo.getEstadoId().getId() == 5) {
            personaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_FIJO_ASIGNADO_NOT_FOUND);
            return personaActivoFijoRs;
        }

        Optional<Persona> persona = PersonaRepository.findById(personaActivoFijoRq.getPersonaId());
        if (persona.isEmpty()) {
            personaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_PERSONA_NOT_FOUND);
            return personaActivoFijoRs;
        }

        personaActivoFijo.setActivoFijoId(activoFijo);
        personaActivoFijo.setPersonaId(persona.get());

        personaActivoFijoRepository.save(personaActivoFijo);

        personaActivoFijoRs.setPersonaActivoFijos(personaActivoFijo);
        Estado estado = new Estado();

        estado.setId(5);
        activoFijo.setEstadoId(estado);
        activoFijoRepository.save(activoFijo);

        personaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_OK);

        return personaActivoFijoRs;
    }

}
