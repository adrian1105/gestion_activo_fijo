/*
* Archivo: AreaActivoFijoRq
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

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * objeto de ingreso.
 * @author amgonzalez
 */
@Data
public class AreaActivoFijoRq {

    @ApiModelProperty(value = "id del área")
    @NotNull(message = "El serial no areaId valores nulos. Por favor verifique e intente de nuevo.")
    private Integer areaId;

    @ApiModelProperty(value = "id del activo")
    @NotNull(message = "El activoId no permite valores nulos. Por favor verifique e intente de nuevo.")
    private Integer activoId;
}
