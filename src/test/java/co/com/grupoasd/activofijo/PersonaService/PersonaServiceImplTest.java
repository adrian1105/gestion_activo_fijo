/*
* Archivo: PersonaServiceImplTest
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
package co.com.grupoasd.activofijo.PersonaService;

import co.com.grupoasd.activofijo.api.PersonaApiController;
import co.com.grupoasd.activofijo.model.PersonaRs;
import co.com.grupoasd.activofijo.service.impl.PersonaServiceImpl;
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
public class PersonaServiceImplTest {
    @InjectMocks
    PersonaApiController personaApiController;

    @Mock
    PersonaServiceImpl personaServiceImpl;
    
    @Test
    @DisplayName("listar las personas")
    public void obtenerPersonas() {
        PersonaRs personaRs = new PersonaRs();
        personaRs.setDescripcion("Mensaje");
        when(personaServiceImpl.getPersona()).thenReturn(personaRs);
        assertNotNull(personaApiController.getPersona().getBody());
    }
}
