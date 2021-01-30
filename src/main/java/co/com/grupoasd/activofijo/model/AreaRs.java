/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.model;

import co.com.grupoasd.activofijo.entity.Area;
import co.com.grupoasd.activofijo.message.Mensaje;
import java.util.List;
import lombok.Data;

/**
 * Clase para guardar resultset de area.
 * @author adrian G
 */
@Data
public class AreaRs extends Mensaje{
    /**
     * lista de las areas.
     */
    private List<Area> areas;
}
