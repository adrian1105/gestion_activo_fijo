/*
* Archivo: PersonaService
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
package co.com.grupoasd.activofijo.service;

import co.com.grupoasd.activofijo.model.PersonaRs;

/**
 * Interface de persona.
 *
 * @author adrian G
 */
public interface PersonaService {

    /**
     * interface para cargar lista listas de personas.
     *
     * @return lista de las personas que estan registradas
     */
    PersonaRs getPersona();
}
