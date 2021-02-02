/*
* Archivo: AreaServiceImplTest
* Fecha: 01/01/2021
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
package co.com.grupoasd.activofijo.AreaService;

import co.com.grupoasd.activofijo.api.AreaApiController;
import co.com.grupoasd.activofijo.model.AreaRs;
import co.com.grupoasd.activofijo.service.impl.AreaServiceImpl;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author amgonzalez
 */
@ExtendWith(MockitoExtension.class)
public class AreaServiceImplTest {

    @InjectMocks
    AreaApiController areaApiController;

    @Mock
    AreaServiceImpl areaServiceImpl;
    

    @Test
    @DisplayName("listar las áreas.")
    public void obtenerAreas() {
        AreaRs areaRs = new AreaRs();
        areaRs.setDescripcion("Mensaje");
        when(areaServiceImpl.getArea()).thenReturn(areaRs);
        assertNotNull(areaApiController.getArea().getBody());
    }
}