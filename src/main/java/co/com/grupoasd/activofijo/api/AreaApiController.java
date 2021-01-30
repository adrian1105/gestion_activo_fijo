/*
* Archivo: AreaApiController
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

import co.com.grupoasd.activofijo.service.AreaService;
import co.com.grupoasd.activofijo.model.AreaRs;
import co.com.grupoasd.activofijo.message.Mensaje;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.grupoasd.activofijo.entity.Area;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clase manejador de solicitudes HTTP.
 * @author adrian G
 */
@RestController
@Slf4j
public class AreaApiController {
    
    /**
     * Servicio de area.
     */
    private final AreaService areaService;

    /**
     * Constructor de los servicios.
     * @param areaService servicio de area
     */
    public AreaApiController(AreaService areaService) {
        this.areaService = areaService;
    }
    
    @ApiOperation(value = "Devuelve todas las áreas de la empresa")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = Area.class),
        @ApiResponse(code = 400, message = "Error en la peticion", response = Area.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Area.class)})
    @RequestMapping(value = "/obtener-area",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<AreaRs> getArea() {
        Mensaje msm = new Mensaje();
        try{
            AreaRs listAreas = areaService.getArea();
            if(listAreas.getAreas() != null){
                return new ResponseEntity<>(listAreas, HttpStatus.OK);
            } 
            return new ResponseEntity<>(listAreas, HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
