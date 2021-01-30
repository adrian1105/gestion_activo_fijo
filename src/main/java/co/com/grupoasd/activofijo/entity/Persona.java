/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Table(name = "persona")
@Data
public class Persona implements Serializable {
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
    @Size(min = 5, max = 100)
    @Column(name = "nombres")
    private String nombres;
    
    /**
     * nombre del área.
     */
    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    
    /**
     * nombre del área.
     */
    @NotNull
    @Size(min = 10, max = 15)
    @Column(name = "celular")
    private String celular;
    
    /**
     * ciudad de ubicación del área
     */
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area areaId;
}
