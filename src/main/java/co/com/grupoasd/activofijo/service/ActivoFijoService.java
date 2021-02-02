/*
* Archivo: ActivoFijoService
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
package co.com.grupoasd.activofijo.service;

import co.com.grupoasd.activofijo.model.ActivoFijoRs;
import co.com.grupoasd.activofijo.model.CreateActivoFijoRq;
import co.com.grupoasd.activofijo.model.CreateActivoFijoRs;
import co.com.grupoasd.activofijo.model.PutActivoFijoRs;
import co.com.grupoasd.activofijo.model.PutActivoFijoRq;

/**
 * Interface de ActivoFijo.
 * @author adrian G
 */
public interface ActivoFijoService {
     /**
     * interfas de servicio para listar activos.
     * @return lista de areas
     */
    ActivoFijoRs getActivoFijo();
    
    /**
     * Buscar activos por parametros
     * @param tipoId id del tipo de activo
     * @param fechaCompra fecha de compra del activo
     * @param serial serial del activo
     * @return 
     */
    ActivoFijoRs getSearchActivoFijo(String tipoId, String fechaCompra, String serial);
    
     /**
     * interfas de servicio para actualizar activos.
     * @param id id del activo
     * @param putActivoFijoRq 
     * @return lista de areas
     */
     PutActivoFijoRs putActivoFijo(Integer id, PutActivoFijoRq putActivoFijoRq);
     
     /**
      * Resultado de creación del cativo
      * @param createActivoFijoRq
      * @return resultado de creación del activo
      */
     CreateActivoFijoRs createActivoFijo(CreateActivoFijoRq createActivoFijoRq);
}
