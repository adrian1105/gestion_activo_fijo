/*
* Archivo: AreaActivoFijo
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
package co.com.grupoasd.activofijo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author amgonzalez
 */
@Entity
@Table(name = "area_activos_fijos")
@Data
public class AreaActivoFijo implements Serializable {
    /**
     * número de versión que posee cada clase Serializable.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Llave de la tabla area_activos_fijos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer areaActivoId;
    
    /**
     * area_id.
     */
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area areaId;
    
    /**
     * activofijo_id.
     */
    @JoinColumn(name = "activofijo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ActivoFijo activoFijoId;
}
