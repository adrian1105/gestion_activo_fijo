/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.repository;

import co.com.grupoasd.activofijo.entity.TipoActivo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase administradora de los datos.
 * @author adrian G
 */
public interface TipoActivoRepository extends JpaRepository<TipoActivo, Integer>{
    
}
