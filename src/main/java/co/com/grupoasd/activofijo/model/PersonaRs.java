/*
* Archivo: PersonaRs
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
package co.com.grupoasd.activofijo.model;

import co.com.grupoasd.activofijo.message.Mensaje;
import co.com.grupoasd.activofijo.entity.Persona;
import java.util.List;
import lombok.Data;

/**
 * Clase para guardar resultset de persona.
 * @author adrian G
 */
@Data
public class PersonaRs extends Mensaje {
    /**
     * 
     */
    private List<Persona> personas;
}
