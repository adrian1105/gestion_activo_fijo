/*
* Archivo: PutActivoFijoRq
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Clase para guardar resultset de activo.
 * @author adrian G
 */
@ApiModel(description = "objeto usado para actualizar activos fijos")
@Data
public class PutActivoFijoRq implements Serializable {
    /**
     * fechaBaja activo fijo
     */
    @ApiModelProperty(value = "fecha de baja del activo fijo")
    private String fechaBaja;
    /**
     * serial activo fijo.
     */
    @ApiModelProperty(value = "serial del activo fijo")
    @NotNull(message = "El serial no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Size(min = 5, max = 45, message = "Verifique que el serial este en el rango de 5 - 45 caracteres")
    private String serial;
}
