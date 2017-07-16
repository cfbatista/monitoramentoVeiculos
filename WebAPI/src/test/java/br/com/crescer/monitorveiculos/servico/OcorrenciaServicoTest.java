package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.repositorio.OcorrenciaRepositorio;
import java.util.Arrays;
import java.util.List;
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
public class OcorrenciaServicoTest {

    @Mock
    private OcorrenciaRepositorio ocorrenciaRepositorio;

    @InjectMocks
    private OcorrenciaServico ocorrenciaServico;

    @Mock
    private Ocorrencia ocorrencia;

    @Before
    public void setUp() {
        when(ocorrencia.getIdocorrencia()).thenReturn(1L);
    }

    @Test
    public void testTodasOcorrencias() {
        final List<Ocorrencia> ocorrencias = Arrays.asList(ocorrencia);
        when(ocorrenciaRepositorio.findAll()).thenReturn(ocorrencias);

        final List<Ocorrencia> obterTodasOcorrencias = ocorrenciaServico.listarTodas();

        assertEquals(ocorrencias, obterTodasOcorrencias);
        verify(ocorrenciaRepositorio).findAll();

    }

    @Test
    public void testCriarOcorrencia() {
        when(ocorrenciaRepositorio.save(ocorrencia)).thenReturn(ocorrencia);
        assertEquals(ocorrencia, ocorrenciaServico.criarOcorrencia(ocorrencia));
    }

    @Test
    public void testObterPorId() {
        when(ocorrenciaRepositorio.findOne(1L)).thenReturn(ocorrencia);

        final Ocorrencia obterOcorrenciaPorId = ocorrenciaServico.obterPorId(1L);

        assertEquals(ocorrencia, obterOcorrenciaPorId);
        verify(ocorrenciaRepositorio).findOne(1L);
    }

    @Test
    public void testListarTodas() {
        final List<Ocorrencia> ocorrencias = Arrays.asList(ocorrencia);
        when(ocorrenciaRepositorio.findAll()).thenReturn(ocorrencias);

        final List<Ocorrencia> obterTodasOcorrencias = ocorrenciaServico.listarTodas();

        assertEquals(ocorrencias, obterTodasOcorrencias);
        verify(ocorrenciaRepositorio).findAll();
    }

}
