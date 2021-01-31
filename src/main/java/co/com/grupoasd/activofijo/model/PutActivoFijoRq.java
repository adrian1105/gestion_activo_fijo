/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
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
