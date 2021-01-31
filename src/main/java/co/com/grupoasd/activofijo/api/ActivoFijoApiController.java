/*
* Archivo: ActivoFijoApiController
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

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.model.ActivoFijoRs;
import co.com.grupoasd.activofijo.model.PutActivoFijoRq;
import co.com.grupoasd.activofijo.model.PutActivoFijoRs;
import co.com.grupoasd.activofijo.service.ActivoFijoService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase manejador de solicitudes HTTP.
 *
 * @author adrian G
 */
@RestController
@Slf4j
public class ActivoFijoApiController {

    /**
     * Servicio de activoFijoService.
     */
    private final ActivoFijoService activoFijoService;

    public ActivoFijoApiController(ActivoFijoService activoFijoService) {
        this.activoFijoService = activoFijoService;
    }

    @ApiOperation(value = "Devuelve todos los activos de la empresa")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = ActivoFijo.class),
        @ApiResponse(code = 400, message = "Error en la petición", response = ActivoFijo.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ActivoFijo.class)})
    @RequestMapping(value = "/obtener-activo-fijos",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ActivoFijoRs> getActivoFijo() {
        try {
            ActivoFijoRs listActivos = activoFijoService.getActivoFijo();
            if (listActivos.getActivoFijos() != null) {
                return new ResponseEntity<>(listActivos, HttpStatus.OK);
            }
            return new ResponseEntity<>(listActivos, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Devuelve todos los activos de la empresa segun los parametros")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = ActivoFijo.class),
        @ApiResponse(code = 400, message = "Error en la petición", response = ActivoFijo.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ActivoFijo.class)})
    @RequestMapping(value = "/buscar-activo-fijos",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ActivoFijoRs> getSearchActivoFijo(@RequestParam(required = false) String tipoId,
            @RequestParam(required = false) String fechaCompra,
            @RequestParam(required = false) String serial) {
        try {
            ActivoFijoRs listActivos = activoFijoService.getSearchActivoFijo(tipoId, fechaCompra, serial);
            if (listActivos.getActivoFijos() != null) {
                return new ResponseEntity<>(listActivos, HttpStatus.OK);
            }
            return new ResponseEntity<>(listActivos, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Devuelve todos los activos de la empresa segun los parametros")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Se consultó exitosamente", response = ActivoFijo.class),
        @ApiResponse(code = 400, message = "Error en la petición", response = ActivoFijo.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ActivoFijo.class)})
    @RequestMapping(value = "/actualizar-activo-fijos/{id}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<PutActivoFijoRs> putActivoFijo(@PathVariable("id") Integer id,
           @ApiParam(value = "PutActivoFijoRq", required = true)
           @Valid @RequestBody PutActivoFijoRq putActivoFijoRq) {
       
        try {
            PutActivoFijoRs activoFijo = activoFijoService.putActivoFijo(id, putActivoFijoRq);
            if (!"".equals(activoFijo.getNombreActivoFijo()) && activoFijo.getNombreActivoFijo() != null) {
                return new ResponseEntity(activoFijo, HttpStatus.OK);
            }
            return new ResponseEntity(activoFijo, HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            PutActivoFijoRs putActivoFijoRs = new PutActivoFijoRs();
            putActivoFijoRs.setDescripcion(e.getMessage());
            return new ResponseEntity<>(putActivoFijoRs, HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex) {
            return new ResponseEntity(TipoRespuesta.MESSAGE_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
