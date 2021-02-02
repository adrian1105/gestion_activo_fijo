/*
* Archivo: AreaActivoFijoRepository
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
package co.com.grupoasd.activofijo.api;

import co.com.grupoasd.activofijo.model.AreaActivoFijoRq;
import co.com.grupoasd.activofijo.model.AreaActivoFijoRs;
import co.com.grupoasd.activofijo.service.AreaActivoFijoService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * controlador de servicios.
 * @author amgonzalez
 */
@RestController
public class AreaActivoFijoApiController {
    /**
     * manejador de log
     */
    private static final Logger logger = LoggerFactory.getLogger(ActivoFijoApiController.class);
    /**
     * servicio areaActivoFijoService.
     */
    private final AreaActivoFijoService areaActivoFijoService;
    
    /**
     * Constructor.
     * @param areaActivoFijoService servicio
     */
    public AreaActivoFijoApiController(AreaActivoFijoService areaActivoFijoService) {
        this.areaActivoFijoService = areaActivoFijoService;
    }
    
    @ApiOperation(value = "Asignación de activo fijo a una área")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = AreaActivoFijoRs.class),
        @ApiResponse(code = 400, message = "Error en la petición, verifique los datos faltantes"),
        @ApiResponse(code = 404, message = "Not Found  -  búsquedas sin resultados"),
        @ApiResponse(code = 500, message = "Internal Server Error - errores que pasen en la capa de backend")})
    @RequestMapping(value = "/asignar-activo-area",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<AreaActivoFijoRs> createAreaActivo(@ApiParam(value = "AreaActivoFijoRq", required = true)
            @Valid @RequestBody AreaActivoFijoRq areaActivoFijoRq) {

        try {
            AreaActivoFijoRs creaActivoFijoRs = areaActivoFijoService.createAreaActivo(areaActivoFijoRq);
            if (creaActivoFijoRs.getDescripcion().equals(TipoRespuesta.MESSAGE_ACTIVO_OK)) {
                return new ResponseEntity(creaActivoFijoRs, HttpStatus.OK);
            }
            return new ResponseEntity(creaActivoFijoRs, HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            logger.error("Ocurrió un error", e);
            AreaActivoFijoRs areaActivoFijoRs = new AreaActivoFijoRs();
            areaActivoFijoRs.setDescripcion(e.getMessage());
            return new ResponseEntity<>(areaActivoFijoRs, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            logger.error("Ocurrió un error", ex);
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
