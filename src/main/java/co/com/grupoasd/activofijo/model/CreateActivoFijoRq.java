/*
* Archivo: ActivoFijoRq
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

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Clase para guardar resultset de area.
 * @author adrian G
 */
@Data
public class CreateActivoFijoRq {
    /**
     * nombre del activo_fijo.
     */
    @javax.validation.constraints.NotNull(message = "El tipo de activo no permite valores nulos. Por favor verifique e intente de nuevo.")
    @NotBlank(message = "El tipo de activo  no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Size(min = 5, max = 100, message = "Verifique que el nombre este en el rango de 5 hasta 100 caracteres")
    private String nombre;
    
    /**
     * descripcion del activo_fijo.
     */
    @Size(max = 500)
    private String descripcion;
    
    /**
     * tipo del activo_fijo
     */
    @javax.validation.constraints.NotNull(message = "El tipo de activo no permite valores nulos. Por favor verifique e intente de nuevo.")
    private Integer tipoId;
    
    /**
     * serial del activo_fijo.
     */
    @javax.validation.constraints.NotNull(message = "El serial no permite valores nulos. Por favor verifique e intente de nuevo.")
    @NotBlank(message = "El serial  no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Size(min = 5, max = 45, message = "Verifique que el serial este en el rango de 5 - 45 caracteres")
    private String serial;
    
    /**
     * numero interno del activo_fijo.
     */
    @javax.validation.constraints.NotNull(message = "El numero interno no permite valores nulos. Por favor verifique e intente de nuevo.")
    @NotBlank(message = "El numero interno  no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Size(max = 10, message = "Verifique que el numero interno sea menor a 10 digitos")
    private String numeroInterno;
    
    /**
     * peso del activo_fijo.
     */
    @Size(max = 45, message = "El pero no puede ser mayor a 45 caracteres")
    private String peso;
    
    /**
     * alto del activo_fijo.
     */
    @Size(max = 45, message = "El alto no puede ser mayor a 45 caracteres")
    private String alto;
    
    /**
     * ancho del activo_fijo.
     */
    @Size(max = 45, message = "El ancho no puede ser mayor a 45 caracteres")
    private String ancho;
    
    /**
     * largo del activo_fijo.
     */
    @Size(max = 45, message = "El largo no puede ser mayor a 45 caracteres")
    private String largo;
    
    /**
     * valor_compra del activo_fijo.
     */
    @javax.validation.constraints.NotNull(message = "El valor de compra no permite valores nulos. Por favor verifique e intente de nuevo.")
    @NotBlank(message = "El valor de compra  no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Size(max = 45, message = "El valor de compra no puede ser mayor a 45 caracteres")
    private String valorCompra;
    
    /**
     * fecha_compra del activo_fijo.
     */
    @javax.validation.constraints.NotNull(message = "La fecha_compra no permite valores nulos. Por favor verifique e intente de nuevo.")
    @Column(name = "fecha_compra")
    private Date fechaCompra;
    
    /**
     * color del activo_fijo.
     */
    @Size(max = 50, message = "El pero no puede ser mayor a 50 caracteres")
    private String color;
    
    /**
     * tipo del activo_fijo
     */
    @javax.validation.constraints.NotNull(message = "El estado no permite valores nulos. Por favor verifique e intente de nuevo.")
    private Integer estadoId;
}
