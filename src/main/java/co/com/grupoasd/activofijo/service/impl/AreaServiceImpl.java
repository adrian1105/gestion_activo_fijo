/*
* Archivo: AreaServiceImpl
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
package co.com.grupoasd.activofijo.service.impl;

import co.com.grupoasd.activofijo.entity.Area;
import co.com.grupoasd.activofijo.model.AreaRs;
import co.com.grupoasd.activofijo.repository.AreaRepository;
import co.com.grupoasd.activofijo.service.AreaService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de AreaService. 
 * @author adrian G
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    /**
     * Repositorio AreaRepository.
     */
    private final AreaRepository areaRepository;

    /**
     * Constructor.
     *
     * @param areaRepository repositorio de area
     */
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    /**
     * Implementacion del metodo astacto de la interface.
     *
     * @return lista de areas almacenada en la BD
     */
    @Override
    public AreaRs getArea() {
        AreaRs areaRs = new AreaRs();
        List<Area> areas = areaRepository.findAll();
        if (!areas.isEmpty()) {
            areaRs.setAreas(areas);
            areaRs.setDescripcion(TipoRespuesta.MESSAGE_OK);
            
            return areaRs;
        }
        areaRs.setDescripcion(TipoRespuesta.MESSAGE_NOT_FOUND);
        return areaRs;
    }

}
