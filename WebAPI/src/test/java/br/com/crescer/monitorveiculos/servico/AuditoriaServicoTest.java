package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Auditoria;
import br.com.crescer.monitorveiculos.repositorio.AuditoriaRepositorio;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
public class AuditoriaServicoTest {

    @Mock
    private AuditoriaRepositorio auditoriaRepositorio;

    @InjectMocks
    private AuditoriaServico auditoriaServico;

    @Mock
    private Auditoria auditoria;

    @Test
    public void testSalvar() {
        when(auditoriaRepositorio.save(auditoria)).thenReturn(auditoria);
        assertEquals(auditoria, auditoriaServico.salvar(auditoria));

    }

    @Test
    public void testObterTodas() {

        final List<Auditoria> auditorias = Arrays.asList(auditoria);
        when(auditoriaRepositorio.findAll()).thenReturn(auditorias);

        final List<Auditoria> obterTodasAuditorias = auditoriaServico.obterTodas();

        assertEquals(auditorias, obterTodasAuditorias);
        verify(auditoriaRepositorio).findAll();

    }

}
