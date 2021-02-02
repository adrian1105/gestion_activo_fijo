/*
* Archivo: ActivoFijo
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
package co.com.grupoasd.activofijo.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Clase entity de la tabla area.
 * @author adrian G
 */
@Entity
@Table(name = "activo_fijo")
@Data
public class ActivoFijo implements Serializable {
    /**
     * número de versión que posee cada clase Serializable.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Llave del activo_fijo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer activoId;
    
    /**
     * nombre del activo_fijo.
     */
    @NotNull
    @Size(min = 5, max = 100, message = "Verifique que el nombre este en el rango de 5 hasta 100 caracteres")
    @Column(name = "nombre")
    private String nombre;
    
    /**
     * descripcion del activo_fijo.
     */
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    
    /**
     * tipo del activo_fijo
     */
    @NotNull
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoActivo tipoId;
    
    /**
     * serial del activo_fijo.
     */
    @NotNull
    @Size(min = 5, max = 45, message = "Verifique que el serial este en el rango de 5 - 45 caracteres")
    @Column(name = "serial", unique = true)
    private String serial;
    
    /**
     * numero interno del activo_fijo.
     */
    @NotNull
    @Size(max = 10, message = "Verifique que el numero interno sea menor a 10 digitos")
    @Column(name = "numero_interno")
    private String numeroInterno;
    
    /**
     * peso del activo_fijo.
     */
    @Size(max = 45, message = "El pero no puede ser mayor a 45 caracteres")
    @Column(name = "peso")
    private String peso;
    
    /**
     * alto del activo_fijo.
     */
    @Size(max = 45, message = "El alto no puede ser mayor a 45 caracteres")
    @Column(name = "alto")
    private String alto;
    
    /**
     * ancho del activo_fijo.
     */
    @Size(max = 45, message = "El ancho no puede ser mayor a 45 caracteres")
    @Column(name = "ancho")
    private String ancho;
    
    /**
     * largo del activo_fijo.
     */
    @Size(max = 45, message = "El largo no puede ser mayor a 45 caracteres")
    @Column(name = "largo")
    private String largo;
    
    /**
     * valor_compra del activo_fijo.
     */
    @NotNull
    @Size(max = 45, message = "El valor de compra no puede ser mayor a 45 caracteres")
    @Column(name = "valor_compra")
    private String valorCompra;
    
    /**
     * fecha_compra del activo_fijo.
     */
    @NotNull
    @Column(name = "fecha_compra")
    private Date fechaCompra;
 
    /**
     * fechaBaja del activo_fijo.
     */
    @Column(name = "fecha_baja")
    private Date fechaBaja;
    
    /**
     * color del activo_fijo.
     */
    @Size(max = 50, message = "El pero no puede ser mayor a 50 caracteres")
    @Column(name = "color")
    private String color;
    
    /**
     * tipo del activo_fijo
     */
    @NotNull
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estadoId;
}



