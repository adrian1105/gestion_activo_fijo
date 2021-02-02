/*
* Archivo: AreaActivoFijoServiceImpl
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
package co.com.grupoasd.activofijo.service.impl;

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.entity.Area;
import co.com.grupoasd.activofijo.entity.AreaActivoFijo;
import co.com.grupoasd.activofijo.entity.Estado;
import co.com.grupoasd.activofijo.model.AreaActivoFijoRq;
import co.com.grupoasd.activofijo.model.AreaActivoFijoRs;
import co.com.grupoasd.activofijo.repository.ActivoFijoRepository;
import co.com.grupoasd.activofijo.repository.AreaActivoFijoRepository;
import co.com.grupoasd.activofijo.repository.AreaRepository;
import co.com.grupoasd.activofijo.service.AreaActivoFijoService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Implementación de AreaActivoFijoService.
 *
 * @author amgonzalez
 */
@Service
public class AreaActivoFijoServiceImpl implements AreaActivoFijoService {

    /**
     * Repositorio areaActivoFijoRepository
     */
    private final AreaActivoFijoRepository areaActivoFijoRepository;
    /**
     * Repositorio activoFijoRepository
     */
    private final ActivoFijoRepository activoFijoRepository;
    /**
     * Repositorio areaRepository
     */
    private final AreaRepository areaRepository;

    public AreaActivoFijoServiceImpl(AreaActivoFijoRepository areaActivoFijoRepository,
            ActivoFijoRepository activoFijoRepository,
            AreaRepository areaRepository) {
        this.areaActivoFijoRepository = areaActivoFijoRepository;
        this.activoFijoRepository = activoFijoRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public AreaActivoFijoRs createAreaActivo(AreaActivoFijoRq areaActivoFijoRq) {
        AreaActivoFijo areaActivoFijo = new AreaActivoFijo();
        AreaActivoFijoRs areaActivoFijoRs = new AreaActivoFijoRs();

        ActivoFijo activoFijo = activoFijoRepository
                .findByActivoId(areaActivoFijoRq.getActivoId());
        if (activoFijo == null) {
            areaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_FIJO_NOT_FOUND);
            return areaActivoFijoRs;
        }

        if (activoFijo.getEstadoId().getId() == 5) {
            areaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_FIJO_ASIGNADO_NOT_FOUND);
            return areaActivoFijoRs;
        }

        Optional<Area> area = areaRepository.findById(areaActivoFijoRq.getAreaId());
        if (area.isEmpty()) {
            areaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_AREA_NOT_FOUND);
            return areaActivoFijoRs;
        }

        areaActivoFijo.setActivoFijoId(activoFijo);
        areaActivoFijo.setAreaId(area.get());

        areaActivoFijoRepository.save(areaActivoFijo);
        
        areaActivoFijoRs.setAreaActivoFijos(areaActivoFijo);
        Estado estado = new Estado();

        estado.setId(5);
        activoFijo.setEstadoId(estado);
        activoFijoRepository.save(activoFijo);

        areaActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_ACTIVO_OK);

        return areaActivoFijoRs;
    }

}
