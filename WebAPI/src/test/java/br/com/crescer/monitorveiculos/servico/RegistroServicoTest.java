package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Registro;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Diandra Rocha
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistroServicoTest {

    @Mock
    private RegistroRepositorio registroRepositorio;

    @InjectMocks
    private RegistroServico registroServico;

    @Mock
    private Registro registro;

    @Before
    public void setUp() {
        when(registro.getIdregistro()).thenReturn(1L);
    }

    @Test
    public void testObterTotalRegistros() {
        when(registroRepositorio.count()).thenReturn(1L);

        final Long contagem = registroServico.obterTotalCameras();
        final Long expected = 1L;

        assertEquals(expected, contagem);
        verify(registroRepositorio).count();
    }

}
