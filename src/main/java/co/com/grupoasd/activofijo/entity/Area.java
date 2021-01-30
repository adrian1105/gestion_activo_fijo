/*
* Archivo: Area
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
@Table(name = "area")
@Data
public class Area implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Llave del área.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    /**
     * nombre del área.
     */
    @NotNull
    @Size(min = 5, max = 150)
    @Column(name = "nombre")
    private String nombre;
    
    /**
     * ciudad de ubicación del área
     */
    @JoinColumn(name = "municipio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    
    /**
     * codigo del área.
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    
}
