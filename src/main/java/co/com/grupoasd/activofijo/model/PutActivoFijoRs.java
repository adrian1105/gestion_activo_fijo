/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.model;

import co.com.grupoasd.activofijo.message.Mensaje;
import lombok.Data;

/**
 * Clase para guardar resultset de Optional activo.
 * @author adrian G
 */
@Data
public class PutActivoFijoRs extends Mensaje{
    /**
     * activo fijo para actualizar
     */
    private String nombreActivoFijo;
}
