/*
* Archivo: PersonaActivoFijoRq
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
package co.com.grupoasd.activofijo.model;

import co.com.grupoasd.activofijo.entity.PersonaActivoFijo;
import co.com.grupoasd.activofijo.message.Mensaje;
import lombok.Data;

/**
 * Clase para guardar resultset de creacion de persona activo.
 * @author amgonzalez
 */
@Data
public class PersonaActivoFijoRs extends Mensaje{
    /**
     * objeto de repuestas.
     */
    private PersonaActivoFijo personaActivoFijos;
}
