/*
* Archivo: AreaActivoFijoRepository
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
package co.com.grupoasd.activofijo.repository;

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.entity.Area;
import co.com.grupoasd.activofijo.entity.AreaActivoFijo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amgonzalez
 */
public interface AreaActivoFijoRepository extends JpaRepository<AreaActivoFijo, Integer> {
    AreaActivoFijo findByAreaIdAndActivoFijoId(Area area, ActivoFijo activoFijo);
}
