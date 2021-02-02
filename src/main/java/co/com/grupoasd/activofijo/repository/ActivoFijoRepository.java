/*
* Archivo: ActivoFijoRepository
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
package co.com.grupoasd.activofijo.repository;

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.entity.TipoActivo;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase administradora de los datos.
 * @author adrian G
 */
public interface ActivoFijoRepository extends JpaRepository<ActivoFijo, Integer> {
    
   /**
    * lista de los activos fijos 
    * @param tipoActivo objeto del tipo activo
    * @param fechaCompra fecha compra del activo
    * @param serial serial activo
    * @return la lista de activos sgun los parametros
    */
    List<ActivoFijo> findByTipoIdOrFechaCompraOrSerial(Optional<TipoActivo> tipoActivo, Date fechaCompra, String serial);
    /**
     * obtiene el activo para actualizar
     * @param id
     * @return 
     */
    ActivoFijo findByActivoId(Integer id);
    /**
     * Verificacion del serial del activo
     * @param serial del activo fijo
     * @return  objeto del activo
     */
    ActivoFijo findBySerial(String serial);
}
