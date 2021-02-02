/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.ActivoFijoService;

import co.com.grupoasd.activofijo.api.ActivoFijoApiController;
import co.com.grupoasd.activofijo.model.ActivoFijoRs;
import co.com.grupoasd.activofijo.service.impl.ActivoFijoServiceImpl;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amgonzalez
 */
@ExtendWith(MockitoExtension.class)
@Transactional
public class ActivoFijoServiceImplTest {
    @InjectMocks
    ActivoFijoApiController activoFijoApiController;
    @Mock
    ActivoFijoServiceImpl activoFijoServiceImpl;
    
    @Test
    @DisplayName("listar activos")
    @Transactional(readOnly = true)
    public void obtenerActivos(){
        ActivoFijoRs activoFijoRs = new ActivoFijoRs();
        activoFijoRs.setDescripcion("Mensaja");
        when(activoFijoServiceImpl.getActivoFijo()).thenReturn(activoFijoRs);
        assertNotNull(activoFijoApiController.getActivoFijo().getBody());
    }
}
