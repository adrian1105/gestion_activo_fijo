/*
* Archivo: PersonaApiController
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
package co.com.grupoasd.activofijo.api;

import co.com.grupoasd.activofijo.model.PersonaRs;
import co.com.grupoasd.activofijo.service.PersonaService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase manejador de solicitudes HTTP.
 * @author adrian G
 */
@RestController
@Slf4j
public class PersonaApiController {
    
    /**
     * Servicio de persona.
     */
    private final PersonaService personaService;
    
    /**
     * Constructor
     * @param personaService servicio persona
     */
    public PersonaApiController(PersonaService personaService){
        this.personaService = personaService;
    }
    
    @ApiOperation(value = "Devuelve todas las personas de la empresa")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = PersonaRs.class),
        @ApiResponse(code = 400, message = "Error en la petición, verifique los datos faltantes"),
        @ApiResponse(code = 404, message = "Not Found  -  búsquedas sin resultados"),
        @ApiResponse(code = 500, message = "Internal Server Error - errores que pasen en la capa de backend")})
    @RequestMapping(value = "/obtener-personas",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PersonaRs> getPersona() {
        try{
            PersonaRs listPersonas = personaService.getPersona();
            if(listPersonas.getPersonas()!= null){
                return new ResponseEntity<>(listPersonas, HttpStatus.OK);
            } 
            return new ResponseEntity<>(listPersonas, HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
