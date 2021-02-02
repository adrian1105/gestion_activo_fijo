/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.service;

import co.com.grupoasd.activofijo.model.PersonaActivoFijoRq;
import co.com.grupoasd.activofijo.model.PersonaActivoFijoRs;

/**
 *
 * @author amgonzalez
 */
public interface PersonaActivoFijoService {
    /**
     * servicio  personaActivoFijoRq
     * @param personaActivoFijoRq
     * @return respuesta de la petición
     */
    PersonaActivoFijoRs createPersonaActivo(PersonaActivoFijoRq personaActivoFijoRq);
}
