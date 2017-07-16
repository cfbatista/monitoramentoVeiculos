package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.repositorio.CidadeRepositorio;
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
public class CidadeServicoTest {

    @Mock
    private CidadeRepositorio cidadeRepositorio;

    @InjectMocks
    private CidadeServico cidadeServico;

    @Mock
    private Cidade cidade;

    @Mock
    private Veiculo veiculo;

    @Before
    public void setUp() {
        when(cidade.getIdcidade()).thenReturn(1L);
        when(veiculo.getCidade()).thenReturn(cidade);
    }

    @Test
    public void testListarCidades() {
        final List<Cidade> cidades = Arrays.asList(cidade);
        when(cidadeRepositorio.findAll()).thenReturn(cidades);

        final List<Cidade> obterTodasCidades = cidadeServico.listarCidades();

        assertEquals(cidades, obterTodasCidades);
        verify(cidadeRepositorio).findAll();
    }

    @Test
    public void testTotalCidades() {
        when(cidadeRepositorio.count()).thenReturn(1L);

        final Long contagem = cidadeServico.totalCidades();
        final Long expected = 1L;

        assertEquals(expected, contagem);
        verify(cidadeRepositorio).count();
    }

    @Test
    public void testPegarCidadePorId() {
        when(cidadeRepositorio.findOne(1L)).thenReturn(cidade);

        final Cidade obterCidadePorId = cidadeServico.pegarCidadePorId(1L);

        assertEquals(cidade, obterCidadePorId);
        verify(cidadeRepositorio).findOne(1L);
    }

    @Test
    public void testNumeroCidadesComRegistros() {
        when(cidadeRepositorio.obterNumeroCidadesComRegistros()).thenReturn(0L);

        final Long contagem = cidadeServico.numeroCidadesComRegistros();
        final Long excepted = 0L;

        assertEquals(excepted, contagem);
        verify(cidadeRepositorio).obterNumeroCidadesComRegistros();
    }

    @Test
    public void testEncontrarCidadeVeiculo() {

        final Long contagem = cidadeServico.numeroCidadesComRegistros();
        final Long excepted = 0L;

        assertEquals(excepted, contagem);
        verify(cidadeRepositorio).obterNumeroCidadesComRegistros();

    }

}
